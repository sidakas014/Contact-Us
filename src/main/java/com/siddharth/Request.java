package com.siddharth;

public class Request {
	private int id, status;
	private String  name, email, message,  timestamp;
	
	public Request(int id, String name, String email, String message, int status, String timestamp) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}
	
	public Request() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
