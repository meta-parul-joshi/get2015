
public class SortingStudentMain 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		System.out.println("Student data");
		
		/*Initialize object of class to call function of class.*/
		SortingStudentDataUsingTreeSort objectStudentDataUsingTreeSort = new SortingStudentDataUsingTreeSort();
		
		while(true)
		{
			/*Show menu to user.*/
			System.out.println("\n\nMenu : ");
			System.out.println("1). Enter student details");
			System.out.println("2). Sorting");
			System.out.println("3). Exit");
			
			/*Input from user.*/
			int choice = Utility.getIntegerValue("\nEnter choice");
			switch(choice)
			{
				case 1 :/*Input array size from user.*/ 
						int numberOfStudents = Utility.getIntegerValue("Enter number of students");
						objectStudentDataUsingTreeSort.setNumberOfStudent(numberOfStudents);
						
						/*Input array elements from user.*/
						for(int index = 0; index <numberOfStudents ; index++)
						{
							String studentName = Utility.getStringInput("Enter name of student : "+(index+1));
					    	int studentRollNumber = Utility.getIntegerValue("Enter roll number of student : "+(index+1));
					    	StudentNode objectStudent = new StudentNode(studentRollNumber , studentName);
							objectStudentDataUsingTreeSort.insert(objectStudent);
						}
						break;
						
						/*Sorting students according to roll number.*/
				case 2 :if(objectStudentDataUsingTreeSort.getNumberOfStudent() == 0)
						{
							System.out.println("No student in school");
						}
						else
						{
							objectStudentDataUsingTreeSort.inOrder(objectStudentDataUsingTreeSort.returnRoot());
							objectStudentDataUsingTreeSort.printStudentData();
						}
						
						break;
						
						/*Exit.*/
				case 3 :System.out.println("System exited");
						System.exit(0);
						break;
				
				default : System.out.println("Wrong choice");
							break;						
			}	
		}
	}
}
