
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class  menu
{
	
	List<menuItem> items = new ArrayList<>();
	private Scanner scan  = new Scanner(System.in);
	
	public void addMenuItem(menuItem item)
	{
		items.add(item);
	}
	
	public void display()
	{
		boolean flag = true;
		while (flag == true) 
		{
	    
			for (menuItem i : items) 
			{
				i.display();
			}
			int choice = scan.nextInt();
			menuItem i = new actionableMenuItems("");
			i.takeAction(choice);
			flag = false;
		}
	}
}
