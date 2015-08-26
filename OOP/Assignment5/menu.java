
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  menu
{	
	List<menuItem> items = new ArrayList<>();
	private Scanner scan  = new Scanner(System.in);
	
	public void addMenuItem(menuItem item)
	{
		items.add(item);
	}
	
	public void display()
	{
			for (menuItem i : items) 
			{
				i.display();
		}			
	}
}
