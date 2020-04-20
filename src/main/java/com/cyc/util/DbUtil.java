package com.cyc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static String url = "jdbc:mysql://localhost:3306/appointment?useUnicode=true&characterEncoding=utf-8"; // 数据库地址
	private static String userName = "root"; // 数据库用户名
	private static String passWord = "root"; // 数据库密码
	
	public DbUtil() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static  Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,userName,passWord);
	}
	
}
