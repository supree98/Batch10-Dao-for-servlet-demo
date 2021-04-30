package com.tyss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	public static boolean verify(String username, String password) throws SQLException  {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/gmail?user=root&password=root";
		String sql = "select * from users where username=? and password=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		con = DriverManager.getConnection(url);
		ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
		
		
	}
}
