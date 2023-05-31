package bankmanagementsystem;
import java.sql.Connection;
import java.sql.*;
import java.io.*;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		
	  String url  = "jdbc:mysql://localhost:3306/sonoo"; // table details
       String username = "root"; // MySQL credentials
       String password = "1234";
	   Class.forName( "com.mysql.cj.jdbc.Driver");  
	   Connection connection = DriverManager.getConnection(url, username, password);
	   Statement stmt=connection.createStatement();
	  ResultSet rs=stmt.executeQuery("select * from emp"); 
	  while(rs.next()) {
		 String name= rs.getString("id");
		 System.out.println(name);
	  }
      stmt.close();
	  connection.close();
	}
}


