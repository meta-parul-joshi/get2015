import java.util.Scanner;


public class BinarySearchUsingRecursion 
{
	int size;
	int[] array;
	
	public int[] getArray() {
		return array;
	}


	public void setArray(int[] array) {
		this.array = array;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	/*Function has to perform binary search using recursion.
	 * It contains array, number,lowerBound and upperBound as
	 * parameter.*/
	int binarySearch(int[] array,int numbertosearch,int lowerBound,int upperBound)
	{
		/*If element does not exist return location -1.*/
		int mid = -1;
		if(lowerBound<upperBound)
		{
			/*Calculating middle element of array.*/
			mid=(lowerBound+upperBound)/2; 
			
			/*If middle element is same as number return its location.*/
			if(numbertosearch == array[mid])
			{
				while(--mid>=0)
				{
					if(array[mid] != numbertosearch)
					{
						break;
					}
				}
				
				return mid+1+1;
			}
			
			/*If number is greater then middle element then lower bound is pointed next to middle index.*/
			if(array[mid]>numbertosearch)
			{				
				upperBound=mid-1;
				return binarySearch(array,numbertosearch,lowerBound,upperBound);//Recursion.
			}
			else
			{
				/*If number is smaller then middle element then lower bound is pointed one before middle index.*/
				lowerBound=mid+1;
				return binarySearch(array,numbertosearch,lowerBound,upperBound);//Recursion.
			}
		}
		else 
		{
			/*Number does not exists.*/
			return mid;
		}
	}
	
	
	void printArray(int[] array)
	{
		if(array == null)
		{
			return;
		}
		else
		{	
			System.out.println("Array is - ");
			for(int i=0;i<array.length;i++)
			{
				System.out.print(array[i]+" ");
			}
		}
	}
	
	/*Function takes input array elements from console.
	 * It contain size as parameter*/
	int[] inputArray(int size)
	{
		int array[]=new int[size];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Array Elements in sorted order : ");
		try
		{
			for(int i=0;i<size;i++)
			{
				array[i]=Integer.parseInt(sc.next());
			}
		}	
		catch(Exception e)
		{
			System.out.println("Sorry!! invalid input");
			System.exit(0);  
		}
				
		return array;
	}
		
	/*Function takes a number as input to search in array from user.It contain size as parameter.*/
	int getNumberToSearch()
	{
		int number=0;
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter number to be searched :");
			number=Integer.parseInt(sc.nextLine());
		}
		catch(Exception e)
		{
			System.out.println("Sorry!! invalid input");
			System.exit(0);	
		}
	
		return number;
	}
	
	/*Function has to perform binary search .
	 * It contains array, item as parameter.
	 * If it finds item in array it returns left most location of item
	 * otherwise returns -1 */
	int binarySearch(int item , int[] array)
	{
		int location = -1;
		int lowerBound = 0;
		int upperBound = array.length-1;
		
		/*Loop invariant
		 * 1--> lowerBound will always less then upperBound.
		 **/
		while(lowerBound <= upperBound)
		{
			/*Calculating middle element of array.*/
			int mid = (lowerBound+upperBound)/2;

			/*If middle element is same as number return its location.*/
			if(array[mid]==item)
			{
				if(mid == lowerBound)
				{
					return mid;
				}
				else
				{
					upperBound = mid;
				}
			}
			else if(array[mid] > item)
			{
				/*If number is smaller then middle element then upper bound is pointed before to middle index.*/
				upperBound = mid-1;
			}
			else
			{
				/*If number is greater then middle element then lower bound is pointed next to middle index.*/
				lowerBound = mid+1;
			}
		}
		
		return location;
	}
}
