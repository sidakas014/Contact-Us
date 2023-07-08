package com.siddharth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.siddharth.Request;

public class RequestDao {
	public static void saveRequest(Request request) {
	    Connection connection = null;
	    Statement statement = null;
	    String name = request.getName();
	    String email = request.getEmail();
	    String message = request.getMessage();
	    try {
	        Class.forName("org.postgresql.Driver");
	        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo", "postgres", "Sid123amitwa@");
	        statement = connection.createStatement();
	        String sql = "INSERT INTO contactus (name, email, message) VALUES ('" + name + "', '" + email + "', '" + message + "')";
	        statement.executeUpdate(sql);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	}
	
	public static List<Request>  fetchAllRequests(boolean statusInput){
		Connection connection = null;
	    Statement statement = null;
	    List<Request> requestDataList = new ArrayList<>();
	    try {
	        Class.forName("org.postgresql.Driver");
	        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo", "postgres", "Sid123amitwa@");
	        statement = connection.createStatement();
	        String sql="";
	        if(statusInput) {
	        	sql = "SELECT * FROM contactus where status=1";
	        }
	        else {
	        	sql = "SELECT * FROM contactus where status=0";
	        }
	        ResultSet resultset = statement.executeQuery(sql);
	        while (resultset.next()) {
	        	int id = resultset.getInt("id");
	            String name = resultset.getString("name");
	            String email = resultset.getString("email");
	            String message = resultset.getString("message");
	            int status = resultset.getInt("status");
	            String timestamp = resultset.getString("timestamp");
	            Request requestData = new Request(id, name, email, message, status, timestamp);
	            requestDataList.add(requestData);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return requestDataList;
	}

	public static void changeStatus(int requestId, boolean status) {
			try {
		        Class.forName("org.postgresql.Driver");
		        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo", "postgres", "Sid123amitwa@");
		        String sql="";
		        if(status == true) {
		        	sql = "UPDATE contactus SET status=0 where id='"+requestId+"'";
		        }
		        else {
		        	sql = "UPDATE contactus SET status=1 where id='"+requestId+"'";
		        }
		        PreparedStatement statement = connection.prepareStatement(sql);
		        statement.executeUpdate();
			} catch (Exception e) {
		        e.printStackTrace();
		    } 
		}
	}

