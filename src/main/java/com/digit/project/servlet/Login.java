package com.digit.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet{
private PreparedStatement prep;
private Connection con;


@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int pin = Integer.parseInt(req.getParameter("pin"));
	int id = Integer.parseInt(req.getParameter("id"));
	
	HttpSession session = req.getSession(true);
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pass = "2023";
		
		con = DriverManager.getConnection(url,user,pass);
		prep = con.prepareStatement("Select * from register where cust_id=? and pin=?");
		prep.setInt(1, id);
		prep.setInt(2, pin);
		
		ResultSet r = prep.executeQuery();
		
		if(r.next()) {
			resp.sendRedirect("/BankingApp/Home.jsp");
			session.setAttribute("cust_id", id);
			session.setAttribute("pin", pin);
			session.setAttribute("cust_name", r.getString("cust_name"));
		}
		else {
			resp.sendRedirect("/BankingApp/LoginFail.html");
		}
		
		
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
