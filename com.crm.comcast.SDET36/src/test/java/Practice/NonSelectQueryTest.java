package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException
	{
		int gh=0;
		Connection conn=null;
		try
		{
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		//System.out.println("connection is done");
		
		
		Statement stat=conn.createStatement();
	     String querry = "insert into students_info values('8','Suv','sekh','s')";
	                gh = stat.executeUpdate(querry);
	             /*  while(gh.next())
	               {
	            	   System.out.println(gh.getString(7));
	               }*/
		}
		catch(Exception e)
		
		{
			
		}
		finally {
			if(gh==1) {
				System.out.println("students info inserted successfully");
			}
			else {
				System.out.println("not inserted");
			}
			conn.close();
		}
		}

}
