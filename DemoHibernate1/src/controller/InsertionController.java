package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ValueObject.Student;
import model.DAO;

/**
 * Servlet implementation class InsertionController
 */
@WebServlet("/InsertionController")
public class InsertionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("nmname");
		int rollno = Integer.parseInt(request.getParameter("nmrollno"));
		int marks = Integer.parseInt(request.getParameter("nmmarks"));
		
		Student s = new Student();
		s.setName(name);
		s.setRollno(rollno);
		s.setMarks(marks);
		
		DAO dao = new DAO();
		dao.insertIntoStudent(s);
		response.sendRedirect("Display.jsp");
	}

}
