<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">WellCome <%
session = request.getSession();
out.println((String)session.getAttribute("cust_name"));
%></h1>
<br> <br>
<h3>

Here are the Loans to which you are Eligible :
</h3>
<br><br>
<form action ="Loan">
<h3> 1. Home Loan</h3>
<br>
<h3> 2. Educational Loan</h3>
<br>
<h3> 3. Vehicle Loan</h3>
<br>
<h3> 4. Gold Loan</h3>
<br>
<h3> 5. Personal Loan</h3>
<br><br>

<label> Enter The ID of Your Choice From Above : </label>
<input type="text" name="id">
<br><br>
<input type="submit">
</form> 

</body>
</html>