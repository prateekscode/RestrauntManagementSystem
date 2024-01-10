<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="WelcomeC.css">
<meta charset="UTF-8">
<title>Welcome Customer</title>
</head>
<body>

	<%
	HttpSession session1 = request.getSession(false);
	String username = (String) session1.getAttribute("username");
	%>

	<div class="customer-panel">
		<h2>
			Welcome,
			<%=username%>!
		</h2>

		<form action="WelcomeServlet" method="post">
			<div class="btn1">
				<h2>Check-In Time</h2>
				<label for="checkInTime"></label> <input type="time"
					id="checkInTime" name="checkInTime">
			</div>

			<div class="btn1">
				<!-- Create a new div for the button to be in a new line -->
				<button type="submit" name="action" value="addCheckInTime">Add
					Check-In Time</button>
			</div>
		</form>


		<form action="ShopServlet" method="post">
			<div class="btn2">
				<h2>Shopping Cart</h2>

				<!-- List of items with price and quantity -->
				<label for="items">Select an item:</label> <select id="items"
					name="selectedItem">
					<option value="item1">Samosa- ₹10.00/pc</option>
					<option value="item2">Laddoo- ₹50.00/250gm</option>
					<option value="item3">Peda- ₹100.00/250kg</option>
					<option value="item4">Rasgulla- ₹15.00/pc</option>
					<option value="item5">Namakpare- ₹50.00/250gm</option>
					<option value="item6">Gujhia- ₹15.00/pc</option>
					<option value="item7">Namkeen Sev- ₹60.00/250gm</option>
				</select> <label for="quantity">Quantity:</label> <input type="number"
					id="quantity" name="quantity" value="1" min="1">
				<div class="btn2">
					<button type="submit" name="action" value="addToCart">Add
						to Cart</button>
				</div>
			</div>
		</form>


		<form action="BillServlet" method="post">
			<!-- ... (previous form content) ... -->

			<div class="btn3">
				<h2>Generate Bill</h2>
				<button type="submit" name="action" value="generateBill">Generate
					Bill</button>
			</div>

			<!-- Display section for the generated bill -->
			<div id="billSection">
				<h3>Generated Bill:</h3>
				<p id="billDetails"></p>
			</div>
		</form>


		<div>
			<div class="btn4">
				<p>
					<a href="Login.jsp">LogOut</a>
				</p>
			</div>
		</div>
	</div>

</body>
</html>