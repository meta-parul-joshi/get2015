import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmployeeCollectionMain 
{
	public static void main(String[] args) 
	{
		Employee<Object> objEmpoyee = null;
			
		/*list to store details of all employee**/
		List<Employee<Object>> employeeList = new ArrayList<Employee<Object>>();
//		employeeList.add( new Employee<Object> ("Manish", 11, "Mansarover  Jaipur") );
//		employeeList.add( new Employee<Object> ("Parul", 12, "Pratap Nagar  Jaipur") );
//		employeeList.add( new Employee<Object> ("Puneet", 13, "MalviyaNagar  Jaipur") );
//		employeeList.add( new Employee<Object> ("Hemant", 14, "Vaishali nagar  Jaipur") );
		
		while (true)
		{	
			/*Show menu to user.*/
			System.out.println("\n\nMenu : ");
			System.out.println("1). Add employee");
			System.out.println("2). Sort employee list in natural order");
			System.out.println("3). Sort employee list according to employee name");
			System.out.println("4). Exit");
			
			/*Input from user.*/
			int choice = Utility.getIntegerValue("\nEnter choice");
			
			switch (choice)
			{
				case 1 : String name = Utility.getStringInput("\nEnter employee name : ");
						 int id = Utility.getIntegerValue("\nEnter employee id : ");
						 String address = Utility.getStringInput("\nEnter employee address : ");
						 objEmpoyee = new Employee<Object>( name, id, address);
						 boolean flag = false;
						 for ( Employee<Object> employee : employeeList )
						 {
							 if ( employee.equals(objEmpoyee) )
							 {	 
								 System.out.println("There is a employee with same id in company ");
								 flag = true;
								 break;
							 }
						 }
						 if ( flag == false )
						 {
							 employeeList.add(objEmpoyee);
							
						 }
						 break;
						
				case 2 : if(employeeList.size()==0)
						 {
						    System.out.println("No employee in company");
													 }
						 else
						 {
							 Collections.sort( employeeList );
							 System.out.println("Sort in Natural order");
							 System.out.println(employeeList);
						 }
						 break;
						 
				case 3: 
					if(employeeList.size()==0)
					 {
					    System.out.println("No employee in company");
					 }
					else
					{
						Collections.sort ( employeeList, new EmpNameComparator() );
						System.out.println ( "Sort using emp name Comparator");
						System.out.println (employeeList );
					}
					break;
						 
				case 4 : System.exit(0);
				 		 break;
				
				default : System.out.println("Please enter correct choice");
				  		  break;
			}
		}		
	}
}
