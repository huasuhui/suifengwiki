package com.suifengwiki.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Connection;

public class Conn {
	
	private static String Driver;
	private static String url;
	private static String username;
	private static String password;
	private static Connection conn;
	
	private static String connConfig = "D:\\Development\\Git\\suifengwiki\\com\\suifengwiki\\config\\conn.properties";
	
	static{
		getConfig();
	}
	
	public static Connection getConn(){
		
		
		try {
			//STEP 1: Register JDBC driver
			Class.forName(Driver);
			//STEP 2: Open a connection
			conn = (Connection) DriverManager.getConnection(url,username,password);
			
			//STEP 3: Execute a query
//			String sql = "SELECT theme FROM article WHERE articleid = '1'";
//		    PreparedStatement pstmt;
//		    pstmt = (PreparedStatement) conn.prepareStatement(sql);
////	        pstmt.setString(1, student.getName());
////	        pstmt.setString(2, student.getSex());
////	        pstmt.setString(3, student.getAge());
//		    
//		    ResultSet rs = pstmt.executeQuery();
//		    while(rs.next()){
//		    	System.out.println(rs.getString("theme"));
//		    }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	public static void getConfig(){
		System.out.println("config...");
		Properties prop = new Properties();
		
		File file = new File(connConfig);
		try {
			InputStream connConfig = new FileInputStream(file);
			prop.load(connConfig);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Driver = (String) prop.get("Driver");
		url = (String) prop.get("url");
		username = (String) prop.get("username");
		password = (String) prop.get("password");
		
		
		
	}

	public static void main(String[] args) {
		Conn.getConn();
		Conn.getConn();
	}

}
