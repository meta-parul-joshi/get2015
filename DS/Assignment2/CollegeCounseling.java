import java.util.ArrayList;
import java.util.List;

public class CollegeCounseling
{
	int totalSeats = 0, totalStudents = 0;
	QueueUsingArray objQueueUsingArray = new QueueUsingArray();
	List<College> collegeList = new ArrayList<College>();

	public boolean selectCollege(String collegeName, int totalSeats,int totalStudents, List<College> collegeList, Student student)
	{
		boolean flag = false, flag1 = false;
		for ( College collegeInfo : collegeList )
		{
			if ( collegeInfo.collegeName.equalsIgnoreCase(collegeName) )
			{								
				flag1 = true;
				if ( collegeInfo.totalNumOfSeats != 0 )
				{
					collegeInfo.totalNumOfSeats -= 1;
					student.setCollegeName(collegeName);
					totalSeats -= 1;
					objQueueUsingArray.enqueue(student);
					System.out.println("\n college alloted successfully");
					flag = true;			
				}
				else
				{
					System.out.println ("Seats full");
				}
			}
		}
		
		if ( flag1 == false )
		{
			System.out.println ("College not found");
		}
				
		return flag;		
	}		
}
	
	

