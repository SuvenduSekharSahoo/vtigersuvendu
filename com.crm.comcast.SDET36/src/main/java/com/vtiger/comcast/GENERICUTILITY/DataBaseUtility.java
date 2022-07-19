package com.vtiger.comcast.GENERICUTILITY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	static Driver driver;
	static Connection connection;
	static ResultSet result;

	/**
	 * This method will perform the mysql database connection
	 * @throws SQLException
	 */
	public void connectDB() throws SQLException {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		try
		{
		  connection.close();
		}
		catch (Exception e)
		{
		}
	}

	/**
	 * This method will execute the querry
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query) throws Throwable {	
		result = connection.createStatement().executeQuery(query);
		return result;		
}

	/**
	 * This method will update the querry
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public int executeUpdate(String query) throws Throwable {
		
		int result = connection.createStatement().executeUpdate(query);

	return result;

}


}
