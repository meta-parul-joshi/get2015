package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connutil.ConnectionUtil;

/**
 * Servlet implementation class Registration
 */

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRegistration(request, response);
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
	}
	
	private void doRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username, password, email;
		username = request.getParameter("username");
		password = request.getParameter("password");
		email = request.getParameter("email");
		String query = "SELECT * FROM Registration WHERE username = '"+username+"'";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		request.setAttribute("a", "Successfully Registered");
		try {
			con = ConnectionUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				request.setAttribute("a", "Username already exists");
			}
			else {
				query = "SELECT * FROM Registration where email = '"+email+"'";
				rs = stmt.executeQuery(query);
				if(rs.next()) {
					request.setAttribute("a", "Email already exists");
				}
				else {
					query = "INSERT INTO Registration VALUES('" + username + "','" + password + "','" + email + "')";
					stmt = con.createStatement();
					stmt.executeUpdate(query);
				}
			}
		}
		catch (Exception e) {
			RequestDispatcher requestDispatcher;
			requestDispatcher = request.getRequestDispatcher("errorpage.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
