import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;


public class BinarySearchTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void findLeftMostOccurance() 
	{
		BinarySearchUsingRecursion objectOfbiBinarySearch=new BinarySearchUsingRecursion();
		int expectedlocation=1;
		int[] inputArray={2,5,5,9,10,55,77};
		int numberToSearch=5;
		int lowerBound=0,upperBound=6;
		int actuallocation=objectOfbiBinarySearch.binarySearch(numberToSearch,inputArray);
		assertEquals("Match",expectedlocation,actuallocation);
		
	}
	@Test
	public void binarySearchtestNumberNotExist() 
	{
		BinarySearchUsingRecursion objectOfbiBinarySearchUsingRecursion=new BinarySearchUsingRecursion();
		int expectedlocation=-1;
		int[] inputArray={2,5,8,9,10,55,77};
		int number=66;
		int actuallocation=objectOfbiBinarySearchUsingRecursion.binarySearch(number,inputArray);
		assertEquals("Match",expectedlocation,actuallocation);
		
	}
	
	@Test
	public void binarySearchtestNumberExist() 
	{
		BinarySearchUsingRecursion objectOfbiBinarySearchUsingRecursion=new BinarySearchUsingRecursion();
		int expectedlocation=0;
		int[] inputArray={2,5,8,9,10,55,77};
		int number=2;
		int actuallocation=objectOfbiBinarySearchUsingRecursion.binarySearch(number,inputArray);
		assertEquals("Match",expectedlocation,actuallocation);
		
	}
	
	@Test
	public void testSizeOfArray() 
	{
		BinarySearchUsingRecursion obRecursion = new BinarySearchUsingRecursion();
		obRecursion.setSize(5);
		int expectedlSize=5;
		int actualSize = obRecursion.getSize();
		assertEquals("Match",expectedlSize,actualSize);
	}
	
	@Test
	public void testArrayElements() 
	{
		BinarySearchUsingRecursion obRecursion = new BinarySearchUsingRecursion();
		int[] inputArray={2,5,8,9,10,55,77};
		obRecursion.setArray(inputArray);
		int[] expectedArray = {2,5,8,9,10,55,77};
		int[] actualArray = obRecursion.getArray();
		assertArrayEquals(expectedArray, actualArray);
	}
}
