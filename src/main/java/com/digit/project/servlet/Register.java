package com.digit.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
private Connection con;
private PreparedStatement prep;

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int bank_id = Integer.parseInt(req.getParameter("id"));
	String bank_name = req.getParameter("bankname");
	String ifsc = req.getParameter("ifsc");
	int accno = Integer.parseInt(req.getParameter("acc"));
	int pin = Integer.parseInt(req.getParameter("pin"));
	int custid = Integer.parseInt(req.getParameter("custid"));
	String custname = req.getParameter("custname");
	int balance = Integer.parseInt(req.getParameter("balance"));
	String email = req.getParameter("email");
	int phone = Integer.parseInt(req.getParameter("phoneno"));
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pass = "2023";
		
		con = DriverManager.getConnection(url,user,pass);
		prep = con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?,?,?)");
		prep.setInt(1, bank_id);
		prep.setString(2, bank_name);
		prep.setString(3, ifsc);
		prep.setInt(4, accno);
		prep.setInt(5, pin);
		prep.setInt(6, custid);
		prep.setString(7, custname);
		prep.setInt(8, balance);
		prep.setString(9, email);
		prep.setInt(10, phone);
		
		int x= prep.executeUpdate();
		
		if(x>0) {
			resp.sendRedirect("/BankingApp/success.html");
		}
		else {
			resp.sendRedirect("/BankingApp/fail.html");
		}
		
		
	
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
