<%@page import="com.model.Employee"%>
<%@page import="com.helper.EmployeeCache"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="Header.jsp"%>
<section>
	<%
		Employee employee = (Employee) request.getAttribute("employee");
		request.getRequestURL();
	%>
	<div class="container">
		<table border='2'>
			<tr>
				<td>Employee ID</td>
				<td>Employee Name</td>
				<td>Employee EmailID</td>
				<td>Employee Age</td>
				<td>Registration Date</td>
			</tr>
			<tr>
				<td>
					<%=
						employee.getId()
					%>
				</td>
				<td>
					<%=
						employee.getName()
					%>
				</td>
				<td>
					<%=
						employee.getEmail()
					%>
				</td>
				<td>
					<%=
						employee.getAge()
					%>
				</td>
				<td>
					<%=
						employee.getDateOfRegistration()
					%>
				</td>
			</tr>
		</table>
		</div>
</section>
<%@ include file="Footer.jsp"%>
