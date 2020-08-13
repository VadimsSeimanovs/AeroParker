package net.aeroparker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;

import net.aeroparker.dao.Database;
import net.aeroparker.model.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private boolean nameErr;
	private boolean surnameErr;
	private boolean emailErr;
	private boolean addressErr;
	private boolean addressTwoErr;
	private boolean cityErr;
	private boolean postCodeErr;
	private boolean phoneNumErr;
	private Database database = new Database();
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
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postcode = request.getParameter("postcode");
		String phoneNumber = request.getParameter("telephone");
		String addressTwo = request.getParameter("address-two");
		
		try {
			database.databaseConnect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(emailValidation(email)) {
			System.out.println("Check for Email");
			request.setAttribute("emailError", "Email not valid!");
		} else
			try {
				if(database.checkEmail(email)) {
					emailErr = true;
					request.setAttribute("emailError", "Email already used!");
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		if(shortTextValidation(firstname)) {
			nameErr = true;
			//System.out.println("Check for firstname");
			request.setAttribute("firstNameError", "Firstname not valid!");
		}
		System.out.println(longTextValidation(address));
		if(shortTextValidation(surname)) {
			surnameErr = true;
			//System.out.println("Check for surname");
			request.setAttribute("surnameError", "Surname not valid!");
		}
		
		if(longTextValidation(address)) {
			addressErr = true;
			//System.out.println("Check for address");
			request.setAttribute("addressError", "Address not valid!");
		}
		
		if(addressTwo != "") {
			if(longTextValidation(addressTwo)) {
				addressTwoErr = true;
				//System.out.println("Check for addressTwo");
				request.setAttribute("addressTwoError", "Address is not valid!");
			}
		}else {
			addressTwoErr = false;
		}
		
		if(longTextValidation(city)) {
			cityErr = true;
			//System.out.println("Check for City");
			request.setAttribute("cityError", "City not valid!");
		}
		if(phoneNumber != "") {
			if(phoneNumberValidation(phoneNumber)) {
				//System.out.println("Check for phoneNumber");
				request.setAttribute("phoneError", "Phone number not valid!");
			}
		}else {
			phoneNumErr = false;
		}
		
		
		if(postcodeValidation(postcode)) {
			//System.out.println("Check for postcode");
			request.setAttribute("postcodeError", "postcode not valid!");
		}
		
		System.out.println("Email: " + emailErr + " name: " + nameErr + " addressErr: " +addressErr);
		
		if(emailErr == false &&  nameErr == false && surnameErr == false & addressErr == false && addressTwoErr == false && cityErr == false && postCodeErr == false && phoneNumErr == false) {
			System.out.println(emailValidation(email));
			
			int number = Integer.parseInt(phoneNumber);
			
			User user = new User(title, email, firstname, surname, address, addressTwo, city, postcode, number);
				
			try {
				Database database = new Database();
				database.databaseConnect();
				//database.checkEmail(email);
				database.registerUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println("Redirect");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Success.jsp");
			dispatcher.forward(request, response);
		}
		else {
			System.out.println(address);
			request.setAttribute("email", email);
			request.setAttribute("firstname", firstname);
			request.setAttribute("surname", surname);
			request.setAttribute("address", address);
			request.setAttribute("addressTwo", addressTwo);
			request.setAttribute("city", city);
			request.setAttribute("telephone", phoneNumber);
			request.setAttribute("postcode", postcode);
			System.out.println("Redirect");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	private boolean emailValidation(String email) {
		String regex = "^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,})+)$";
		if(email.matches(regex) == true) {
			emailErr = false;
			return emailErr;
		}else {
			emailErr = true;
			return emailErr;
		}
	}
	
	private boolean phoneNumberValidation(String phoneNumber) {
		String regex = "\\d*";
		
		if(phoneNumber.matches(regex) == true) {
			phoneNumErr = false;
			return phoneNumErr;
		}else {
			phoneNumErr = true;
			return phoneNumErr;
		}
	}
	
	private boolean longTextValidation(String longText) {
		String regex = "[a-zA-Z]*";
		if(longText.matches(regex) == true) {
			return false;
		}else {
			return true;
		}
	}
	
	private boolean postcodeValidation(String postCode) {
		String regex = "^([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})$";
		if(postCode.matches(regex) == true) {
			postCodeErr = false;
			return postCodeErr;
		}else {
			postCodeErr=true;
			return postCodeErr;
		}
	}
	
	private boolean shortTextValidation(String shortText) {
		String regex = "[a-zA-Z]*";
		if(shortText.length() <= 50) {
			if(shortText.matches(regex) == true) {
				return false;
			}else {
				return true;
			}
		}else {
			return true;
		}
	}
	
}
