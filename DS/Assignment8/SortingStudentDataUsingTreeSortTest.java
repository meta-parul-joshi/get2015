import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;


public class SortingStudentDataUsingTreeSortTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	/*Valid test case for student data is sorted in ascending order.*/
	public void testingSortingValidcase() 
	{
		SortingStudentDataUsingTreeSort objectOfSortingStudentDataUsingTreeSort = new SortingStudentDataUsingTreeSort();
		StudentNode objectStudentone = new StudentNode(24,"Manish");
		StudentNode objectStudentTwo = new StudentNode(14,"Parul");
		objectOfSortingStudentDataUsingTreeSort.insert(objectStudentone);
		objectOfSortingStudentDataUsingTreeSort.insert(objectStudentTwo);
		objectOfSortingStudentDataUsingTreeSort.inOrder(objectOfSortingStudentDataUsingTreeSort.returnRoot());
		List<StudentNode> studentList = new ArrayList<StudentNode>();
		studentList.add(objectStudentTwo);
		studentList.add(objectStudentone);
		boolean flag = true;
		for(int i = 0;i<studentList.size();i++)
		{
			
			if(studentList.get(i).student.getRollnumber() != objectOfSortingStudentDataUsingTreeSort.studentList.get(i).student.getRollnumber())
			{
				flag = false;
			}
		}
		
		assertTrue(flag);		
	}
	
	@Test
	/*Invalid test case for student data is sorted..*/
	public void testingSortingInvalidcase() 
	{
		SortingStudentDataUsingTreeSort objectOfSortingStudentDataUsingTreeSort = new SortingStudentDataUsingTreeSort();
		StudentNode objectStudentone = new StudentNode(24,"Manish");
		StudentNode objectStudentTwo = new StudentNode(14,"Parul");
		objectOfSortingStudentDataUsingTreeSort.insert(objectStudentone);
		objectOfSortingStudentDataUsingTreeSort.insert(objectStudentTwo);
		objectOfSortingStudentDataUsingTreeSort.inOrder(objectOfSortingStudentDataUsingTreeSort.returnRoot());
		List<StudentNode> studentList = new ArrayList<StudentNode>();
		studentList.add(objectStudentone);
		studentList.add(objectStudentTwo);
		boolean flag = true;
		for(int i = 0;i<studentList.size();i++)
		{
			
			if(studentList.get(i).student.getRollnumber() != objectOfSortingStudentDataUsingTreeSort.studentList.get(i).student.getRollnumber())
			{
				flag = false;
			}
		}
		
		assertFalse(flag);		
	}
	
	@Test
	/*valid test case for root node of tree.*/
	public void testingRootvalidcase() 
	{
		SortingStudentDataUsingTreeSort objectOfSortingStudentDataUsingTreeSort = new SortingStudentDataUsingTreeSort();
		StudentNode objectStudentone = new StudentNode(24,"manish");
		StudentNode objectStudentTwo = new StudentNode(14,"Parul");
		objectOfSortingStudentDataUsingTreeSort.insert(objectStudentone);
		objectOfSortingStudentDataUsingTreeSort.insert(objectStudentTwo);
		assertEquals(objectStudentone.student.getRollnumber(),objectOfSortingStudentDataUsingTreeSort.root.student.getRollnumber());
	}
	
	@Test
	/*Invalid test case for root node of tree.*/
	public void testingRootInvalidcase() 
	{
		SortingStudentDataUsingTreeSort objectOfSortingStudentDataUsingTreeSort = new SortingStudentDataUsingTreeSort();
		StudentNode objectStudentone = new StudentNode(24,"Manish");
		StudentNode objectStudentTwo = new StudentNode(14,"Parul");
		objectOfSortingStudentDataUsingTreeSort.insert(objectStudentone);
		objectOfSortingStudentDataUsingTreeSort.insert(objectStudentTwo);
		int expectedRoot = objectStudentTwo.student.getRollnumber();
		int actualRoot = objectOfSortingStudentDataUsingTreeSort.root.student.getRollnumber();
		assertNotEquals(expectedRoot,actualRoot);
	}
	
	@Test
	/*valid test case for number of students.*/
	public void testingNumberOfStudentsValidCase() 
	{
		SortingStudentDataUsingTreeSort objectOfSortingStudentDataUsingTreeSort = new SortingStudentDataUsingTreeSort();
		int numberOfstudent = 5;
		objectOfSortingStudentDataUsingTreeSort.setNumberOfStudent(numberOfstudent);
		int expectedNumberOfStudent = 5;
		int actualNumberOfStudent = objectOfSortingStudentDataUsingTreeSort.getNumberOfStudent();
		assertEquals(expectedNumberOfStudent,actualNumberOfStudent);
	}
	
	@Test
	/*Invalid test case for number of student.*/
	public void testingNumberOfStudentsInvalidCase() 
	{
		SortingStudentDataUsingTreeSort objectOfSortingStudentDataUsingTreeSort = new SortingStudentDataUsingTreeSort();
		int numberOfstudent = 5;
		objectOfSortingStudentDataUsingTreeSort.setNumberOfStudent(numberOfstudent);
		int expectedNumberOfStudent = 54;
		int actualNumberOfStudent = objectOfSortingStudentDataUsingTreeSort.getNumberOfStudent();
		assertNotEquals(expectedNumberOfStudent,actualNumberOfStudent);
	}
}

