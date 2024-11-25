<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Page</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="saveUser" method="post">
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td><input type="text" name="phoneNumber"></td>
            </tr>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
        ${msg}
    </form>
</body>
</html>
