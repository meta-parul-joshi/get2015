public class Employee<T> implements Comparable<T>
{
	/*
	 * @param employeeId stores employee id.
	 * @param employeeName store employee name
	 * @param employeeAddress store employee address.
	 * */
	Integer employeeId;
	String employeeName;
	String employeeAddress;
	
	/*Constructor.*/
	public Employee ( String employeeName, Integer employeeId, String  employeeAddress )
	{
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeAddress = employeeAddress;
	}
	
	/*Function to get employee id.*/
	public Integer getEmployeeId () 
	{
		return employeeId;
	}
	
	/*Function to set employee id.*/
	public void setEmployeeId ( Integer employeeId ) 
	{
		this.employeeId = employeeId;
	}
	
	/*Function to get employee name.*/
	public String getEmployeeName () 
	{
		return employeeName;
	}
	
	/*Function to set employee name.*/
	public void setEmployeeName ( String employeeName ) 
	{
		this.employeeName = employeeName;
	}
	
	/*Function to get employee address.*/
	public String getEmployeeAddress () 
	{
		return employeeAddress;
	}
	
	/*Function to set employee address.*/
	public void setEmployeeAddress ( String employeeAddress ) {
		this.employeeAddress = employeeAddress;
	}
	
	/*Prints details of employee.*/
	public String toString()
	{
		 return getEmployeeName() + "\t" + getEmployeeId() + "\t" + getEmployeeAddress() ;
	}
	
	// Implement the natural order for this class
	public int compareTo ( Object object )
	{
		return getEmployeeName().compareTo(((Employee)object).getEmployeeName());
	}
	
	/**Override hashcode() method of Object class.*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}
	
	/*Override equals() methods of object class.**/
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
		{
			return true;
		}
		
		if (obj == null)
		{
			return false;
		}
		
		if (getClass() != obj.getClass())
		{
			return false;
		}
		
		Employee<T> other = (Employee) obj;
		if (employeeId == null) 
		{
			if (other.employeeId != null)
			{
				return false;
			}
		} 
		else if (!employeeId.equals(other.employeeId))
		{
			return false;
		}
		
		return true;
	}
	
}
