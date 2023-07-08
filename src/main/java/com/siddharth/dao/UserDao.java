package com.siddharth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.siddharth.User;

public class UserDao {
	public static boolean isValidUser(User user) {
		String Id = user.getId();
		String Pass = user.getPass();
		Connection connection = null;
	    Statement statement = null;
	    try {
	        Class.forName("org.postgresql.Driver");
	        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo", "postgres", "Sid123amitwa@");
	        statement = connection.createStatement();
	        String sql = "SELECT * FROM admin";
	        ResultSet resultset = statement.executeQuery(sql);
	        while (resultset.next()) {
	        	String id = resultset.getString("id");
	        	String pass = resultset.getString("password");
	        	if(id.equals(Id) && pass.equals(Pass)){
	    			return true;
	    		}
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return false;
	}
}
