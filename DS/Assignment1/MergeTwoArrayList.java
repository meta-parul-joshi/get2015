import java.util.Scanner;


public class MergeTwoArrayList
{
	static int sizeIncreasedByValue = 5;
	Object data[];
	int index;
	int size;
	
	public MergeTwoArrayList()
	{
		data = new Object[sizeIncreasedByValue];
		size = sizeIncreasedByValue;
	}
	
	public void addValueInList(Object item)
	{
		//overflow, increase the size of data[]
		if( index == size-1 )
		{
			increaseSizeAndReallocate();
		}
		
		data[index] = item;
		index++;	
		printArrayList();
	}
	
	void increaseSizeAndReallocate()
	{
		size = size + sizeIncreasedByValue;
		Object newData[] = new Object[size];
		for(int count=0; count<data.length; count++)
		{
			newData[count] = data[count];
		}
		
		data = newData;
	}
	
	public void printArrayList()
	{
		System.out.print("\n Array list : ");
		for(int count1 = 0; count1 < index ; count1++)
		{
			System.out.print(data[count1]+ " ");
		}
	}
	
	public static void main(String[] args)
	{
		MergeTwoArrayList objFirstArrayList = new MergeTwoArrayList();
		MergeTwoArrayList objSecondArrayList = new MergeTwoArrayList();
		Object item;
		Scanner sc = new Scanner(System.in);
		try
		{
			while(true)
			{
				System.out.println("\nMenu");
				System.out.println("1). Add item in list 1");
				System.out.println("2).Add item in list 2");
				System.out.println("3). Merge above two list");
				System.out.println("Enter your choice : ");
				int choice = sc.nextInt();
				switch(choice)
				{
					case 1: item = Utility.getValue("\nEnter item to add in list : ");
							objFirstArrayList.addValueInList(item);
							break;
							
					case 2: item = Utility.getValue("\nEnter item to add in list : ");
							objSecondArrayList.addValueInList(item);
							break;
							
					case 3 :for(int count =0; count < objSecondArrayList.index; count++)
							{
								objFirstArrayList.addValueInList(objSecondArrayList.data[count]);
							}
					
							objFirstArrayList.printArrayList();
							break;
							
					default : System.out.println("Wrong choice..!!");
							  break;
				}
			}
		}
		catch(Exception e)
		{
			sc.close();
		}
	}

}
