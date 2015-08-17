import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class studentAndTeacherInheritPersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Positive Test
	@Test
	public void positiveTestPerson()
	{
		Person object=new Person(2,"N");
		object.setName("Parul");
		String actual=object.getName();
		boolean flag=actual.equals("Parul");
		assertTrue(flag);
	}
	
	//Negative Test
	@Test
	public void negativeTestPerson()
	{
		Person object=new Person(2,"N");
		object.setName("Parul");
		String actual=object.getName();
		boolean flag=actual.equals("N");
		assertFalse(flag);
	}
	
	@Test	
	public void testStudentName() 
	{
		Student object=new Student(1,"Parul",23);
		object.setUid(2);
		int actual=object.getUid();
		assertEquals(2, actual);	
	}
	
	@Test
	public void testStudentSubject() 
	{
		Student object=new Student(2,"N",32);
		String input[]={"Jqurrey","Java"};
		String expected[]={"Jqurrey","Java"};
		object.setCourses(input);
		String actual[]=object.getCourses();
		boolean flag=actual[0].equals(expected[0]);
		boolean flag1=actual[1].equals(expected[1]);
		assertTrue(flag);
		assertTrue(flag1);
	}
	
	@Test
	public void testTeacherName()
	{
		Teacher object=new Teacher(1,"Manish",4079);
		object.setteacherId(12);
		int actual=object.getteacherId();
		assertEquals("Match",12,actual);
	}

	@Test
	public void testTeacherSubject()
	{
		Teacher object=new Teacher(1,"Manish",4079);
		String input="Jqurrey";
		String expected="Jqurrey";
		object.setSubject(input);
		String actual=object.getSubject();
		boolean flag=actual.equals(expected);
		assertTrue(flag);	
	}
}
