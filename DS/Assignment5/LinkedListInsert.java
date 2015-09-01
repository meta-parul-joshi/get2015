import java.util.List;

public class LinkedListInsert
{	
	public void insert(int index, int element, List<Integer> list) 
	{
		if(index == list.size())
		{
			list.add(element);
		}
		else if((int)list.get(index) < element)
		{
			insert(index+1, element, list);
		}
		else
		{
			list.add(index, element);
		}
	}
	
	public void printLinkedlist(List<Integer> list)
	{
		for(Integer linklist : list)
		{
			System.out.print(linklist + " ");
		}
	}
}
