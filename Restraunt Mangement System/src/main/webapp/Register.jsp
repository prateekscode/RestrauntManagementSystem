<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<div class="container">
		<h1>Register</h1>
		<div class="form">
<form action="RegisterServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <label for="dob">Date of Birth:</label>
    <input type="date" id="dob" name="dob" required>

    <label for="mobile">Mobile Number:</label>
    <input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" required>
    
    <label for="type">User Type:</label>
    <select id="type" name="type" required>
        <option value="customer">customer</option>
        <option value="admin">admin</option>
    </select>
    

    <button type="submit">Sign Up</button>
</form>
</div>
		<p>
			<a href="index.html">Back to Home</a>
		</p>
	</div>
</body>
</html>