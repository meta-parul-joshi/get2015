import static org.junit.Assert.*;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.ArrayList;
public class towerOfHanoiTest {

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

	@Test

public void testtowerOfHanoiFor3Disc() {
		
		towerOfHanoi testObject1 = new towerOfHanoi();
		List<String> actual = new ArrayList<String>();
		String expected[]={"Move Disc 1 from A to B","Move Disc 2 from A to C","Move Disc 1 from B to C","Move Disc 3 from A to B","Move Disc 1 from C to A","Move Disc 2 from C to B","Move Disc 1 from A to B"};
		actual=testObject1.towerOfHanoi("A", "B", "C", 3);
		int i=0;
		for(String s:actual)
		{
			assertEquals("", expected[i], s);
			i++;
		}
	}
	
	@Test
	public void testtowerOfHanoiFor1Disc() {
		
		towerOfHanoi testObject2 = new towerOfHanoi();
		List<String> actual = new ArrayList<String>();
		String expected[]={"Move Disc 1 from A to B"};
		actual=testObject2.towerOfHanoi("A", "B", "C", 1);
		int i=0;
		for(String s:actual)
		{
			assertEquals("", expected[i], s);
			i++;
		}
		
	}
	
	@Test
	public void testtowerOfHanoiFor2Disc() {
		
		towerOfHanoi testObject3 = new towerOfHanoi();
		List<String> actual = new ArrayList<String>();
		String expected[]={"Move Disc 1 from A to C","Move Disc 2 from A to B","Move Disc 1 from C to B"};
		actual=testObject3.towerOfHanoi("A", "B", "C", 2);
		int i=0;
		for(String s : actual)
		{
			assertEquals("", expected[i], s);
			i++;
		}
	}
}
