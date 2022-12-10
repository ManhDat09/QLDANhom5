package bep;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerSerlet
 */
@WebServlet("/bepControllerServlet")
public class bepControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bepDbUtil bepDbUtil;
	@Resource(name="jdbc/bep_buimanhdat")
	private DataSource dataSource;
	@Override
	public void init() throws ServletException {
	super.init();
	
	// create our student db util ... and pass in the conn pool / datasource
	try {
	bepDbUtil = new bepDbUtil(dataSource);
	}
	catch (Exception exc) {
	throw new ServletException(exc);
	    }
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			// if the command is missing, then default to listing students
			if (theCommand == null) {
			theCommand = "LIST";
			}
			// route to the appropriate method
			switch (theCommand) {
			case "LIST":
			listbeps(request, response);
			break;
			case "ADD":
			addbeps(request, response);
			break;
			case "LOAD":
			loadbeps(request, response);
			break;
			case "UPDATE":
			updatebep(request, response);
			break;
			case "DELETE":
			deletebep(request, response);
			break;
			default:
			listbeps(request, response);
			    }
			 }
			catch (Exception exc) {
			throw new ServletException(exc);
			   }
			}
			private void loadbeps(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

			private void addbeps(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

			private void listbeps(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

			private void deletebep(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				// read student id from form data
				String thebepmabep = request.getParameter("bepmabep");
				// delete student from database
				bepDbUtil.deletebep(thebepmabep);
				// send them back to "list students" page
				listbeps(request, response);
				
			}
			private void updatebep(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				int mabep = Integer.parseInt(request.getParameter("mabep"));
				String tenbep = request.getParameter("tenbep");
				Float soluong = request.getParameter("soluong");
				String Nhasanxuat = request.getParameter("Nhasanxuat");
				Float Tonkho = request.getParameter("Tonkho");
				Float SoNambaohanh = request.getParameter("SoNambaohanh");
				// create a new student object
				bep thebep = new bep(mabep, tenbep, soluong,Nhasanxuat, Tonkho, SoNambaohanh );
				// perform update on database
				bepDbUtil.updatebep(thebep);
				// send them back to the "list students" page
				listStudents(request, response);
			
			}
			private void loadStudent(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
				// read student id from form data
				String thebepmabep = request.getParameter("bepmabep");
				// get student from database (db util)
				bep thebep = bepDbUtil.getbep(thebepmabep);
				// place student in the request attribute
				request.setAttribute("THE_BEP", thebep);
				// send to jsp page: update-student-form.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("/update-bep-form.jsp");
				dispatcher.forward(request, response);
			}
			private void addStudent(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
				// read student info from form data
				String tenbep = request.getParameter("tenbep");
				Float soluong = request.getParameter("soluong");
				String Nhasanxuat = request.getParameter("Nhasanxuat");
				Float Tonkho = request.getParameter("Tonkho");
				Float SoNambaohanh = request.getParameter("SoNambaohanh");
				// create a new student object
				bep thebep = new bep(mabep, tenbep, soluong,Nhasanxuat, Tonkho, SoNambaohanh);
				// add the student to the database
				bepDbUtil.addbep(thebep);
				// send back to main page (the student list)
				listbep(request, response);
				
			}
			private void listStudents(HttpServletRequest request, HttpServletResponse 
			response) 
			throws Exception {
			// get students from db util
			List<bep> beps = bepDbUtil.getbeps();
			// add students to the request
			request.setAttribute("BEP_LIST", beps);
			// send to JSP page (view)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-beps.jsp");
			dispatcher.forward(request, response);
			}
	
}

