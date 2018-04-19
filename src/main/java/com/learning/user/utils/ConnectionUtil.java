package com.learning.user.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	private ConnectionUtil() {
	}

	public static Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");

			// create a database connection
			// connection =
			// DriverManager.getConnection("jdbc:sqlite:sample.db");
			connection = DriverManager.getConnection("jdbc:sqlite:/home/braj/Dev/db/sqllite/test.db");
			if (connection != null) {
				System.out.println("Connection created sucessfully.");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}

		return connection;

	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// connection close failed.
			System.err.println(e);
		}
	}
	
	/**close Result Set */
	public synchronized static void closeRS(ResultSet rs){
		if(rs!=null){
			try{rs.close();}catch(Exception e){}		
		}
	}
	/**close Statement */
	public synchronized static void closeStmt(Statement stmt){
		if(stmt!=null){
			try{stmt.close();}catch(Exception e){}		
		}
	}
	/**close Statement */
	public synchronized static void closePStmt(PreparedStatement stmt){
		if(stmt!=null){
			try{stmt.close();}catch(Exception e){}		
		}
	}

}
