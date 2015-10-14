package com.Servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegistrationForm extends HttpServlet 
{

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		boolean flag=true;
		res.setContentType("text/html");
		pw.println("This is servlet page.<br>");
		if(req.getParameter("txtFirstName")== "")
		{
			pw.println("First Name not entered<br>");
			flag=false;
		} 
		else if(req.getParameter("txtFirstName").matches("\\d+"))
		{
			pw.println("First Name can have only characters<br>");
			flag=false;
		}

		if(req.getParameter("txtLastName")== "") 
		{
			pw.println("Last Name not entered<br>");
			flag=false;
		}
		else if(req.getParameter("txtLastName").matches("\\d+"))
		{
			pw.println( "Last Name can have only characters<br>");
			flag=false;
		}

		if(req.getParameter("password")== "") 
		{
			pw.println(  "Please specify password<br>");
			flag=false;
		}
		else if(req.getParameter("password").length() < 8 )
		{
			pw.println("Password Length should be greater than 8 <br>");
			flag=false;
		}

		if(req.getParameter("ConfirmPassword")== "") 
		{
			pw.println("Please specify confirm password<br>");
			flag=false;
		}
		else if(!req.getParameter("password").equalsIgnoreCase(req.getParameter("ConfirmPassword"))) 
		{  
			pw.println("Password doesn't match<br>");
			flag=false;
		}

		if( req.getParameter("txtAge")=="")
		{
			pw.println("Age is not entered<br>");
			flag=false;	
		}
		else if(!req.getParameter("txtAge").matches("[0-9]+"))
		{
			pw.println("Age can have only numbers<br>");
			flag=false;
		}
		
		if(flag==true)
		{
			pw.println("User created successfully <br>Form is validated at server side<br>"); 
		}
	}	
}	

