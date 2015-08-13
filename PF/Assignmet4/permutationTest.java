import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class permutationTest {

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
	public void permutationTestFor3VariableString() {
		
		permutation testObject1 = new permutation();
		String expectedPermutations[] = {"abc","acb","bac","bca","cab","cba"};
		List<String> actualPermutationList;
		actualPermutationList=testObject1.generatePermutations("abc");
		int i=0;
		for(String s : actualPermutationList)
		{
			assertEquals("", expectedPermutations[i], s);
			i++;
		}
		
	}
	
	@Test
	public void permutationTestFor4VariableString() 
	{
		
		permutation testObject2 = new permutation();
		String expectedPermutations[] = {"ABCD","ABDC","ACBD","ACDB","ADBC","ADCB","BACD","BADC","BCAD","BCDA","BDAC","BDCA","CABD","CADB","CBAD","CBDA","CDAB","CDBA","DABC","DACB","DBAC","DBCA","DCAB","DCBA"};
		List<String> PermutationList;
		PermutationList=testObject2.generatePermutations("ABCD");
		int i=0;
		for(String s : PermutationList)
		{
			assertEquals("", expectedPermutations[i], s);
			i++;
		}
		
	}

}
