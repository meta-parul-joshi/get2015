import java.util.Scanner;
/*Student and teacher both classes will inherit properties of person class.
 * @parul joshi
 * */
public class studentAndTeacherInheritPerson
{
	public static void main(String[] args)
	{
		Teacher objectTeacher=new Teacher(1, "Manish", 4079);
		String subject="JQurrey";
		objectTeacher.setSubject(subject);
		System.out.println("Details of teacher :");
		String answer=objectTeacher.toString();
		System.out.println(answer);
		Student objectStudent=new Student(2, "Parul", 6078);
		String array[]={"Java","JQurrey"};
		objectStudent.setCourses(array);
		System.out.println("Details of student");
		String answerStudent=objectStudent.toString();
		System.out.println(answerStudent);
	}
}

/*Parent class.*/
class Person
{
	private int uid;
	private String name;
	
	//Constructor.
	public Person(int uid,String name)
	{
		this.uid=uid;
		this.name=name;
	}
	
	//Used to get the value of person id.
	public int getUid()
	{
		return uid;
	}
	
	//Used to set the value of person id.
	public void setUid(int uid)
	{
		this.uid=uid;
	}
	
	//Used to get the value of person name.
	public String getName()
	{
		return name;
	}
	
	//Used to set the value of person name.
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String toString()
	{
		return "Name :"+name+"\nUid :"+uid;
	}
}

/*Child class.*/
class Teacher extends Person
{
	
	//TeacherId contains teacher id.
	 //subjects string array stores the name of subjects for teacher.
	
	private int teacherId;
	private String subject;
	
	/*Constructor.*/
	public Teacher(int uid, String name,int teacherId)
	{
		super(uid,name);
		this.teacherId=teacherId;
	}
	
	//Used to get the value of id for a teacher.
	public int getteacherId()
	{
		return teacherId;
	}
	
	//Used to set the value of id for a teacher.
	public void setteacherId(int teacherId)
	{
		this.teacherId=teacherId;
	}
	
	//Used to get the value of subjects for a teacher.
	public String getSubject()
	{
		return subject;
	}
	
	//Used to set the value of subject for a teacher.
	public void setSubject(String subject)
	{
		this.subject=subject;
	}
	
	//Used to return the value in the form of string.
	public String toString()
	{
		return super.toString()+"\nTeacherId :"+teacherId+"\nSubject :"+subject;
	}
}

class Student extends Person
{
	 // StudentId used to store value of student id.
	//  Courses contains the string of all the courses of student.
	 
	private int StudentId;
	private String[] courses;
	
	public Student(int uid,String name,int StudentId)
	{
		super(uid,name);
		this.StudentId=StudentId;
	}
	
	//Used to get the value of student id.
	public int getStudentId()
	{
		return StudentId;
	}
	
	//Used to set the value of student id.
	public void setStudentId(int StudentId)
	{
		this.StudentId=StudentId;
	}
	
	//Used to get the value of student courses.
	public String[] getCourses()
	{
		return courses;
	}
	
	//Used to set the value of student courses.
	public void setCourses(String[] courses)
	{
		this.courses=courses;
	}
	
	//Used to print the value of string.
	public String toString()
	{
		String totalCourses="";
		for(int index=0;index<courses.length;index++)
		{
			totalCourses=totalCourses.concat(" "+courses[index]);
		}
		return super.toString()+"\nStudentId :"+StudentId+"\nCourses :"+totalCourses;
	}
}