<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Static content -->
    <link rel="stylesheet" href="/resources/css/style.css">
    <script type="text/javascript" src="/resources/js/app.js"></script>

    <title>Spring Boot</title>
</head>
<body>
<h1> User Module - Please Enter the Your Personal details</h1>
<hr>

<div class="form">
    <form action="/user/saveUserDetails" method="post" onsubmit="return validate()">
        <table>
            <tr>
                <td>Enter Your firstName &nbsp;&nbsp;: &nbsp; &nbsp;</td>
                <td><input id="firstName" name="firstName"></td>
            </tr>
            <tr>
                <td>Enter Your lastName &nbsp;&nbsp;: &nbsp; &nbsp;</td>
                <td><input id="lastName" name="lastName"></td>

            </tr>
            <tr>
                <td>Enter Your age &nbsp;&nbsp;: &nbsp; &nbsp;</td>
                <td><input id="age" name="age"></td>
            </tr>
            <tr>
                <td>Enter Your dob &nbsp;&nbsp;: &nbsp; &nbsp;</td>
                <td><input id="dob" name="dob"></td>
            </tr>
            <tr>
                <td>Enter Your emailId &nbsp;&nbsp;: &nbsp; &nbsp;</td>
                <td><input id="emailId" name="emailId"></td>
            </tr>
            <tr>
                <td>Enter Your contactNumber &nbsp;&nbsp;: &nbsp; &nbsp;</td>
                <td><input id="contactNumber" name="contactNumber"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>