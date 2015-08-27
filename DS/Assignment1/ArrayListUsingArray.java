/*Class implements ArrayList using array.
 * @author Parul
 * */
public class ArrayListUsingArray implements iArraylist 
{
	static int sizeIncreasedByValue = 5;
	Object data[];
	int index;
	int size;
	
	//Constructor.
	public ArrayListUsingArray()
	{
		data = new Object[sizeIncreasedByValue];
		size = sizeIncreasedByValue;
	}
		
	//Add an Item in the array list at index.
	public void addValueInList(Object item)
	{
		//overflow, increase the size of data[]
		if( index == size-1 )
		{
			increaseSizeAndReallocate();
		}
		
		data[index] = item;
		index++;	
	}
			
	// Add an item at particular location
	public void addValueAtGivenLocation( Object item, int location )
	{
		//overflow, increase the size of data[]
		if( index == size )
		{
			increaseSizeAndReallocate();
		}
		
		if(location>index)
		{
			addValueInList(item);
		}
		else{
		for(int count = index; count>location ; count--)
		{
			data[count] = data[count-1];
		}
			
		data[location] = item;	
		index++;
		}
	}
			
	private void increaseSizeAndReallocate()
	{
		size = size + sizeIncreasedByValue;
		Object newData[] = new Object[size];
		for(int count=0; count<data.length; count++)
		{
			newData[count] = data[count];
		}
		
		data = newData;
	}
				
	// Retrieving the first index of particular item
	public int findFirstIndexOfItem ( Object item )
	{
		int count;
		for ( count = 0; count < data.length; count++ )
		{
			if ((data[count].toString()).equals(item.toString()))
				break;
		}
		
		return count+1;
	}
				
	// Retrieving the first occurrence of an item based on its given location
	public int firstOccurenceAfterGivenLocation( int location, Object item )
	{
		int count;
		for ( count = location-1; count < data.length; count++ )
		{
			if ((data[count].toString()).equals(item.toString()))
				break;
		}
		
		return count+1;
	}		
		
	// Removing an item based on particular location
	public void removeItemFromGivenLocation (int location) 
	{
		if(location > size-1)
		{
			System.out.println("Location out of bound");
		}
		
		if(location<0)
		{
			System.out.println("Negative index");
		}
			
		System.out.println("Item removed : "+data[location]);
		for(int count = location; count < data.length-1; count++)
		{
			data[count] = data[count+1];
		}
			
		index--;
	
	}
				
	// Remove given particular item from the array list
	public void removeItemFromList (Object item) 
	{
		for(int count = 0; count <= index; count++)
		{
			if(data[count].toString().equals(item.toString()))
			{
				for(int count1 = count; count1 < index-1 ; count1++)
				{
					data[count1] = data[count1+1];
				}
	
				index -- ;
			}
		}

	}
		
	// reverse array list
	public void reverseArrayList()
	{
		for( int count1 = 0, count2 = index-1; count1<=count2; count1++, count2-- )
		{
			Object temp = data[count1];
			data[count1] = data[count2] ;
			data[count2] = temp;
		}

	}
		
	 //Sorts the elements of array list
	public void sortArrayList()
	{
		for(int count1 = 0; count1 < index ; count1++)
		{
			for(int count2 = 0; count2 < index ; count2++)
			{
				if ( ((int)data[count1]) < ((int)data[count2]) )
				{
					Object temp = data[count1];
					data[count1] = data[count2];
					data[count2] = temp;
				}
			}
		}

	}
			
	// Clear the array list
	public void clearArrayList()
	{
		for(int count = 0; count < size ; count++)			
		{
			data[count] = null;
		}		
		size = 0;
		index = 0;
	}
		
	public Object getItemFromList(int location) 
	{
		if(location > size-1)
		{
			System.out.println("Location out of bound");
		}
		
		if(location<0)
		{
			System.out.println("Negative index");
		}
			
		return data[location];
	}
		
	public void printArrayList()
	{
		System.out.print("\n Array list : ");
		for(int count1 = 0; count1 < index ; count1++)
		{
			System.out.print(data[count1]+" ");
		}
	}
	
	public static void main(String[] args)
	{
		ArrayListUsingArray objArrayListUsingArray = new ArrayListUsingArray();
		int location;
		Object item;
		try
		{
			while(true)
			{
				MenuNew menus = new MenuNew();
				menus.showMenu();
				int choice = Utility.getValue("Enter your choice : ");
				switch(choice)
				{
					case 1: item = Utility.getValue("\nEnter item to add in list : ");
							objArrayListUsingArray.addValueInList(item);
							break;
							
					case 2: item = Utility.getValue("\nEnter item to add in list : ");
							location = Utility.getValue("\nEnter location of item to be inserted in list : ");
							objArrayListUsingArray.addValueAtGivenLocation(item,location-1);
							break;
							
					case 3: item = Utility.getValue("\nEnter the item to find : ");
							location = Utility.getValue("\nEnter current location of the item in list : ");
							System.out.println("First occurrence of item based on its given location = "
									+objArrayListUsingArray.firstOccurenceAfterGivenLocation(location, item));
							break;
							
					case 4:item = Utility.getValue("\nEnter the item whose 1st index to be found : ");
							System.out.println("\nFirst index of "+item+" = "+objArrayListUsingArray.findFirstIndexOfItem (item));
							break;
							
					case 5: location = Utility.getValue("\nEnter location of item to be deleted : ");
							objArrayListUsingArray.removeItemFromGivenLocation(location-1);
							break;
							
					case 6: item = Utility.getValue("\nEnter item to be deleted : ");
							objArrayListUsingArray.removeItemFromList(item);
							break;
					
					case 7: objArrayListUsingArray.reverseArrayList();
							break;
					
					case 8: objArrayListUsingArray.sortArrayList();
							break;
							
					case 9: objArrayListUsingArray.clearArrayList();
							break;
						    
					case 10 : objArrayListUsingArray.printArrayList();
								break;
					case 11: System.exit(0);
							 break;
							
					default : System.out.println("Please enter correct choice");
							  break;
				}
				objArrayListUsingArray.printArrayList();
		
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
