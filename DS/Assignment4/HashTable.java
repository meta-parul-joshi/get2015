
/* Class HashTable */
public class HashTable
{ 
	private int TABLE_SIZE;
	private LinkedKey[] table;
	private int size;
	
	/* Constructor */
	public HashTable(int ts) 
	{
		size = 0;
		TABLE_SIZE = ts;
		table = new LinkedKey[TABLE_SIZE]; 
		for (int i = 0; i < TABLE_SIZE; i++)
		{
			table[i] = null; 
		}
	}
	

	/* Function to clear hash table */ 
	public void makeEmpty()
	{
		for (int i = 0; i < TABLE_SIZE; i++)
		{
			table[i] = null;
		}
	}
	
	/*Function returns number of customer in hotel.*/
	public int getSize()
	{
		return size;
	}

	/* Function to insert a key value pair */
	public void insert(int age, String name) 
	{
		int key = (age % TABLE_SIZE);
		if (table[key] == null) 
		{
			table[key] = new LinkedKey(age,name); 
		}
		else
		{
			LinkedKey node = table[key];
			while (node.next != null )  
			{
				node = node.next;
			}
			
			node.next = new LinkedKey(age , name);
		}
		
		size++;
	}
							
	/*Function prints chart of rooms.*/
	public void printRoomsAlloted()
	{
		int j =100;
		for (int i = 0; i < TABLE_SIZE; i++)
		{
			
			LinkedKey node = table[i];
			while (node != null) 
			{
				System.out.print("\nRoom number "+ (++j) +" : ");
				System.out.print(node.value +" ");
				node = node.next; 
			}
		}
	}
	
	/* Function to print hash table */ 
	public void printHashTable()
	{
		for (int i = 0; i < TABLE_SIZE; i++)
		{
			System.out.print("\nBucket"+ (i+1) +" : ");
			LinkedKey node = table[i];
			while (node != null) 
			{
				System.out.print(node.value +" ");
				node = node.next; 
			}
		}
	}
}
	