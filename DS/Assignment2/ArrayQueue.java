/*  Class arrayQueue implements queue using array.
 * @author parul.
 * */
public class ArrayQueue implements iArrayQueue
{
    int Queue[] ;
    int front, rear, size, lengthOfQueue;
 
    /* Constructor */
    public ArrayQueue(int n) 
    {
        size = n;
        lengthOfQueue = 0;
        Queue = new int[size];
        front = -1;
        rear = -1;
    }  
    
    /*  Function to check if queue is empty */
    public boolean isEmpty() 
    {
        return front == -1;
    }    
    
    /*  Function to check if queue is full */
    public boolean isFull() 
    {
        return front==0 && rear == size -1 ;
    }    
    
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return lengthOfQueue;
    }   
    
    /*  Function to check the front element of the queue */
    public int peek() 
    { 
    	return Queue[front];
    }  
    
    /*  Function to insert an element to the queue */
    public void enqueue(int item) 
    {
        if (rear == -1) 
        {
            front = 0;
            rear = 0;
            Queue[rear] = item;
        }
        else if (rear + 1 >= size)
        {
        	isFull();
        }
        else if ( rear + 1 < size)
        {
            Queue[++rear] = item;    
        }
        
        lengthOfQueue++ ;    
    }    
    
    /*  Function to remove front element from the queue */
    public int dequeue() 
    {
    	lengthOfQueue-- ;
        int element = Queue[front];
        if ( front == rear) 
        {
        	front = -1;
        	rear = -1;
        }
        else
        {
        	front++;                
        }
       
        return element;        
    }
    
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.print("\nQueue = ");
        if (lengthOfQueue == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        
        for (int i = front; i <= rear; i++)
        {
        	System.out.print(Queue[i]+" ");
        }
        
        System.out.println();        
    }
    
    /*Function remove all elements of queue and make empty.*/
    void makeEmpty()
    {
    	front = -1;
    	rear = -1;
    	lengthOfQueue = 0;
    }

    public static void main(String[] args)
    {
        System.out.println("Array Queue Test\n");
        int n = Utility.getIntegerValue("Enter Size of Integer Queue ");
        
        /* creating object of class arrayQueue */
        ArrayQueue objQueue = new ArrayQueue(n);  
        
        /* Perform Queue Operations */        
        while(true)
        {
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size");
            System.out.println("7. make empty.");
            System.out.println("8. Exit");
            int choice = Utility.getIntegerValue("Enter your choice");
            switch (choice)
            {
            case 1 :objQueue.enqueue( Utility.getIntegerValue("Enter integer element to insert") );
            		break;                         
            case 2 :if(objQueue.isEmpty())
            		{
            			break;
            		}
            		else
            		{
            			System.out.println("Removed Element = "+objQueue.dequeue());
            		}
            		break;
            case 3 :if(objQueue.isEmpty())
    				{
    					break;
    				}
    				else
    				{
    					System.out.println("Peek Element = "+objQueue.peek());
    				}
    				break;                          
            case 4 :System.out.println("Empty status = "+objQueue.isEmpty());
                	break;                
            case 5 :System.out.println("Full status = "+objQueue.isFull());
                	break;                          
            case 6 :System.out.println("Size = "+ objQueue.getSize());
                	break;    
            case 7 :objQueue.makeEmpty();
        			break;   
            case 8 :System.exit(0);
        			break;  
            default : System.out.println("Wrong Entry \n ");
            		   break;
            }
            /* display Queue */
            objQueue.display();            
        }                                                         
    }    
}
