package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Question1 {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	   private static Connection con = null;
	   private static Statement stmt = null;

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	      // Register driver and create driver instance
		   
	      Class.forName(driverName);
	      // get connection
	      
	       con = DriverManager.getConnection("jdbc:hive2://localhost:10000/bks", "", "");
	       stmt = con.createStatement();
	       
	       stmt.execute("use bks");
	      
	       
	    // create table employee
	       stmt.execute("CREATE TABLE IF NOT EXISTS"
	  	         +" employee ( emp_id int, birthday String,"
	  	         +" first_name String, last_name String, gender varchar(5), work_day String)"
	  	         +" COMMENT 'Employee details'"
	  	         +" ROW FORMAT DELIMITED"
	  	         +" FIELDS TERMINATED BY ','"
	  	         +" LINES TERMINATED BY '\n'"
	  	         +" STORED AS TEXTFILE"); 
	  	      System.out.println("Table employee created");
	 
	  	      
	  	    // create table salary
		       stmt.execute("CREATE TABLE IF NOT EXISTS"
		  	         +" Salary ( emp_id int, salary String,"
		  	         +" start_date String, end_date String)"
		  	         +" COMMENT 'Salary details'"
		  	         +" ROW FORMAT DELIMITED"
		  	         +" FIELDS TERMINATED BY ','"
		  	         +" LINES TERMINATED BY '\n'"
		  	         +" STORED AS TEXTFILE"); 
		  	      System.out.println("Table salary created");
	      
	      con.close();
	}

}