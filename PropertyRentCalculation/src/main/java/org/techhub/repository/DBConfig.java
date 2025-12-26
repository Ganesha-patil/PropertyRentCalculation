package org.techhub.repository;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;



public class DBConfig {
	protected static DBConfig db;
	protected static Connection conn;
	protected static PreparedStatement stmt;
	protected static ResultSet rs;
	protected static CallableStatement cstmt;
	

	protected DBConfig() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties props = new Properties();
			FileInputStream inputStream = new FileInputStream("src/main/resources/db.properties");
			props.load(inputStream);
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");

			conn = DriverManager.getConnection(url,username,password);
			if (conn != null) {
				System.out.println("Database Connected Successfully ..");
			} else {
				System.out.println("Database Connection Failed !!");
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		} 
	}
}

//	public static synchronized DBConfig getInstance() {
//		if (db == null) {
//			db = new DBConfig();
//		}
//		return db;
//	}
//
//	public static Connection getConn() {
//		return conn;
//	}
//
//	public static PreparedStatement getStatement() {
//		return stmt;
//	}
//
//	public static ResultSet getResult() {
//		return rs;
//	}
//
//	public static CallableStatement getCallStatement() {
//		return cstmt;
//	}


