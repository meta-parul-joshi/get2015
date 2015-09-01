

/** Class PriorityQueueTest **/
public class PriorityQueueTest
{
    public static void main(String[] args)
    {
        System.out.println("Priority Queue \n");   
        int sizeOfQueue = Utility.getIntegerValue("Enter size of priority queue ");
        PriorityQueue objectPQ = new PriorityQueue(sizeOfQueue );
        /*  Perform Priority Queue operations */
        while(true)   
        {
            System.out.println("\nPriority Queue Operations\n");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. Exit");
           
            int choice = Utility.getIntegerValue("Enter your choice ");            
            switch (choice) 
            {
            case 1 :System.out.println("\n Jobsender \n4. Chair Person (Highest Priority)\n3. Professor\n2. Graduates\n1. Under Graduates (Lowest Priority)");
            		if(objectPQ.isFull())
            		{
            			System.out.println("Queue is full");
            			break;
            		}
            		else
            		{
	            		for(int i = 0; i< sizeOfQueue; i++)
	            		{   
	            			boolean flag;
	            			do
	            			{
	            				int priority = Utility.getIntegerValue("Enter priority ");
	            				if(priority<=0 || priority >=5)
	            				{
	            					System.out.println("Sorry.. you are outsider ");
	            					flag = false;
	            				}
	            				else
	            				{
	            					objectPQ.insert( priority ); 
	            					flag = true;
	            				}
	            			}while(flag == false);			
	            		}
            		}
            		break;  
            		
            case 2 : if(objectPQ.isEmpty())
            		 {
            			System.out.println("Queue is empty");
            			break;
            		 }
            		 else
            		 {
            			 for(int i = 0; i< sizeOfQueue; i++)
            			 {
            				 System.out.println("\nJob removed \n\n"+ objectPQ.remove()); 
            			 }
            		 }
            		 break; 
            		
            case 3 : System.exit(0);
                	 break; 
            
            default : System.out.println("Wrong Entry \n ");
                	 break;   
            }                                   
        }             
    }
}
