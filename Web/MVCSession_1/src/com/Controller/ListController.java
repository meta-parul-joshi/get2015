package com.Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.EmployeeCache;
import com.model.Employee;

/**
 * Servlet implementation class ListController
 */
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static boolean flag = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		if(!flag) {
			initializeCache();
		} 
		RequestDispatcher requestDispatcher;
		request.setAttribute("list", employeeCache.getAllEmployees());
		requestDispatcher = request.getRequestDispatcher("List.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void initializeCache() {
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		employeeCache.addEmployee(new Employee("Parul", "parul@mail.com", 1, 21, "03-8-15"));
		employeeCache.addEmployee(new Employee("Manish", "manish@mail.com", 2, 24, "14-05-12"));
		employeeCache.addEmployee(new Employee("Hemant", "hemant@mail.com", 3, 26, "12-01-12"));
		employeeCache.addEmployee(new Employee("Kajal", "kajal@mail.com", 4, 22, "03-8-15"));
		employeeCache.addEmployee(new Employee("Riddhi", "riddhi@mail.com", 5, 22, "03-8-15"));
		flag = true;
	}
}
