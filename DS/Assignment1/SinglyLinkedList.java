
/*Class implements singly linked list.
 * @author Parul.
 * */
public class SinglyLinkedList <T> implements iSinglyLinkedList<T>
{
    Node<T> start;
    int count;
    /*Constructor.*/
    public SinglyLinkedList ()
    {
    	start = null;  	
    }
    
    /* Function to insert element at end */ 
    public boolean addNodeAtLast(T data) 
    {
        Node<T> newNode = new Node<T>(data);
        Node<T> currentNode = start;
        if (start == null) 
        {
            start = newNode;
        } 
        else 
        {
            while (currentNode.getLink() != null) 
            {
               currentNode = currentNode.getLink();
            }
            
            currentNode.setLink(newNode);         
        }
       
        return true;
    }
    
    /*Function counts node in list.*/
    int countNodes()
    {
    	int counter = 0;
    	Node<T> pointer = start;
    	if (start == null) 
		{
			return counter;
		}
    	
    	while(pointer != null)
    	{
    		pointer=pointer.getLink();
    		count = counter+1;	
    	}
    	
    	return counter;   	
    }
    
    /* Function to insert element at position */ 
    public boolean addNodeAtParticularLocation(T data, int location) 
    {
    	Node<T> newNode = new Node<T>(data);
        Node<T> pointer = start;
        count = countNodes();
        if (location == 0)
        {
            newNode.setLink(start);
            start = newNode;
        } 
        else if ( location < count)
        {
            for(int i = 1; i < location ; i++)
            {
                pointer = pointer.getLink();
            }
            
            newNode.setLink(pointer.getLink());
            pointer.setLink(newNode);           
        }
        else
        {
        	 while (pointer.getLink() != null) 
             {
                pointer = pointer.getLink();
             }
             
             pointer.setLink(newNode);   
        }
        
        return true;
    }
    
    /* Function to delete node at position */
    public boolean removeFromIndex(int index) 
    {
        Node<T> pointer = start;
        if(start == null)
        {
        	return false;
        }
        
        if (index == 0)
        {
            start = start.getLink();
            return true;
        } 
        else 
        {
            for (int i = 1; i < index; i++)
            {
                pointer = pointer.getLink();
            }
            
            pointer.setLink(pointer.getLink().getLink());
            return true;
        }         
    }
    
    /* Function to delete node by value.*/
    public boolean removeByValue(T item) 
    {
        Node<T> pointer = start;
        Node<T> previous = null;
        if(start == null)
        {
        	return false;
        }
        if (item == start.getItem())
        {
            start = start.getLink();
            printLinkedList();
            return true;
        } 
        else 
        {
            while((pointer.getItem() != item) )
            {
            	previous = pointer;
                pointer = pointer.getLink();
            }

            previous.setLink( pointer.getLink());
            return true;
        }
    }
    
    /* Function to retrieve node by value.*/
    public T retrivingItem(int index) 
    {
    	T item;
        Node<T> pointer = start;
        if(index == 0)
        {
        	return start.getItem();
        }
        else
        {
        	for (int i = 1; i <= index; i++)
        	{
        		pointer = pointer.getLink();
        	}
        	item = pointer.getItem();
        	return item;
        }
    }
    
    /*Function sort the list.*/
    public void sortingOfLinkedlist()
    {
    	Node<T> first = start;
    	
    	while(first != null)
    	{
    		
    		Node<T> second = first.getLink();
    		while(second != null)
    		{
    			if((Integer)(first.getItem()) > (Integer)(second.getItem()))
    			{
    				Node<T> newNode = new Node<T>();
    				newNode.setItem(first.getItem());
    				first.setItem(second.getItem());
    				second.setItem(newNode.getItem()); 
    			}
    			second = second.getLink();
    		}
    		first = first.getLink();
    	}
    }
    
    /**Function reverse list.*/
    public void reverseLinkedList()
    {
    	Node<T> prev = null;
    	Node<T> newNode = start;
    	Node<T> next = newNode.getLink();
    	while (newNode != null)
    	{
    		if (next == null)
    			break;

    		newNode.setLink(prev);
    		
    		prev = newNode;
    		newNode = next;
    		next = next.getLink();
    	}
    	
    	newNode.setLink(prev);
    	start = newNode;
    }
    
    /*Function traverse list.*/
    public void printLinkedList()
    {
    	Node<T> pointer = start;
    	if (start.getLink() == null) 
		{
    		System.out.print("\n Linked list is : ");
			System.out.print(start.getItem() );
			return;
		}
    	
    	System.out.print("\n Linked list is : ");
    	while(pointer != null)
    	{
    		
    		System.out.print(pointer.getItem()+" -> ");
    		pointer=pointer.getLink();
    	}  
    	System.out.print("\n");
    }
    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Linked list   \n");
		SinglyLinkedList<Integer> objectLinkedList = new SinglyLinkedList<Integer>();
		int item;
		int location;
		int choice;
		boolean bool;
		System.out.println("Linked list operation :\n ");
		while(true)
		{
			System.out.println("\n\n1). Insert element ");
			System.out.println("2). Insert element at particular position ");
			System.out.println("3). Delete element from particular location ");
			System.out.println("4). Delete element by value ");
			System.out.println("5). Retriving item from index ");
			System.out.println("6). Reverse linked list ");
			System.out.println("7). Sorting linked list ");
			System.out.println("8). Print linked list");
			System.out.println("9). Exit");
			choice = Utility.getValue("Enter your choice");
			switch(choice)
			{
			case 1 : item = Utility.getValue("Enter item to be inserted in linked list : ");
						bool = objectLinkedList.addNodeAtLast(item);
						if(bool)
							System.out.println("item successfull added in linked list");
						else
							System.out.println("item not inserted in linked list");
						break;
			case 2 : item = Utility.getValue("Enter item to be inserted in linked list : ");
					location =Utility.getValue("Enter location at which item to be inserted ");
					bool = objectLinkedList.addNodeAtParticularLocation(item,location-1);
					if(bool)
						System.out.println("item successfull added in linked list");
					else
						System.out.println("item not inserted in linked list");
					break;	
					
			case 3 : location =Utility.getValue("Enter location from element to be deleted ");
					bool = objectLinkedList.removeFromIndex(location-1);
					if(bool)
						System.out.println("item successfull deleted");
					else
						System.out.println("item not deleted");
					break;	
			case 4 : item =Utility.getValue("Enter element to be deleted ");
					bool = objectLinkedList.removeByValue(item);
					if(bool)
						System.out.println("item successfull deleted");
					else
						System.out.println("item not deleted list is empty");
					break;
			case 5 : location =Utility.getValue("Enter location from element to be retrived ");
					item = objectLinkedList.retrivingItem(location-1);
					
						System.out.println("item : " +item);
					
						//System.out.println("item not exist");
					break;
			case 6 : objectLinkedList.reverseLinkedList();
						break;
			case 7 : objectLinkedList.sortingOfLinkedlist();
					break;
			case 8 : objectLinkedList.printLinkedList();
					break;
			case 9 : System.exit(0);
					break;
			default :System.out.println("Wrong choice....!!!");
					break;
			}
			objectLinkedList.printLinkedList();
		}
	}
}
