<%@page import="com.model.Employee"%>
<%@page import="com.helper.EmployeeCache"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ include file="Header.jsp" %>
	<section>
	<%! String name;
		String email;	
		String id;
		String age;
		String value;
		String readonly;
		String type;
	%>
	<%if(request.getParameter("id") != "")
	{
		id = request.getParameter("id");
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		Employee employee = employeeCache.getEmployeeForId(Integer.parseInt(id));
		name = employee.getName();
		email = employee.getEmail();
		age = Integer.toString(employee.getAge());
		value = "Update";
		readonly = "readonly";
		type = "edit";
	}
	else
	{
		name = "";
		email = "";
		id = "";
		age = "";
		value = "Register";
		readonly = "";
		type = "register";
	}
	%>
		<div class="container">
			<form action="RegistrationForm">
				<table>
					<tr>
						<td>Employee Name</td>
						<td><input type="text" name="name" id="name" value = 
						<%=
							name
						%>>
						</td>
					</tr>
					<tr>
						<td>Employee Email</td>
						<td><input type="email" name="email" id="email" value = 
						<%=
							email
						%>>
						</td>
					</tr>
					<tr>
						<td>Employee Id</td>
						<td><input type="number" name="id" id="id" value = 
						<%=
							id
						%> <%=readonly %>>
						</td>	
					</tr>
					<tr>
						<td>Employee Age</td>
						<td><input type="number" name="age" id="age" min="20" value = 
						<%=
							age
						%>>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value=<%=value %> /></td>
					</tr>
				</table>
				<input type = "hidden" name = "type" id = "type" value = <%=type%>>
			</form>
			<label>${msg}</label>
		</div>
	</section>
 <%@ include file="Footer.jsp" %>
