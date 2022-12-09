package quanly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import quanly.entity.Entity;
import quanly.service.AppService;

import java.security.Principal;
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {

    //injecting customer service
    @Autowired //biến cục bộ
    private AppService appService;

    @GetMapping("/list")
    //(retrieve a list) truy xuất 1 hoặc nhiều resources dùng ánh xạ các yêu cầu http get vào các phương thức xử lý
    public String listCustomer(Model theModel, Principal principal) {
        List<Entity> list = appService.getAll();
        if (principal != null) {
            String username = principal.getName();
            theModel.addAttribute("username", username);
        }
        theModel.addAttribute("listData", list);
        return "list";
    }

    @GetMapping("/search") //truy xuất
    public String searchCustomer(Model theModel, @RequestParam("brand") String query) {

        //get customer from dao
        List<Entity> list = appService.search(query);


        //add customer to the model
        theModel.addAttribute("listData", list);

        return "list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Entity object = new Entity();

        theModel.addAttribute("object", object);
        return "form";
    }

    @PostMapping("/save") // create new invoice,dùng ánh xạ các yêu cầu http post vào các phương thức xử lý
    public String saveDienthoai(@ModelAttribute("object") Entity object) {

        appService.save(object);

        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
        Entity object = appService.getById(theId);
        theModel.addAttribute("object", object);
        return "form";
    }

    @GetMapping("/delete")
    public String showFormDelete(@RequestParam("id") int theId) {

        appService.delete(theId);

        return "redirect:/list";

    }

}
