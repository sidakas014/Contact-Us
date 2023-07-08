<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    body{
        background-color: rgb(241, 224, 191);
    }
    form{
        border: 2px solid;
        margin-right: 70%;
        position: absolute;
        left: 40%;
        top: 30%;
        padding-left: 50px;
    }
    form h1{
        background-color: rgb(178, 218, 236);
        margin-left: -50px;
        margin-top: 0%;
        padding-top: 20px;
        padding-bottom: 20px;
        padding-left: 20%;
    }
    #box{
        width: 250px;
        height: 200px;
        font-size: 20px;
        margin-top: 0%;
        padding-left: 20px;
    }
    #login{
        margin-left: 65px;
    }
    span{
    	margin-left: 13%;
    	color: red;
    }

</style>
<meta charset="UTF-8">
<title>Login_page</title>
</head>
<body>
<form  action="Login" method="post">
	<h1>Admin Login</h1>
	<br>
	<div id="box">
	<label for="id">ID</label>
        <div>
            <input type="text" id="id" name="id" required>
        </div>
        <br>
    <label for="pass">Password</label>
        <div>
            <input type="password" id="pass" name="pass" required>
        </div>
        <br>
    <input type="submit" value="Login" id="login">
	</div>
		<% if(session.getAttribute("isWrong") != null) { %>
                <br><span><%= "ID or Password Invalid." %></span><br><br>
             <% } %>
</form>
</body>
</html>