import java.util.LinkedList;

public class QueueImplementation 
{
	public static void main(String args[])
	{
		System.out.println("Queue implementation");
		LinkedList<Integer> queueList = new LinkedList<Integer>();
		while(true)
		{
			System.out.println("\nQueue operations : \n");
			System.out.println("1. Add an element to queue");
			System.out.println("2. Remove an element from queue");
			System.out.println("3. Get front element of queue");
			System.out.println("4. Display the queue");
			System.out.println("5. clear the queue");
			System.out.println("6. Exit");
			int choice = Utility.getIntegerValue("Enter your choice: ");
			switch(choice) 
			{
				case 1:	int number = Utility.getIntegerValue("Enter a numebr: ");
						queueList.addLast(number);
						break;
							
				case 2:	if(!queueList.isEmpty()) 
						{
							int result = queueList.poll();
							System.out.println("Removed Element is: "+result);
						}
						else
						{
							System.out.println("Queue is Empty");
						}
						break;
							
				case 3: if(!queueList.isEmpty())
						{
							int result = queueList.peek();
							System.out.println("Front Element is: "+result);
						}
						else
						{
							System.out.println("Queue is Empty");
							break;
						}
						break;
							
				case 4: if(!queueList.isEmpty())
						{
							System.out.print("Queue is: ");
							for(Integer queueElement : queueList )
							{
								System.out.print(queueElement+" ");
							}
								
							System.out.println();
						}
						else
						{
							System.out.println("Queue is Empty");
							break;
						}
						
						break;	
						
				case 5: queueList.clear();
						break;
							
				case 6: System.out.println("System Exited");
						System.exit(0);
						break;
							
				default: System.out.println("Enter correct choice");
						 break;
			}
			
		} 
	}
}


