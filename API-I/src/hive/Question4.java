package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Question4 {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	   private static Connection con = null;
	   private static Statement stmt = null;
	   private static ResultSet rs = null;

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	      // Register driver and create driver instance
		   
	      Class.forName(driverName);
	      // get connection
	      
	       con = DriverManager.getConnection("jdbc:hive2://localhost:10000/bks", "", "");
	       stmt = con.createStatement();
	       
	       stmt.execute("use bks");
	      
		      rs = stmt.executeQuery("select e.first_name, avg(s.salary) "
		      		+ "as avgSalary "
		      		+ "from employee "
		      		+ "as e join salary "
		      		+ "as s on (e.emp_id == s.emp_id) group by e.first_name order by avgSalary limit 10");
		       int columns = rs.getMetaData().getColumnCount();
		       while (rs.next()) {
		         for ( int i = 0 ; i < columns; ++i) {
		            System.out.print(rs.getString(i + 1) + " " );
		            
		         }
		         System.out.println();
		       }
	       
	      
	      con.close();
	}

}