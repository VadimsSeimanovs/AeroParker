package net.aeroparker.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

import net.aeroparker.model.User;

public class Database {
	
	Connection con;
	
	public void databaseConnect() throws ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/AeroParker";
		String username = "root";
		String password = "AeroParker123";
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
		     con = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int registerUser(User user)  throws ClassNotFoundException{
		int result = 0;

		String INSERT_USERS_SQL = "INSERT INTO aeroparker.customers " + 
	"(REGISTERED, `E-MAIL ADDRESS`, TITLE, `FIRST NAME`, `LAST NAME`, `ADDRESS LINE 1`, `ADDRESS LINE 2`, CITY, POSTCODE, `TELEPHONE NUMBER`) VALUES " +
		"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {


		     //System.out.println("Connected!");
		   
		     PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, user.getRegisteredTime());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3,user.getTitle());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5,user.getLastName());
			preparedStatement.setString(6,user.getAddressLineOne());
			preparedStatement.setString(7,user.getAddressLineTwo());
			preparedStatement.setString(8,user.getCity());
			preparedStatement.setString(9,user.getPostcode());
			preparedStatement.setString(10,user.getPhoneNumber());
			
			System.out.println("Here is statement");
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}
	 
	public boolean checkEmail(String email) throws SQLException {
		String sql = "SELECT " + "'E-MAIL ADDRESS' " + "FROM aeroparker.customers WHERE " + "'E-MAIL ADDRESS' " + "= ?";
		PreparedStatement prepStm = (PreparedStatement) con.prepareStatement(sql);
		prepStm.setString(1, email);
		
		ResultSet rs = prepStm.executeQuery();
		System.out.println(prepStm);
		if (rs.next()) {
			return true;
			} else {
			return false;
		}
	}
	
	
}