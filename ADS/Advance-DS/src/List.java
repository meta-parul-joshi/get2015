
public class List 
{
	ListNode firstNode;
	private int max;
	private int sum;
	private int size;
	private int index;
	private String  input;
	private char currentChar;

	/* Default Constructor of class List */
	public List() 
	{
		firstNode = null;
	}

	/* Parameterized Constructor that takes String argument
	 * and create a list using the string */
	public List(String input) 
	{		
		/* max holds the maximum maximum element in the list 
		 * by default max contains the minimum value amongst
		 * the integers that can be obtained by Integer.MIN_VALUE
		 * Here MIN_VALUE is a constant of Integer class
		 * */;
		 max = Integer.MIN_VALUE;

		 /* sum will contain the sum of all the elements in
		  * the list
		  */
		 sum = 0;
		 index = 1;

		 /* size will contain the number of elements in the lise */
		 size = 0;

		 this.input = input;

		 /* createLsit will return a list whose reference will
		  * be hold by first
		  */
		 firstNode = createList();
	}

	/*Method to create generalized list*/
	private ListNode createList( )
	{
		ListNode head = null;
		ListNode prev = null;

		/* flag is initially set to 1 */
		int flag = 1;
		if(index < input.length()) 
		{
			currentChar = input.charAt(index);
		}

		/* do while loop to to create the list until
		 * the input string is fully traversed
		 */
		do{
			/* switch case to compare current character */
			switch (currentChar)
			{

			/* if currentChar is '(' then this case will be executed */
			case '(':
	
					/* increasing index value */
					index++;
					/* creating a new node */
					ListNode newNode = new ListNode();
	
					/* setting the tag value to 1 of the newly created node */
					newNode.setTag(1);
	
					/* recursively call the method to create list */
					newNode.setData(createList());
	
					/* next of the node is null */
					newNode.setNext(null);
	
					/* if head node contains null then
					 * the new node will become the head node
					 * and prev node.
					 */
					if(head == null) {
						head = newNode;
						prev = newNode;
					} 
	
					/* If head is not null then new node will be
					 * next node to the prev node.
					 * and now new node will be the prev node.
					 */
					else {
						prev.setNext(newNode);
						prev = newNode;
					}
					break;

					/* If current character is a digit then this case will be executed */
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':

					/* number contains the current character in string format */ 
					String number = Character.toString(currentChar);
	
					/* increasing index */
					index++;
					currentChar = input.charAt(index);
	
					/* iterating until the currentChar is a digit */ 
					while( currentChar >= '0' && currentChar <= '9' ) {						
						/* adding current character to the string number */
						number += currentChar;
						/* increasing index */
						index++;
						currentChar = input.charAt(index);
					}
	
					/* data will hold the integer representation of the 
					 * string number */
					int data = Integer.parseInt(number);
					/* incrementing size */
					size++;
	
					/* creating a new node */
					ListNode newNode1 = new ListNode();
	
					/* set the tag value to 0 */
					newNode1.setTag(0);
	
					/* set the data to hold the value data */
					newNode1.setData(data);
	
					/* set next to null */
					newNode1.setNext(null);
	
					/* if Head is null then the newly created node
					 * will become the head and prev
					 */
					if(head == null) 
					{
						head = newNode1;
						prev = newNode1;
					} 
	
					/* If head is not null then the newly created node will become
					 * next to the previous node
					 * and then the new node will be assigned to prev node.
					 */
					else {
						prev.setNext(newNode1);
						prev = newNode1;
					}
	
					break;

					/* if currentChar is ',' then this case will be executed */
			case ',':
					/* incrementing index by 1 */
					index++;
					currentChar = input.charAt(index);
					break;

					/* if currentChar is ')' then this case will be executed */
			case ')' :
					/* flag will be set to 0 */
					flag = 0;
	
					/* incrementing index by 1 */
					index++;
					if(index < input.length())
					{
						currentChar = input.charAt(index);
					}
	
					return head;

					/* If none of the case value matches then this part
					 * will be executed */
			default:
					flag = 0;
					break;
			}

		} while( flag != 0 || index < input.length());

		return head;
	}


	/* Method to get maximum element from a list*/
	public int max(ListNode first)
	{
		while(first != null ) 
		{

			/* if tag value is zero then the node has some integer 
			 * data otherwise it has reference to another list
			 */
			if(first.getTag() == 0)
			{

				/* finding max */
				if(max<(Integer)first.getData()) 
				{
					max =(Integer)first.getData();
				}

				first = first.getNext();
			} 
			else
			{
				/* recursive calling of traverse() */
				ListNode node = (ListNode)first.getData();
				max(node);
				first = first.getNext();
			}
		}
		return max;		
	}

	/* Method to get sum of elements of a list */
	public int sum(ListNode first) 
	{
		while(first != null ) 
		{

			/* if tag value is zero then the node has some integer 
			 * data otherwise it has reference to another list
			 */
			if(first.getTag() == 0)
			{
				/* calculating sum */
				sum += (Integer)first.getData();

				first = first.getNext();
			} 
			else
			{
				/* recursive calling of traverse() */
				ListNode node = (ListNode)first.getData();
				sum(node);
				first = first.getNext();
			}
		}
		
		return sum;
	}

	/* Method to get size of a list*/
	public int size() 
	{
		return size;
	}
	
	public boolean search(ListNode first, int number)
	{
		boolean flag = false;
		while(first != null ) 
		{

			/* if tag value is zero then the node has some integer 
			 * data otherwise it has reference to another list
			 */
			if(first.getTag() == 0)
			{
		
				if(number == (Integer)first.getData())
				{		
					flag = true;
					return flag;
				}				
			} 
			else
			{
				/* recursive calling of traverse() */
				ListNode node = (ListNode)first.getData();
				flag = search(node,number);
			}
			
			first = first.getNext();
		}
		
		return flag;
	}
}
