package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
	

	public static void main(String[] args) throws SQLException {
		 
	
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("connection is done");
		try
		{
		Statement stat=conn.createStatement();
		String query= "select* from students_info";
		ResultSet resultset=stat.executeQuery(query);
		while(resultset.next())
		{
			System.out.println(resultset.getInt(1));
			
			System.out.println(resultset.getString(2));
		}
	}
	
	catch(Exception e)
	{
		
	}
	finally
	{
		conn.close();
	}

	}
	}

