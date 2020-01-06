package com.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbHelper {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/newsdb?useUnicode=true&characterEncoding=utf-8";
	private static String user="root";
	private static String pwd="root";
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
