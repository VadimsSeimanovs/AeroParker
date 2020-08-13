package net.aeroparker.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServlet;

/**
 * 
 */

/**
 * This is a model class which will be used to store and retrieve information from the user as well as the database
 * 
 * @author Vadims Seimanovs
 */
public class User extends HttpServlet{
	
	private String registeredTime;
	private String email;
	private String title;
	private String firstName;
	private String lastName;
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String postcode;
	private String phoneNumber;
	private String site = "AvaloneCity";
	
	/*
	 * Constructor for user object
	 * @param title, email,firstName, lastName, addressLineOne, addressLineTwo, city, postcode, phoneNumber
	 * also sets the time of the registration
	 */
	public User(String title, String email, String firstName, String lastName, String addressLineOne, String addressLineTwo, String city, String postcode, String phoneNumber){
		this.title = title;
		this.email = email.toLowerCase();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.city = city;
		this.postcode = postcode;
		this.phoneNumber = phoneNumber;
		
		setRegisteredTime();
	}
	/*
	 * Get method for time that user registered in
	 * @return registeredTime
	 */
	public String getRegisteredTime() {
		return registeredTime;
	}
	
	/*
	 * Method that uses a DataTimeFormatter class from time library
	 * also it creates a local time object so that user can be registered with the time stamp and inserted into the database
	 * the value is being stored as a global variable of this class
	 */
	public void setRegisteredTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		registeredTime = dtf.format(now);
	}
	
	/*
	 * Get method to retrieve email address that customer have inputed
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/*
	 * Set email method for the change of the email or other purposes
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	
	/*
	 * Get title method to get users title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/*
	 * Set method to set the title for the user
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*
	 * Get first name method to get users name
	 * @return firstname
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/*
	 * Set method to set the firstname for the user
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/*
	 * Get last name method to get users surname
	 * @return lastname
	 */
	public String getLastName() {
		return lastName;
	}
	
	/*
	 * Set method to set the lastname for the user
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/*
	 * Get first address method to get users first address which is not optional
	 * @return addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}
	
	/*
	 * Set method to set the first address for the user
	 * @param addressLineOne
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	
	/*
	 * Get second address method to get users second address which is optional
	 * @return addressLineTwo
	 */
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	
	/*
	 * Set method to set the second address for the user
	 * @param addressLineTwo
	 */
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	
	/*
	 * Get city method to get users city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	
	/*
	 * Set method to set the city for the user
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/*
	 * Get postcode method to get users postcode
	 * @return postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	
	/*
	 * Set method to set the postcode for the user
	 * @param postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	/*
	 * Get phone number method to get users phone number
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/*
	 * Set method to set the phone number for the user
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/*
	 * Set method to set the site for the user
	 * @param site
	 */
	public void setSite(String site) {
		this.site = site;
	}
	
	/*
	 * Get site that user have used to register 
	 * @return site
	 */
	public String getSite() {
		return site;
	}
}
