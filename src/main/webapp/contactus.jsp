<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-color: white;
        }

        #box {
            border-style: solid;
            width: 20%;
            margin-left: 40%;
            margin-top: 13%;
            padding-bottom: 1%;
            padding-left: 0%;
		}
		
		.content {
            margin-left: 23%;
        }

        #heading {
            background-color: rgb(176, 224, 230);
            padding-top: 3%;
            padding-bottom: 3%;
            padding-left: 3%;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ContactUs</title>
</head>

<body>
    <div id="box">
        <form method="post" action="contactus">
            <div id="heading">
                <h1>Contact Us</h1>
                <p style="margin-top:-20px ;">Please fill this form in a decent manner</p>
            </div>
            <br>
            <label for="name" class="content">Full Name</label>
            <div>
                <input type="text" id="name" name="name" class="content" class="content" required>
            </div>
            <br>
            <label for="email" class="content">E-mail</label>
            <div>
                <input type="email" id="email" name="email" class="content" required>
            </div>
            <br>
            <label for="meesage" class="content">Message</label>
            <div>
                <textarea type="text" id="message" name="message" rows="5" class="content" required></textarea>
            </div>
            <br>
            <input type="submit" value="Submit" class="content">
        </form>
    </div>
</body>

</html>