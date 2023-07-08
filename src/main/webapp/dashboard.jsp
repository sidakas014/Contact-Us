<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="com.siddharth.Request" %>
<%@ page import="com.siddharth.dao.RequestDao" %>

<!DOCTYPE html>
<html>
<head>
    <title>Requests</title>
<style>
	body{
		margin-left: 25%;
		margin-top: 1%;
	}
	body h1{
		margin-left: 25%;
		margin-bottom: 2%;
	}
	table{
		border-collapse: collapse;
		background-color: rgb(176, 224, 230);
		width: 70%;
		margin-bottom: 10%
	}
	th, td{
		border: 1px solid;
		text-align: center;
	}
	form{
	padding-top: 15px;
	}

</style>
</head>
<body>
    <h1>Active Request Data</h1>
    <table>
        <tr>
        	<th>id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Message</th>
            <th>Status</th>
            <th>TimeStamp</th>
            <th>Action</th>
        </tr>
        
        <% 
        		List<Request> activeRequestDataList = (List<Request>) session.getAttribute("activeRequestDataList");
              	for (Request requestData : activeRequestDataList) {
                   %>
                   <tr>
                   		<td><%= requestData.getId() %></td>
                       	<td><%= requestData.getName() %></td>
                       	<td><%= requestData.getEmail() %></td>
                       	<td><%= requestData.getMessage() %></td>
                       	<td><%= requestData.getStatus() %></td>
                       	<td><%= requestData.getTimestamp() %></td>
                       	<td>
                       		<form action="dashboard" method="post">
                       		<input type="hidden" name="dataId" value="<%= requestData.getId() %>">
                       		<input type="hidden" name="dataStatus" value="<%= requestData.getStatus() %>">
                       		<input type="submit" value="Archive" name="Archive">
                       		</form>
                       	</td>
                   </tr>
                   <%
               }
        %>
        
    </table>
    
    <h1>Archive Request Data</h1>
    <table>
        <tr>
        	<th>id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Message</th>
            <th>Status</th>
            <th>TimeStamp</th>
            <th>Action</th>
        </tr>
        
        <% 
        		List<Request> archiveRequestDataList = (List<Request>) session.getAttribute("archiveRequestDataList");
              	for (Request requestData : archiveRequestDataList) {
                   %>
                   <tr>
                   		<td><%= requestData.getId() %></td>
                       	<td><%= requestData.getName() %></td>
                       	<td><%= requestData.getEmail() %></td>
                       	<td><%= requestData.getMessage() %></td>
                       	<td><%= requestData.getStatus() %></td>
                       	<td><%= requestData.getTimestamp() %></td>
                       	<td>
                       		<form action="dashboard" method="post">
                       		<input type="hidden" name="dataId" value="<%= requestData.getId() %>">
                       		<input type="hidden" name="dataStatus" value="<%= requestData.getStatus() %>">
                       		<input type="submit" value="Active" name="Active">
                       		</form>
                       	</td>
                   </tr>
                   <%
               }
        %>
        
    </table>
</body>
</html>
