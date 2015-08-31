public class QueueUsingLinkedList<T>
{
	Node<T> front, rear;
    public int size;
 
    /* Constructor */
    public QueueUsingLinkedList()
    {
        front = null;
        rear = null;
        size = 0;
    }    
    
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return front == null;
    }    
    
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return size;
    }    
    
    /*  Function to insert an element to the queue */
    public void enqueue(T value)
    {
        Node<T> newNode = new Node<T>(value);
        		
        if (rear == null)
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.setLink(newNode);
            rear = rear.getLink();
        }
        size++ ;
    }    
    /*  Function to remove front element from the queue */
    public T dequeue()
    {
        if (isEmpty() )
        {}
           
        Node<T> pointer = front;
        front = pointer.getLink();        
        if (front == null)
            rear = null;
        size-- ;        
        return pointer.getvalue();
    }    
    
    /*  Function to check the front element of the queue */
    public T getFront()
    {
        if (isEmpty() )
        {}   
        return front.getvalue();
    }    
    
    /*Function remove all elements of queue and make empty.*/
    void makeEmpty()
    {
    	front = null;
    	rear = null;
    	size = 0;
    }
    /*  Function to display the status of the queue */
    public void display()
    {
        System.out.print("\nQueue = ");
        if (size == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        Node<T> pointer = front;
        while (pointer != rear.getLink() )
        {
            System.out.print(pointer.getvalue()+" ");
            pointer = pointer.getLink();
        }
        System.out.println();        
    }

    public static void main(String[] args)
    {
        /* Creating object of class linkedQueue */   
        QueueUsingLinkedList<Integer> objectQueueLinkedList = new QueueUsingLinkedList<Integer>();            
        /* Perform Queue Operations */    
        System.out.println("Linked Queue \n");         
        while(true)
        {
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");
            System.out.println("6. make empty queue");
            System.out.println("7. Exit");
            int choice = Utility.getIntegerValue("Enter your choice : ");
            switch (choice)
            {
            case 1 : objectQueueLinkedList.enqueue( Utility.getIntegerValue("Enter integer element to insert") );
            		break;                         
            case 2 : System.out.println("Removed Element = "+ objectQueueLinkedList.dequeue());
                	break;                         
            case 3 : System.out.println("Peek Element = "+ objectQueueLinkedList.getFront());
                    break;                         
            case 4 :  System.out.println("Empty status = "+ objectQueueLinkedList.isEmpty());
                	break;
            case 5 : System.out.println("Size = "+ objectQueueLinkedList.getSize());
                	break; 
            case 6 : objectQueueLinkedList.makeEmpty();
            		break;
            case 7 : System.exit(0);
            		break;
 
            default : 
                System.out.println("Wrong Entry \n ");
                break;
            }                
            /* display queue */        
            objectQueueLinkedList.display();	                      
        }                                                            
    }
						   
}
