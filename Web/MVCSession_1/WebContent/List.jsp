<%@page import="com.model.Employee"%>
<%@page import="com.helper.EmployeeCache"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="Header.jsp"%>
<section>
	<%
		List<Employee> employeeList = (List<Employee>) request.getAttribute("list");
		Iterator<Employee> listIterator = employeeList.iterator();
	%>
	<div class="container">
		<table border="2px">
			<tr>
				<td>Employee ID</td>
				<td>Employee Name</td>
				<td>Employee Email ID</td>
				<td>View Details</td>
				<td>Edit Details</td>
			</tr>
			<%
				while (listIterator.hasNext()) {
					Employee employee = listIterator.next();
			%>
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
				<td><a href="EmployeeDetail?id=<%=employee.getId()%>">VIEW</a></td>
				<td><a href="RegistrationFormServlet?id=<%=employee.getId()%>">EDIT</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</section>
<%@ include file="Footer.jsp"%>
