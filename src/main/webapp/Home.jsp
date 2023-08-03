<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1 align="center">WelCome to The Bank</h1>
<%
	session = request.getSession();
	String s1 = (String)session.getAttribute("cust_name");
	out.println(s1+" Welcome to Your Account . Please Select an Operation to Perform . ");
%>
<br>
<br>
<a href="checkBalance" a>1. CheckBalance</a>
<br><br>
<a href="changePassword.html" >2. ChangePassword</a>
<br><br>
<a href="Loan.jsp" >3. Apply For Loan</a>
<br><br>
<a href="Logout">4. LogOut</a>
<br><br>
<a href="Transfer.html">5. Transfer Amount</a>
<br><br>
<a href="History.jsp">5. History Amount</a>
</body>
</html>