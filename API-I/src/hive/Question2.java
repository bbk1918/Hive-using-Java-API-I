package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Question2 {
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
	      
	       
		   // Load data into employee table
		     stmt.execute("LOAD DATA LOCAL INPATH '/home/cloudera/employee.csv' INTO TABLE employee");
		     System.out.println("Load Data into employee successful");
		      
		  // Load data into Salary table
		     stmt.execute("LOAD DATA LOCAL INPATH '/home/cloudera/salary.csv' INTO TABLE salary");
		     System.out.println("Load Data into salary successful");	   
	      
	      con.close();
	}

}
