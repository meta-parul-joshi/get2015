
import java.util.Comparator;

public class EmpIoyeeIdComparator<T> implements Comparator<T>
{
	
	public int compare ( Object obj1, Object obj2 )
	{
		Employee firstEmployee = (Employee)obj1;
		Employee secondEmployee = (Employee)obj2;
		if ( ( firstEmployee.getEmployeeId() == null ) && ( secondEmployee.getEmployeeId() == null ) )
			return 0;
		else 
			return firstEmployee.getEmployeeId()-secondEmployee.getEmployeeId() ;
	}
}
