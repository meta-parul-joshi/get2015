package SortingSystem;

import java.util.Scanner;

/*Class perform user defined sorting system.
 * @author parul.
 * **/
public class SortingSystemMain
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("Sorting system");
		
		/*Initialize object of class to access methods of class.*/
		SortingSystem objectSortingSystem = new SortingSystem();
		
		while(true)
		{
			/*Show menu to user.*/
			System.out.println("\n\nMenu : ");
			System.out.println("1). Create array");
			System.out.println("2). Comparision sort");
			System.out.println("3). Linear sort");
			System.out.println("4). Exit");
			
			/*Input from user.*/
			int choice = Utility.getIntegerValue("\nEnter choice");
			switch(choice)
			{
				case 1:/*Input array size from user.*/ 
						int sizeOfArray = Utility.getIntegerValue("Enter size of array");
						objectSortingSystem.setSize(sizeOfArray);
					
						/*Input array elements from user.*/
						int[] inputArray = getArray(sizeOfArray);
						objectSortingSystem.setArray(inputArray);
						break;
					   
						/*Comparison sort*/
				case 2:/*Check empty array.*/
						if(objectSortingSystem.getSize()==0)
						{
							System.out.println("Array is empty");
						}
						else
						{
							String typeOfSort = objectSortingSystem.comparisonSort();
							Utility.showMessage(typeOfSort);					
						}
					   break;
					   
					   	/*Linear sort.*/
				case 3:/*Check empty array.*/
						if(objectSortingSystem.getSize()==0)
						{
							System.out.println("Array is empty");
						}
						else
						{
							String typeOfSort = objectSortingSystem.linearSort();
							Utility.showMessage(typeOfSort);		
						}
					   break;
					   
					   /*Exit.*/
				case 4:System.out.println("System exited");
						System.exit(0);
					   break;
					   
				default :System.out.println("Wrong choice.......!!!");
						 break;
			}
			
			/*Display array.*/
			objectSortingSystem.printArray();
		}

	}
	
	/*Function takes array element as input from user.
	 * It takes size as key parameter.
	 * It returns array.
	 * */
	static int[] getArray(int size)
	{
		int array[]=new int[size];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Array Elements  : ");
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
			sc.close();
		}
				
		return array;
	}

}
