package com.suifengwiki.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Connection;

public class Conn {
	
	private static String Driver;
	private static String url;
	private static String username;
	private static String password;
	public static Connection conn;
	
	private static String connConfig;
	
	static{
		getConfig();
	}
	
	public static Connection getConn(){
		
		if(Driver == null){
			getConfig();
		}
		
		if(conn == null){
			try {
				//STEP 1: Register JDBC driver
				Class.forName(Driver);
				
				//STEP 2: Open a connection
				conn = (Connection) DriverManager.getConnection(url,username,password);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	
	
	public static void getConfig(){
		System.out.println("config...");
		Properties prop = new Properties();
		
		connConfig = getConfigFilePath();
		
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
	
	private static String getConfigFilePath(){
		String path=Thread.currentThread().getContextClassLoader().getResource("").toString();  
//        path=path.replace('/', '\\'); // 将/换成\  
        path=path.replace("file:", ""); //去掉file:  
//        path=path.replace("classes\\", ""); //去掉class\  
//        path=path.substring(1); //去掉第一个\,如 \D:\JavaWeb...  
        path = path + "com/suifengwiki/config/conn.properties";
        System.out.println(path); 
		return path;
	}

	public static void main(String[] args) {
		Conn.getConn();
 
	}

}
