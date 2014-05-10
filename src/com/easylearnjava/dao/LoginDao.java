package com.easylearnjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.easylearnjava.exception.DaoException;
import com.easylearnjava.util.Constants;

public class LoginDao {
	
	String driver;
	String url;
	String userName;
	String password;

	/**
	 * Method which fetches password for the user name from the data base
	 * @param userName
	 * @return
	 */
	public String getUserPassword(String userName){

		Connection conn;
		PreparedStatement stmt;
		String passwordFromDB = null;

		try {
			conn = getDBConnection(); //get the data base connection object
			String sql = "SELECT user_password FROM  USER where user_name = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);

			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				passwordFromDB = res.getString("USER_PASSWORD");
			}
			conn.close(); //close the database connection
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DaoException(Constants.GLOBAL_EXCEPTION_MESSAGE);
		}
		return passwordFromDB;
	}

	
	public Connection getDBConnection() throws SQLException {
		Connection conn = null;
		try {
			loadDbProperties();
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			//give back the database connection object to the caller
			return conn;
		} catch (Exception ex) {
			throw new SQLException(ex.getMessage());
		}
	}

	/**
	 * Read the DB configuration parameters from the .properties file using ResourceBundle class
	 */
	public void loadDbProperties() {
		//Resource bundle looks for a file named dbParameters.properties in the class path
		ResourceBundle labels = ResourceBundle.getBundle("com/easylearnjava/resources/dbParameters");
		driver = labels.getString("DB_DRIVER");
		url = labels.getString("DB_URL");
		userName = labels.getString("DB_USER");
		password = labels.getString("DB_PASSWORD");
	}
	
}
