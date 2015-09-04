package SortingSystem;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class SortingSystemTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}
	
	boolean isArrayEquals(int expectedArray[], int actualArray[])
	{
		boolean isArrayEqual = true;
		for(int i = 0; i < actualArray.length ; i++)
		{
			if(actualArray[i] != expectedArray[i])
			{
				isArrayEqual = false;
			}
		}
		
		return isArrayEqual;
	}
	
	@Test
	public void testingComparisonSortValidCaseForBubbleSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {2,4,1,67,8};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		String actualTypeOfSorting = objectOfSortingSystem.comparisonSort();
		String expectedTypeOfSorting = "Bubble Sort";
		boolean flag = actualTypeOfSorting.equalsIgnoreCase(expectedTypeOfSorting);
		assertTrue(flag);
	}
	
	@Test
	public void testingBubbleSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {2,4,1,67,8};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		objectOfSortingSystem.comparisonSort();
		int[] expectedArray ={1,2,4,8,67};
		assertArrayEquals(expectedArray,objectOfSortingSystem.array);
		
	}
	
	@Test
	public void testingQuickSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {12,1,11,2,10,3,9,4,8,5,7,6};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		objectOfSortingSystem.comparisonSort();
		int[] expectedArray ={1,2,3,4,5,6,7,8,9,10,11,12};
		assertArrayEquals(expectedArray,objectOfSortingSystem.array);		
	}
	
	@Test
	public void testingCountingSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {34,67,12,8};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		objectOfSortingSystem.linearSort();
		int[] expectedArray ={8,12,34,67};
		assertArrayEquals(expectedArray,objectOfSortingSystem.array);
		
	}
	
	@Test
	public void testingRadixSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {342,671,12,8};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		objectOfSortingSystem.linearSort();
		int[] expectedArray ={8,12,342,671};
		assertArrayEquals(expectedArray,objectOfSortingSystem.array);
		
	}
	@Test
	public void testingComparisonSortInvalidCaseForbubbleSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {2,4,1,67,8};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		String actualTypeOfSorting = objectOfSortingSystem.comparisonSort();
		String expectedTypeOfSorting = "selectionSort";
		boolean flag = actualTypeOfSorting.equalsIgnoreCase(expectedTypeOfSorting);
		assertFalse(flag);
	}
	
	@Test
	public void testingComparisonSortValidCaseForQuickSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {2,4,1,67,8,23,11,89,12,99,45,101};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		String actualTypeOfSorting = objectOfSortingSystem.comparisonSort();
		String expectedTypeOfSorting = "Quick Sort";
		boolean flag = actualTypeOfSorting.equalsIgnoreCase(expectedTypeOfSorting);
		assertTrue(flag);
	}
	
	@Test
	public void testingComparisonSortInalidCaseForQuickSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {2,4,1,67,8,23,11,89,12,99,45,101};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		String actualTypeOfSorting = objectOfSortingSystem.comparisonSort();
		String expectedTypeOfSorting = "Tree Sort";
		boolean flag = actualTypeOfSorting.equalsIgnoreCase(expectedTypeOfSorting);
		assertFalse(flag);
	}
	
	@Test
	public void testingLinearSortValidCaseForCountingSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {23,67,99,76,42};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		String actualTypeOfSorting = objectOfSortingSystem.linearSort();
		String expectedTypeOfSorting = "Counting Sort";
		boolean flag = actualTypeOfSorting.equalsIgnoreCase(expectedTypeOfSorting);
		assertTrue(flag);
	}
	
	@Test
	public void testingLinearSortInvalidCaseForCountingSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {23,67,99,76,42};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		String actualTypeOfSorting = objectOfSortingSystem.linearSort();
		String expectedTypeOfSorting = "tree Sort";
		boolean flag = actualTypeOfSorting.equalsIgnoreCase(expectedTypeOfSorting);
		assertFalse(flag);
	}
	
	@Test
	public void testingLinearSortValidCaseForRadixSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {23,67,99,765,427};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		String actualTypeOfSorting = objectOfSortingSystem.linearSort();
		String expectedTypeOfSorting = "Radix Sort";
		boolean flag = actualTypeOfSorting.equalsIgnoreCase(expectedTypeOfSorting);
		assertTrue(flag);
	}
	
	@Test
	public void testingLinearSortInalidCaseForRadixSort() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {23,67,99,765,427};
		objectOfSortingSystem.setArray(inputArray);
		objectOfSortingSystem.setSize(inputArray.length);
		String actualTypeOfSorting = objectOfSortingSystem.linearSort();
		String expectedTypeOfSorting = "merge Sort";
		boolean flag = actualTypeOfSorting.equalsIgnoreCase(expectedTypeOfSorting);
		assertFalse(flag);
	}
	
	@Test
	public void testingSizeValidCase() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {23,67,99,765,427};
		objectOfSortingSystem.setSize(inputArray.length);
		int expectedSize = 5;
		int actualSize = objectOfSortingSystem.getSize();
		assertEquals("match",expectedSize,actualSize);
	}
	
	@Test
	public void testingSizeInvalidCase() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {23,67,99,765,427};
		objectOfSortingSystem.setSize(inputArray.length);
		int expectedSize = 234;
		int actualSize = objectOfSortingSystem.getSize();
		assertNotEquals("Not match",expectedSize,actualSize);
	}
	
	@Test
	public void testingInputArrayValidCase() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {23,67,99,765,427};
		objectOfSortingSystem.setArray(inputArray);;
		int[] expectedArray = {23,67,99,765,427};
		int[] actualArray = objectOfSortingSystem.getArray();
		assertArrayEquals("Not match",expectedArray,actualArray);
	}
	
	@Test
	public void testingInputArrayInvalidCase() 
	{
		SortingSystem objectOfSortingSystem = new SortingSystem();
		int[] inputArray = {23,67,99,765,427};
		objectOfSortingSystem.setArray(inputArray);;
		int[] expectedArray = {465,798,98,45,78};
		int[] actualArray = objectOfSortingSystem.getArray();
		boolean isArrayEquals = isArrayEquals(expectedArray, actualArray);
		assertFalse(isArrayEquals);
	}
}
