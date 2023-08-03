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

@WebServlet("/Loan")
public class Loan extends HttpServlet{
private Connection con;
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	int id = Integer.parseInt(req.getParameter("id"));
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pass = "2023";
		
		con = DriverManager.getConnection(url,user,pass);
		prep = con.prepareStatement("Select * from loan where lid=?");
		prep.setInt(1, id);
		
		
		ResultSet r = prep.executeQuery();
		
		if(r.next()) {
			resp.sendRedirect("/BankingApp/LoanDetails.jsp");
			session.setAttribute("loantype", r.getString("l_type"));
			session.setAttribute("tenure", r.getInt("tenure"));
			session.setAttribute("interest", r.getFloat("interest"));
			session.setAttribute("description", r.getString("description"));
		}
		else {
			resp.sendRedirect("/BankingApp/LoanDetailsFail.jsp");
		}
		
		
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
