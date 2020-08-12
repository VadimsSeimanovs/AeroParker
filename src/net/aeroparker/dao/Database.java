package net.aeroparker.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

import net.aeroparker.model.User;

public class Database {
	public int registerUser(User user)  throws ClassNotFoundException{
		int result = 0;
		String url = "jdbc:mysql://localhost:3306/AeroParker";
		String username = "root";
		String password = "AeroParker123";
		Class.forName("com.mysql.jdbc.Driver");
		String INSERT_USERS_SQL = "INSERT INTO aeroparker.customers " + 
	"(ID, REGISTERED, E-MAIL ADDRESS, TITLE, FIRST NAME, LAST NAME, ADDRESS LINE 1, ADDRESS LINE 2, CITY, POSTCODE, TELEPHONE NUMBER) VALUES " +
		"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
		     Connection con = DriverManager.getConnection(url, username, password);

		     System.out.println("Connected!");
		     System.out.println("Test");
		   
		     PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(2, user.getRegisteredTime());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4,user.getTitle());
			preparedStatement.setString(5, user.getFirstName());
			preparedStatement.setString(6,user.getLastName());
			preparedStatement.setString(7,user.getAddressLineOne());
			preparedStatement.setString(8,user.getAddressLineTwo());
			preparedStatement.setString(9,user.getCity());
			preparedStatement.setString(10,user.getPostcode());
			preparedStatement.setInt(11,user.getPhoneNumber());
			
			System.out.println(preparedStatement);
			
			//result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Test here!");
		return result;
	}
	 
	 public void insertSql() {
		 
	 }
}