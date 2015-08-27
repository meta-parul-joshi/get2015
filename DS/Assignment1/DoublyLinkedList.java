import java.util.Scanner;

/* Class DoyblylinkedList */
public class DoublyLinkedList<T> implements iDoublyLinkedList<T>
{ 
	 DoublyNode<T> start;
	 DoublyNode<T> end ;
	 int count;
	 
	/* Constructor */ 
	public DoublyLinkedList() 
	{
		start = null; 
		end = null;
	}	
	
	/*Function counts node in list.*/
	private int countNodes()
    {
    	int counter = 0;
    	DoublyNode<T> pointer = start;
    	if (start == null) 
		{
			return counter;
		}
    	
    	while(pointer != null)
    	{
    		pointer=pointer.getFront();
    		count = counter+1;	
    	}
    	
    	return counter;   	
    }

	/* Function to insert element at beginning */ 
	public void insertAtStart(T value) 
	{
		DoublyNode<T> newNode  = new DoublyNode<T>(value);
		if(start == null)
		{
			start = newNode;
			end = start;
		}
		else 
		{
			start.setBack(newNode);
			newNode.setFront(start);
			start = newNode;
		}
	} 
	
	/* Function to insert element at end */ 
	public void insertAtEnd(T value) 
	{
		DoublyNode<T> newNode = new DoublyNode<T>(value); 
		if(start == null) 
		{
			start = newNode; 
			end = start; 
		}
		else
		{
			newNode.setBack(end); 
			end.setFront(newNode); 
			end = newNode;
		} 
	} 
	
	/* Function to insert element at position */ 
	public void insertAtposition(T value , int position) 
	{
		DoublyNode<T> newNode = new DoublyNode<T>(value);
		if (position == 1)
		{
			insertAtStart(value);
			return;
		}
		DoublyNode<T> pointer = start;
		count = countNodes();
		if (position < count)
		{	
			for (int i = 2; i <= position&& i <=count; i++)
			{
				pointer = pointer.getFront(); 
					
			}
			
			DoublyNode<T> temp = pointer.getFront();
			pointer.setFront(newNode); 
			newNode.setBack(pointer); 
			newNode.setFront(temp); 
			(pointer.getFront()).setBack(newNode);
		}
		else
			insertAtEnd(value);
			
	}
	
	/* Function to delete node at position */
	public boolean deleteAtposition(int position)
	{
		if (position == 1)
		{
			if (start == null) 
			{
				start = null;
				end = null; 
				return false; 
			}
			start = start.getFront();
			start.setBack(null);
			return true;
		}
		
		DoublyNode<T> pointer = start.getFront();
		for (int i = 2; i <= position; i++)
		{
			if (i == position) 
			{
				DoublyNode<T> previousNode = pointer.getBack();
				DoublyNode<T> nextNode = pointer.getFront();
				previousNode.setFront(nextNode); 
				nextNode.setBack(previousNode);			
				return true;
			}
			pointer = pointer.getFront();
		}
		return false;
	}
	
	/* Function to delete node by value.*/
	public boolean deleteByValue(T item)
	{
		DoublyNode<T> pointer = start.getFront();
        if(start == null)
        {
        	return false;
        }
        
        if (item == start.getItem())
        {
        	if (start.getFront() == null) 
			{
				start = null;
				end = null; 
			
				return true; 
			}
        	
            start = start.getFront();
            start.setBack(null);
            return true;
        }
        
    	if (item == end.getItem())
		{
			end = end.getBack(); 
			end.setFront(null);
			return true;
		}
        else 
        {
            while((pointer.getItem() != item) )//&& (pointer.getLink() != null)
            {
                pointer = pointer.getFront();
            }
        	DoublyNode<T> previousNode = pointer.getBack();
			DoublyNode<T> nextNode = pointer.getFront();
			previousNode.setFront(nextNode); 
			nextNode.setBack(previousNode);
			return true;         
        }
	}
	
	/* Function to reverse the list */
	public void reverseLinkedList() 
	{
		DoublyNode<T> tempnode1 = null, tempnode2;
		DoublyNode<T> current = start;
		while (current != null)
		{
			tempnode2 = tempnode1;
			tempnode1 = current;
			current = current.getFront();
			tempnode1.setFront(tempnode2);
			tempnode1.setBack(current);
		}
		start = tempnode1;
	}
	
	/*Function to sort the doubly LinkedList.*/
	public void sortLinkedList()
	{
		DoublyNode<T> first = start;
		while(first != null)
    	{
    		DoublyNode<T> second = first.getFront();
    		while(second != null)
    		{
    			if((Integer)(first.getItem()) > (Integer)(second.getItem()))
    			{
    				DoublyNode<T> temp = new DoublyNode<T>();
    				temp.setItem(first.getItem());
    				first.setItem(second.getItem());
    				second.setItem(temp.getItem()); 
    			}
    			second = second.getFront();
    		}
    		first = first.getFront();
    	}	
	}
		
	/* Function to display status of list */
	public void display()
	{
		System.out.print("\nDoubly Linked List = ");
		if (start == null) 
		{
			return; 
		}
		if (start.getFront() == null) 
		{
			System.out.println(start.getItem() );
			return;
		}
		
		DoublyNode<T> pointer = start;
		System.out.print(start.getItem()+ " <-> ");
		pointer = start.getFront();
		while (pointer.getFront() != null)
		{
			System.out.print(pointer.getItem()+ " <-> ");
			pointer = pointer.getFront();
		}
		System.out.print(pointer.getItem()+ "\n");
	}

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		/* Creating object of linkedList */ 
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>(); 
		System.out.println("Doubly Linked List \n"); 
		int item;
		boolean bool;
		int location;
		/* Perform list operations */ 
		try
		{
			while(true)
			{
				System.out.println("\nDoubly Linked List Operations\n"); 
				System.out.println("1. insert at begining"); 
				System.out.println("2. insert at end");
				System.out.println("3. insert at positionition");
				System.out.println("4. delete at positionition ");
				System.out.println("5. Delete By value "); 
				System.out.println("6. Reverse Linkedlist");
				System.out.println("7. Sort Linkedlist");
				System.out.println("8. Print Linked list");
				System.out.println("9. Exit. ");
				int choice =  Utility.getValue("Enter your choice"); 
				switch (choice) 
				{ 
					case 1 : item = Utility.getValue("Enter item to be inserted in linked list : ");
							list.insertAtStart(item ); 
							break; 
					case 2 : System.out.println("Enter integer element to insert");
							list.insertAtEnd( scan.nextInt() );
							break;
					case 3 :item = Utility.getValue("Enter item to be inserted in linked list : ");
							location =Utility.getValue("Enter location at which item to be inserted ");
							list.insertAtposition(item,location);
							break;
					case 4 : location =Utility.getValue("Enter location from element to be deleted ");
							bool = list.deleteAtposition(location);
							if(bool)
								System.out.println("item successfull deleted");
							else
								System.out.println("item not deleted");
							break;
	
					case 5 :item = Utility.getValue("Enter item to be deleted from linked list : ");
							list.deleteByValue(item);
							break;
					case 6 : list.reverseLinkedList();
							break; 
					case 7 : list.sortLinkedList(); 
							break; 
					case 8 :list.display(); 
							break; 
					case 9 : System.exit(0);
							break; 
					default : System.out.println("Wrong Entry \n ");
							break;
				} 
				
				/* Display List */
				list.display(); 
			}
		}
		catch(Exception e)
		{
			scan.close();
		}
	}
}