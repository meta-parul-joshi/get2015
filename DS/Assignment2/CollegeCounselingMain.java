import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CollegeCounselingMain 
{
	public static void main(String[] args) 
	{
		int totalSeats = 0, totalStudents = 0;
		String fileName = "C://Users/Parul/workspace/Assignment10/src/";
		Student objStudent ;
		List<Student> studentList = new ArrayList<Student>();
		List<College> collegeList = new ArrayList<College>();
		CollegeCounseling objCollegeCounseling = new CollegeCounseling();
		QueueUsingArray objStudentQueueUsingArray = new QueueUsingArray ();
		try
		{	
		    File file = new File(fileName+"StudentsData.txt");
		    FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
		    while((line = br.readLine()) != null)
		    {
		    	totalStudents = totalStudents + 1;
		    	String arr[] = line.split(",");
		    	objStudent = new Student ();
		    	objStudent.setStudentName(arr[0]);
		    	objStudent.setStudentRank(Integer.parseInt(arr[1]));
		    	studentList.add(objStudent);
		    }
		    br.close();
		    fr.close();
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}	
		
		College objCollege ;
		
		try
		{	
		    File file = new File(fileName+"CollegeData.txt");
		    FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
		    while((line = br.readLine()) != null)
		    {
		    	String arr[] = line.split(",");
		    	objCollege = new College ();
		    	objCollege.setCollegeName(arr[0]);
		    	objCollege.setTotalNumOfSeats(Integer.parseInt(arr[1]));
		    	totalSeats = totalSeats + Integer.parseInt(arr[1]);
		    	collegeList.add(objCollege);
		    }
		    br.close();
		    fr.close();
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
		
		for ( int index = 0; index<studentList.size() ; index++)
		{
			for ( int index1 = 0; index1<studentList.size()-1 ; index1++)
			{
				if ( studentList.get(index1).studentRank > studentList.get(index1+1).studentRank )
				{
					Student tempObj = studentList.get(index1);
					studentList.set(index1,studentList.get(index1+1)) ;
					studentList.set(index1+1,tempObj);
				}
			}
		}

		for ( Student studentInfo : studentList )
		{
			objStudentQueueUsingArray.enqueue(studentInfo);
		}
		
		for ( int index = 0; index<=totalStudents; index++)
		{
			Student student = (Student)objStudentQueueUsingArray.dequeue();
			for ( College collegeInfo : collegeList )
			{
					System.out.println ("College Name : "+collegeInfo.collegeName+"\tNum Of Seats : "+collegeInfo.totalNumOfSeats);	
			}
			
			System.out.println("\nStudent : "+student.getStudentName()+"\t Rank : "+student.getStudentRank());
			if(totalSeats == 0)
			{
				return;
			}
			
			boolean flag = false;
			while(flag == false)
			{
				String collegeName = Utility.getStringInput("\nEnter college name of your choice : ");
				flag = objCollegeCounseling.selectCollege( collegeName,  totalSeats, totalStudents, collegeList,  student);						
			}
		}
	
		objStudentQueueUsingArray.printQueue();
	}
}
