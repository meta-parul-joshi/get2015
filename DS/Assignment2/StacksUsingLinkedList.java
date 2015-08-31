/*Class implements interface iStacksUsingLinkedList to perform operation on stack.
 * @author parul.
 * */
public class StacksUsingLinkedList <T> implements iStacksUsingLinkedList<T>
{
	Node<T> top ;
	int size ;
	 
	/*  Constructor  */
	public StacksUsingLinkedList ()
	{
		top = null;
		size = 0;
	}   
	 
	/*  Function to check if stack is empty */
	public boolean isEmpty()
	{
		return top == null;
	}    
		    
	/*  Function to get the size of the stack */
	public int getSize()
	{
		return size;
	}    
		    
	/*  Function to push an element to the stack */
	public void push(T value)
	{
		Node<T> newNode = new Node<T>(value);
		if (top == null)
		{
			top = newNode;
		}
		else
        {
			newNode.setLink(top);
	        top = newNode;
	    }
		
		size++ ;
    }  
		    
	/*  Function to pop an element from the stack */
	public T pop()
	{        
		Node<T> pointer = top;
		top = pointer.getLink();
        size-- ;
        return pointer.getvalue();
    }    
		    
	/*  Function to check the top element of the stack */	   
	public T peek()
	{	
		return top.getvalue();
    }    
	
	/*  Function to display the status of the stack */
	public void display()
	{
		System.out.print("\nStack = ");
        if (size == 0) 
        {
            System.out.print("Empty\n");
            return ;
	    }
        
        Node<T> pointer = top;
        while (pointer != null)
        {
            System.out.print(pointer.getvalue()+" ");
            pointer = pointer.getLink();
        }

        System.out.println();        
    }
	
	public static void main(String[] args)
	{
        /* Creating object of class linkedStack */   
        StacksUsingLinkedList<Integer> objectStacksLinkedList = new StacksUsingLinkedList<Integer>() ;
        /* Perform Stack Operations */  
        System.out.println("Linked Stack \n");     
        while(true) 
	    {
        	System.out.println("\nLinked Stack Operations");
        	System.out.println("1. push");
	        System.out.println("2. pop");
	        System.out.println("3. peek");
	        System.out.println("4. check empty");
	        System.out.println("5. size");            
	        int choice = Utility.getIntegerValue("Enter your choice : ");
	        switch (choice) 
	        {
	            case 1 : objectStacksLinkedList.push( Utility.getIntegerValue("Enter integer element to insert") ); 
	                	break;                         
	            case 2 : if(objectStacksLinkedList.isEmpty())
	            		{
	            			break;
	            		}
	            		else
	            		{
	            			System.out.println("Popped Element = "+ objectStacksLinkedList.pop());
	            		}
	            		break;                         
	            case 3 :if(objectStacksLinkedList.isEmpty())
        				{
        					break;
        				}
        				else
        				{
        					System.out.println("Peek Element = "+ objectStacksLinkedList.peek());
        				}	
        				break;                       
	            case 4 : System.out.println("Empty status = "+ objectStacksLinkedList.isEmpty());
	                	break;                
	            case 5 : System.out.println("Size = "+ objectStacksLinkedList.getSize()); 
	                	break;                
	            case 6 : System.out.println("Stack = "); 
	                	objectStacksLinkedList.display();
	                	break;  
	            case 7: System.exit(0);
	            		break;
	            default : System.out.println("Wrong Entry \n ");
	                break;
	        }    
	        
	        /* display stack */    
	        objectStacksLinkedList.display();             
       }                 
	}
}
