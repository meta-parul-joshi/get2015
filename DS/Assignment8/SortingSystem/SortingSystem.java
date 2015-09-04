package SortingSystem;

import java.util.LinkedList;

/*Class provides different types of sorting mechanism
 * @author parul.
 * */
public class SortingSystem implements iSortingSystem
{
	/*@param size defines size of array
	 * @param array stores array element.
	 * */
	int size;
	int[] array;
	String typeOfSort;
	
	/*Function to get array.*/
	public int[] getArray() {
		return array;
	}

	/*Function to set array.
	 * It takes array as key parameter.*/
	public void setArray(int[] array) {
		this.array = array;
	}

	/*Function to get array size.*/
	public int getSize() {
		return size;
	}

	/*Function to set array size.
	 * It takes size as key parameter.*/
	public void setSize(int size) {
		this.size = size;
	}
	
	/*Function perform comparison sort.It counts number of element in array. If number of elements less than or equal to 10 it performs bubble sort
	 * other wise quick sort.
	 * It returns a String defines type of sort performed.*/
	public String comparisonSort()
	{
		/*Check number of elements in array.*/
		if(getSize()<=10)
		{
			typeOfSort = "Bubble Sort";
			bubbleSort();
		}
		else
		{
			typeOfSort = "Quick Sort";
			quickSort(0 , getSize()-1);
		}
		
		return typeOfSort;
	}
	
	/*Function perform bubble sort.*/
	private void bubbleSort()
	{
		int n = getSize();
		for(int i = 0; i < n ; i++)
		{
			for(int j = 1; j < (n-i) ; j++)
			{
				if( array[j-1] > array[j])
				{
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	/*Function perform quick sort.*/
	private void quickSort(int lowerBound , int upperBound)
	{
		if((lowerBound<0)&&(upperBound<0))
		{
			return ;
		}
			
		int index=partition(lowerBound,upperBound);
			
		/*For left partition.*/
		if(lowerBound<index-1)
		{	
			quickSort( lowerBound, index-1);/*Recursion.*/
		}
			
		/*For right partition.*/
		if(upperBound>index)
		{	
			quickSort(index, upperBound);/*Recursion.*/
		}		
	}
	
	
	/*Function partition the array into smaller array so as to perform sorting among them using approach of
	* divide and conquor.Input array,left index and right index is passed as argument*/
	private int partition(int left,int right)
	{
		int pointer=array[left];
	    while(left<=right)
		{
			while(array[left]<pointer)
			{
				left++;
			}
			
			while(pointer<array[right])
			{
				right--;
			}
		
			if(left<=right)
			{
				int temp=array[left];
				array[left]=array[right];
				array[right]=temp;
				left++;			
			}
		}
	    
		return left;
	}
	
	/*Function perform linear sort.It finds largest of element in array. If number is less than two digit it performs counting sort
	 * other wise radix sort.
	 * It returns a String defines type of sort performed.*/
	public String linearSort()
	{
		int maximum = 0;
		for(int i = 0; i < getSize() ; i++)
		{
			if( array[i] > maximum)
			{
				maximum = array[i];
			}
		}
		
		if( maximum > 0 && maximum < 100)
		{
			typeOfSort = "Counting Sort";
			countingSort(maximum);
		}
		else
		{
			typeOfSort = "Radix Sort";
			radixSort(maximum);
		}
		
		return typeOfSort;
	}
	
	/*Function perform counting sort
	 * It takes largestNumber as key parameter.
	 * */
	private void countingSort(int largestNumber)
	{		
		int[] indexArray = new int[largestNumber+1];
		for(int i = 0 ; i < getSize() ; i++)
		{
			indexArray[array[i]] = indexArray[array[i]]+1;
		}
		
		int index = 0;
		for(int i = 0; i < indexArray.length ; i++)
		{
			while(indexArray[i] != 0)
			{			
				array[index] = i;
				indexArray[i] = indexArray[i]-1;
				index ++;
			}
		}
	}
	
	/*Function perform counting sort
	 * It takes maximum as key parameter.
	 * */
	private void radixSort(int maximum)
	{
		LinkedList<Integer>[] arrayOfLinkedList = new LinkedList[10];
		
		for(int i = 0 ; i < arrayOfLinkedList.length ; i++)
		{
			arrayOfLinkedList[i] = new LinkedList<Integer>();
		}
		
		int count = 1;
		while(maximum /count > 0)
		{
			for(int j = 0; j < getSize() ; j++)
			{
				int index = (array[j]/count) % 10; 
				arrayOfLinkedList[index].add(array[j]);
			}
			
			int position = 0;
			for(LinkedList<Integer> item : arrayOfLinkedList)
			{
				while(item.isEmpty() == false)
				{
					array[position] = (int)item.poll();
					position = position+1;
				}
			}
			
			count = count*10;
		}
	}
	
	/*Function traverse array and print it on console.*/
	public void printArray()
	{
		/*Check array is empty.*/
		if(array == null)
		{
			return;
		}
		else
		{	
			System.out.println("\nSorted Array is - ");
			for(int i=0;i<array.length;i++)
			{
				System.out.print(array[i]+" ");
			}
		}
	}
}
           