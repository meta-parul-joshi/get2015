package com.helper;
public class RegistrationAuthentication {
		
	public static boolean check(int Id)
	{
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		if(employeeCache.getEmployeeForId(Id) == null) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
}
