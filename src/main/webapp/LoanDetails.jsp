<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
Hii 
<%
session = request.getSession();
out.println((String)session.getAttribute("cust_name"));
%> <br><br>Here are the Details Of the Loan :
</h1>
<br><br>
<h3>

<%
session = request.getSession();
out.println("Loan Type        : "+session.getAttribute("loantype"));
%>
<br>
<%
session = request.getSession();
out.println("Loan Tenure      : "+session.getAttribute("tenure"));
%>
<br>
<%
out.println("Loan Interest    : "+session.getAttribute("interest"));
session = request.getSession();
%>
<br>
<% session = request.getSession();
out.println("Loan Description : "+session.getAttribute("description"));
%>


</h3>
<br><br>
<h1 align="center">For More Details Contact Us</h1>
<br><br>
<h1 align="center"> Thank You </h1>>
</body>
</html>