import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class interfaceShapeTest {

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
		public void positiveTestSquare() 
		{
			Shape object=new Square(5);
			double area=object.getArea();
			assertEquals("Match",25,area,.0);
		}
		
		//Negative Test
		@Test
		public void negativeTestSquare() 
		{
			Shape object=new Square(4);
			double area=object.getArea();
			assertNotEquals("Match",25,area,.0);
		}
		
		//Positive Test
		@Test
		public void positiveTestCircle()
		{
			Shape object=new Circle(5);
			double area=object.getArea();
			assertEquals(78,area,.5);
		}

		//Negative Test
		@Test
		public void negativeTestCircle() {
			Shape object=new Circle(4);
			double area=object.getArea();
			assertNotEquals(78,area,.5);
		}
}
