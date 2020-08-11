package webApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	 public Database() throws Exception{
			
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/AeroParker";
		String username = "root";
		String password = "AeroParker123";
		
		try {
		      Class.forName("com.mysql.jdbc.Driver");
		      con = DriverManager.getConnection(url, username, password);

		      System.out.println("Connected!");

		    } catch (SQLException ex) {
		        throw new Error("Error ", ex);
		    } finally {
		      try {
		        if (con != null) {
		            con.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
		System.out.println("Test");
	}
	 
	 public void insertSql() {
		 
	 }
}
