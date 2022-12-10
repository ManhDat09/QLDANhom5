package crud.server.controller;

import crud.server.model.Khoangsan;

import crud.server.repository.KhoangsanRepository;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class KhoangsanController {

  @Autowired
  KhoangsanRepository khoangsanRepository;

  @GetMapping("/khoangsans")
  public ResponseEntity<List<Khoangsan>> getAllKhoangsans(
		    @RequestParam(required = false) String tenKhoangSan
		  ) {
		    try {
		      List<Khoangsan> khoangsans = new ArrayList<Khoangsan>();
		      if (tenKhoangSan == null) khoangsanRepository
		        .findAll()
		        .forEach(khoangsans::add); 
		      else khoangsanRepository
		        .findByTenKhoangSanContaining(tenKhoangSan)
		        .forEach(khoangsans::add);
		      if (khoangsans.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(khoangsans, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

		  @GetMapping("/khoangsans/{maks_quang}")
		  public ResponseEntity<Khoangsan> getKhoangsanById(@PathVariable("maks_quang") long maks_quang) {
		    java.util.Optional<Khoangsan> khoangsanData = khoangsanRepository.findById(maks_quang);
		    if (khoangsanData.isPresent()) {
		      return new ResponseEntity<>(khoangsanData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  }

		  @PostMapping("/khoangsans")
		  public ResponseEntity<Khoangsan> createKhoangsan(
		    @RequestBody Khoangsan khoangsan
		  ) {
		    try {
		    	Khoangsan _khoangsan = khoangsanRepository.save(
		        new Khoangsan(
		        		khoangsan.getTenKhoangSan(),
		        		khoangsan.getTenMoKS(),
		        		khoangsan.getTruLuong(),
		        		khoangsan.getDiaChiMoKS()
		        		)
		      );
		      return new ResponseEntity<>(_khoangsan, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

		  @PutMapping("/khoangsans/{maks_quang}")
		  public ResponseEntity<Khoangsan> updateKhoangsan(
		    @PathVariable("maks_quang") long maks_quang,
		    @RequestBody Khoangsan khoangsan
		  ) {
		    java.util.Optional<Khoangsan> khoangsanData = khoangsanRepository.findById(maks_quang);
		    if (khoangsanData.isPresent()) {
		    	Khoangsan _khoangsan = khoangsanData.get();
		    	_khoangsan.setTenKhoangSan(khoangsan.getTenKhoangSan());
		    	_khoangsan.setTenMoKS(khoangsan.getTenMoKS());
		    	_khoangsan.setTruLuong(khoangsan.getTruLuong());
		    	_khoangsan.setDiaChiMoKS(khoangsan.getDiaChiMoKS());
		      return new ResponseEntity<>(
		    		  khoangsanRepository.save(_khoangsan),
		        HttpStatus.OK
		      );
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  }

		  @DeleteMapping("/khoangsans/{maks_quang}")
		  public ResponseEntity<HttpStatus> deleteKhoangsan(
		    @PathVariable("maks_quang") long maks_quang
		  ) {
		    try {
		    	khoangsanRepository.deleteById(maks_quang);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

		  @DeleteMapping("/khoangsans")
		  public ResponseEntity<HttpStatus> deleteAllKhoangsans() {
		    try {
		    	khoangsanRepository.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }

//		  @GetMapping("/students/published")
//		  public ResponseEntity<List<HocSinh>> findByDadonghocphi() {
//		    try {
//		      List<HocSinh> students = hocsinhRepository.findByDadonghocphi(false);
//		      if (students.isEmpty()) {
//		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		      }
//		      return new ResponseEntity<>(students, HttpStatus.OK);
//		    } catch (Exception e) {
//		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//		  }
		}
