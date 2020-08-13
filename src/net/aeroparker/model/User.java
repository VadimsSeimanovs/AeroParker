package net.aeroparker.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServlet;

/**
 * 
 */

/**
 * @author Vadims
 *
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
	public String getRegisteredTime() {
		return registeredTime;
	}
	public void setRegisteredTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		registeredTime = dtf.format(now);
		System.out.println(registeredTime);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
