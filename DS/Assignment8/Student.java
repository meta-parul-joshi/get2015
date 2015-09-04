/*Class to store information of student.
 * @author parul.
 */
public class Student 
{
	/*
	 * @param rollnumber stores roll number of student.
	 * @param studentName stores name of student.
	 * */
	int rollnumber;
	String studentName;
	
	/*Constructor.*/
	public Student(int rollnumber,String studentName)
	{
		this.rollnumber = rollnumber;
		this.studentName = studentName;
	}

	/*Function to get roll number of student.*/
	public int getRollnumber() {
		return rollnumber;
	}
	
	/*Function to set roll number of student .
	 * it takes rollNumber as key parameter.
	 * */
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	
	/*Function to get name of student.*/
	public String getStudentName() {
		return studentName;
	}
	
	/*Function to set name of student.
	 * It takes studentName as parameter.
	 * */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
