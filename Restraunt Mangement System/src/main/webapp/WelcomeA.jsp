<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="WelcomeA.css">
<meta charset="UTF-8">
<title>Welcome Admin</title>
</head>
<body>
	<%
        // Retrieve the session object
        HttpSession session1 = request.getSession(false);
            String username = (String) session1.getAttribute("username");
    %>
	<div class="admin-panel">
		<h2>
			Welcome,
			<%=username%>!
		</h2>


		<div class="btn1">
			<h2>View Order</h2>


			<button id="viewOrderBtn">View Order</button>
		</div>
		<!-- <div class="btn2">
			<h2>View Bill</h2>


			<button id="viewBillBtn">View Bill</button>
		</div> -->

		<div class="btn3">
			<h2>Add New User</h2>
			<br>
			<p>
				<a href="Register.jsp">Add User</a>
			</p>
			<br>
		</div>
		<div class="btn4">
			<p>
				<a href="Login.jsp">Logout Securely</a>
			</p>
		</div>
	</div>

</body>
</html>