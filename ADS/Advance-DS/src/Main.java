import SlidingPuzzle.Utility;


public class Main {
	
	public static void main(String[] args) 
	{
		System.out.println("\tGeneralized List \n");
		while (true)
		{
			List objectList = null;
			String inputString = Utility.getStringInput("Enter list :");
			if(Validation.isExpression(inputString))
			{
				inputString = "(" + inputString + ")";
				//System.out.println(Validation.isExpression(inputString));
				objectList = new List(inputString);
				while(true)
				{
					System.out.println("1. Largest digit in list.");
					System.out.println("2. Sum of all nodes. ");
					System.out.println("3. Find node in list.");
					System.out.println("4. Exit");
					int choice = Utility.getIntegerValue("Enter your choice :");
					
					switch(choice)
					{	
					case 1 :if(objectList.size() == 0)
							{
								System.out.println("List is empty");
							}
							else
							{
								System.out.println("Largest = " + objectList.max(objectList.firstNode));
							}
							break;
							
					case 2 :if(objectList.size() == 0)
							{
								System.out.println("List is empty");
							}
							else
							{
								System.out.println("Sum = " + objectList.sum(objectList.firstNode));
							}
							break;
							
					case 3 :int number = Utility.getIntegerValue("Enter number to search");
							if(objectList.size() == 0)
							{
								System.out.println("List is empty");
							}
							else
							{
								boolean flag = objectList.search(objectList.firstNode, number);
								System.out.println(flag);
							}
							break;
							
							
					case 4 :System.out.println("System exited");
							System.exit(0);
							break;
							
					default :System.out.println("Wrong choice...!!");
							 break;
					
						
					}
					
					System.out.println(objectList.firstNode);
				}			
			}
			else
			{
				System.out.println("\nEnter a valid expression");
			}			
		}		
	}
}
