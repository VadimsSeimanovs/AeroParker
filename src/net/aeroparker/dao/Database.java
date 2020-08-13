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

/*
 * This is a Database class which manages all the statement and connections related with the database.
 * @author Vadims Seimanovs
 */
public class Database {
	
	protected Connection con;
	protected int customerID;
	protected int siteID;
	
	/*
	 * Method that establishes connection to the database so that it doesnt have to be called a lot of times
	 */
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
	
	/*
	 * Method for registering users and inserting their records into the database
	 * @param user
	 * @return result
	 */
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
	/*
	 * Method for checking if the email record is already existing in the database
	 * @param email
	 * @return boolean
	 */
	public boolean checkEmail(String email) throws SQLException {
		String sql = "SELECT " + "`E-MAIL ADDRESS` " + "FROM aeroparker.customers WHERE " + "`E-MAIL ADDRESS` " + "= ?";
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
	
	/*
	 * Method for getting the customerID based on the email that they have provided
	 * This method is used in the Controller class: UserRegister
	 * @param email
	 * @return customerID
	 */
	public int getCustomerId(String email) throws SQLException{
		String customerIdSql = "SELECT `ID` FROM aeroparker.customers WHERE `E-MAIL ADDRESS` = ?";
		PreparedStatement prepStm = (PreparedStatement) con.prepareStatement(customerIdSql);
		prepStm.setString(1, email);
		ResultSet rs = prepStm.executeQuery();
		
		//Store the CustomerID
		System.out.println(prepStm);
		if(rs.next()){
			customerID = rs.getInt("ID");
		}
		System.out.println("CustomerID: " + customerID);
		return customerID;
	}
	
	/*
	 * Method for getting the siteID from the sites database
	 * This method is used in the controller class: UserRegister
	 * @param site
	 * @return siteID
	 */
	public int getSiteId(String site) throws SQLException{
		String siteIdSql = "SELECT `ID` FROM aeroparker.sites WHERE `NAME` = ?";
		PreparedStatement prepStm = (PreparedStatement) con.prepareStatement(siteIdSql);
		prepStm.setString(1, site);
		ResultSet rs = prepStm.executeQuery();
		System.out.println(prepStm);
		
		if(rs.next()){
			siteID = rs.getInt("ID");
		}
		System.out.println("SiteID: " + siteID);
		return siteID;
	}
	
	/*
	 * Method for inserting the siteID and customerID into the relational database
	 * @param siteID, customerID
	 */
	
	public void insertSite(int siteID, int customerID) throws SQLException{
		String siteIdSql = "INSERT INTO aeroparker.`customer sites` (CUSTOMER_ID, SITE_ID) VALUES (?, ?)";
		PreparedStatement prepStm = (PreparedStatement) con.prepareStatement(siteIdSql);
		prepStm.setInt(1, customerID);
		prepStm.setInt(2, siteID);
		
		System.out.println(prepStm);
		
		prepStm.executeUpdate();
	}
	
}