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
 * Servlet implementation class LoginValidation
 */

public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean flag = loginValidation(request, response);
		if(flag==true)
		{
			RequestDispatcher reqDisSuccess = request.getRequestDispatcher("loginsuccess.jsp");
			reqDisSuccess.forward(request, response);
		}
		else
		{
			RequestDispatcher reqDisFailure = request.getRequestDispatcher("login.jsp");
			reqDisFailure.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	
	private boolean loginValidation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		boolean flag = false;
		response.setContentType("text/html");
		String username, password;
		username = request.getParameter("username");
		password = request.getParameter("password");
		String query = "SELECT username, password, email FROM registration WHERE username='"+username+"'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = ConnectionUtil.getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) 
			{
				if(rs.getString("password").equals(password)) 
				{
					request.setAttribute("email", rs.getString("email"));
					flag = true;
				}
				else 
				{
					request.setAttribute("a", "Incorrect Password");			
				}
			}
			
			else 
			{
				request.setAttribute("a", "Incorrect username");	
			}
			
		}
		catch(Exception e) 
		{
			RequestDispatcher requestDispatcher;
			requestDispatcher = request.getRequestDispatcher("errorpage.jsp");
			requestDispatcher.forward(request, response);
		}
		return flag;
	}
}
