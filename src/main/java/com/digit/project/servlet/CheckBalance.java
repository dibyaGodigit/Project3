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

@WebServlet("/checkBalance")
public class CheckBalance extends HttpServlet {
private Connection con;
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	int id = (int)session.getAttribute("cust_id");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pass = "2023";
		
		con = DriverManager.getConnection(url,user,pass);
		prep = con.prepareStatement("Select balance from register where cust_id=?");
		prep.setInt(1, id);
		
		
		ResultSet r = prep.executeQuery();
		if(r.next()) {
			session.setAttribute("balance", r.getString("balance"));
			resp.sendRedirect("/BankingApp/Balance.jsp");
		}
		else {
			resp.sendRedirect("/BankingApp/BalanceFail.jsp");
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
