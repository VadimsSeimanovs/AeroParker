package net.aeroparker.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.aeroparker.dao.Database;
import net.aeroparker.model.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//private Database database = new Database();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Server at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Success.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String firstname = request.getParameter("first-name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("e-mail");
		String address = request.getParameter("address");
		String addressTwo = request.getParameter("address-two");
		String city = request.getParameter("city");
		String postcode = request.getParameter("postcode");
		String phoneNumber = request.getParameter("telephone");
		int number = Integer.parseInt(phoneNumber);
		User user = new User(title, email,firstname, surname, address, addressTwo, city, postcode, number);
		
		
		try {
			Database database = new Database();
			database.registerUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Success.jsp");
		dispatcher.forward(request, response);
	}

}
