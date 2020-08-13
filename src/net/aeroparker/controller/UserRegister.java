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
import javax.websocket.server.PathParam;

import com.mysql.jdbc.StringUtils;

import net.aeroparker.dao.Database;
import net.aeroparker.model.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/Register/*")
public class UserRegister extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// Error states are being declared here
	private boolean nameErr;
	private boolean surnameErr;
	private boolean emailErr;
	private boolean addressErr;
	private boolean addressTwoErr;
	private boolean cityErr;
	private boolean postCodeErr;
	private boolean phoneNumErr;
	private String site = "Avalon City"; 

	// Declaration of database class
	private Database database = new Database();

	// private Database database = new Database();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Server at: ").append(request.getContextPath());
		request.getParameter("site");
		System.out.println("path is: " + request.getParameter("site"));
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) Method that works as post for the form in index.jsp file Takes
	 *      it all the inputs from the form Then checks the input Then it will
	 *      insert the data into the database if the data passes the checking If
	 *      data is not passed by validation, the form will output the error message
	 *      on the page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Collecting the user inputs
		String title = request.getParameter("title");
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postcode = request.getParameter("postcode");
		String phoneNumber = request.getParameter("telephone");
		String addressTwo = request.getParameter("address-two");
		// Connecting to the database
		try {
			database.databaseConnect();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Validating the email address
		// If validation is passed emailErr will be set to false
		// Also checking for the uniqueness of the email
		
		if (emailValidation(email)) {
			System.out.println("Check for Email");
			request.setAttribute("emailError", "Email not valid!");
		} 
		
		//System.out.println(database.checkEmail(email));
		try {
			System.out.println(database.checkEmail(email));
			if (database.checkEmail(email)) {
				System.out.println("Email being used!");
				emailErr = true;
				request.setAttribute("emailError", "Email already used!");
			} else {
				emailErr = false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Validation of the firstname
		if (shortTextValidation(firstname)) {
			System.out.println("Firstname: " + shortTextValidation(firstname));
			nameErr = true;
			request.setAttribute("firstNameError", "Firstname not valid!");
		}

		// Validation of the surname
		if (shortTextValidation(surname) == true) {
			surnameErr = true;
			System.out.println("Surname: " + shortTextValidation(surname));
			request.setAttribute("surnameError", "Surname not valid!");
		}

		// Validation of address
		if (longTextValidation(address)) {
			addressErr = true;
			System.out.println("Check for address");
			request.setAttribute("addressError", "Address not valid!");
		}

		// Validation of second address which is optional so it will also check if it is
		// inputted
		if (addressTwo != "") {
			if (longTextValidation(addressTwo)) {
				addressTwoErr = true;
				System.out.println("Check for addressTwo");
				request.setAttribute("addressTwoError", "Address is not valid!");
			}
		} else {
			addressTwoErr = false;
		}

		// Validation of city
		if (longTextValidation(city)) {
			System.out.println("Check for City:" + city);
			cityErr = true;
			request.setAttribute("cityError", "City not valid!");
		}

		// Validation of phone number which is optional so it will check for the user
		// input
		if (phoneNumber != "") {
			if (phoneNumberValidation(phoneNumber)) {
				System.out.println("phone" + postcodeValidation(phoneNumber));
				request.setAttribute("phoneError", "Phone number not valid!");
			}
		} else {
			phoneNumErr = false;
		}

		// Validation of postcode
		if (postcodeValidation(postcode)) {
			System.out.println("postcode" + postcodeValidation(postcode));
			request.setAttribute("postCodeError", "postcode not valid!");
		}
		


		// Check if all the input passed the validation, if everything is passed the
		// data record will be inserted into the database
		if (emailErr == false && nameErr == false && surnameErr == false & addressErr == false && addressTwoErr == false
				&& cityErr == false && postCodeErr == false && phoneNumErr == false) {
			// User object is being declared and creating
			User user = new User(title, email, firstname, surname, address, addressTwo, city, postcode, phoneNumber);

			try {
				database.registerUser(user);
				int customerID = database.getCustomerId(email);
				int siteID = database.getSiteId(site);
				database.insertSite(siteID, customerID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Success.jsp");
			dispatcher.forward(request, response);
		} else {
			// System.out.println(address);
			request.setAttribute("email", email);
			request.setAttribute("firstname", firstname);
			request.setAttribute("surname", surname);
			request.setAttribute("address", address);
			request.setAttribute("addressTwo", addressTwo);
			request.setAttribute("city", city);
			request.setAttribute("telephone", phoneNumber);
			request.setAttribute("postcode", postcode);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	private boolean emailValidation(String email) {
		String regex = "^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,})+)$";
		if (email.matches(regex)) {
			emailErr = false;
			return emailErr;
		} else {
			emailErr = true;
			return emailErr;
		}
	}

	private boolean phoneNumberValidation(String phoneNumber) {
		String regex = "^\\+?\\d{11,20}";

		if (phoneNumber.matches(regex) == true) {
			phoneNumErr = false;
			return phoneNumErr;
		} else {
			phoneNumErr = true;
			return phoneNumErr;
		}
	}

	private boolean longTextValidation(String longText) {
		String regex = "^[a-zA-Z\\d]*(\\s[a-zA-Z\\d]*$)?";
		if (longText.matches(regex) == true) {
			return false;
		} else {
			return true;
		}
	}

	private boolean postcodeValidation(String postCode) {
		String regex = "^([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})$";
		if (postCode.matches(regex) == true) {
			postCodeErr = false;
			return postCodeErr;
		} else {
			postCodeErr = true;
			return postCodeErr;
		}
	}

	private boolean shortTextValidation(String shortText) {
		String regex = "^[a-zA-Z\\d]*(\\s[a-zA-Z\\d]*$)?";
		if (shortText.length() <= 50) {
			if (shortText.matches(regex) == true) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}
}
