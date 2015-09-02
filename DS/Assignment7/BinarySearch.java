
public class BinarySearch 
{
	public static void main(String[] args) 
	{
		/*Initialize object of class to call function of class.*/
		BinarySearchUsingRecursion objectOfbiBinarySearch=new BinarySearchUsingRecursion();	
		
		while (true)
		{	
			/*Show menu to user.*/
			System.out.println("\n\nMenu : ");
			System.out.println("1). Create an array");
			System.out.println("2). Search element in array");
			System.out.println("3). Exit");
			
			/*Input from user.*/
			int choice = Utility.getIntegerValue("\nEnter choice");
			switch(choice)
			{
				case 1 :/*Input array size from user.*/ 
						int sizeOfArray = Utility.getIntegerValue("Enter size of array");
						objectOfbiBinarySearch.setSize(sizeOfArray);
						
						/*Input array elements from user.*/
						int[] inputArray = objectOfbiBinarySearch.inputArray(sizeOfArray);
						objectOfbiBinarySearch.setArray(inputArray);
						break;
						
				case 2:sizeOfArray = objectOfbiBinarySearch.getSize();
					if(sizeOfArray == 0)
						{
							System.out.println("Array is empty");
						}
						else/*Input number to be search from user.*/ 
						{
							
							int numberToSearch = Utility.getIntegerValue("Enter number to be search");
							int position=objectOfbiBinarySearch.binarySearch(numberToSearch,objectOfbiBinarySearch.getArray());
						   
							/*If number exist in array print its location.*/
							if(position>=0)
							{
								System.out.println("Left most location of number "+numberToSearch+" is "+position);
							}
							/*Element does not exist in array.*/
							else
							{
								System.out.println("Number does not exist in array");
							}
						}
						break;
						
				case 3 : System.out.println("System exited");
						System.exit(0);
						break;
				default: System.out.println("Wrong choice...!!");
							break;
				
			}
		
			/*Display array.*/
			objectOfbiBinarySearch.printArray(objectOfbiBinarySearch.getArray());
		}
	}
}
