public class MenuNew
{
	
	public void showMenu()
	{
		menu menu = new menu();
		actionableMenuItems item1 = new actionableMenuItems("\nMenu");
		actionableMenuItems item2 = new actionableMenuItems("1). Add an Item");
		actionableMenuItems item3 = new actionableMenuItems("2). Add an item at particular location");
		actionableMenuItems item4 = new actionableMenuItems("3). Retrieving the first occurrence of an item based on its given location");
		actionableMenuItems item5 = new actionableMenuItems("4). Retrieving the first index of particular item");
		actionableMenuItems item6= new actionableMenuItems("5). Removing an item based on particular location");
		actionableMenuItems item7 = new actionableMenuItems("6). Remove given particular item from the arraylist");
		actionableMenuItems item8 = new actionableMenuItems("7). Reverse the arraylist");
		actionableMenuItems item9 = new actionableMenuItems("8). Sort the elements of arraylist");
		actionableMenuItems item10 = new actionableMenuItems("9). Clear the list");
		actionableMenuItems item11 = new actionableMenuItems("10). Traverse list");
		actionableMenuItems item12 = new actionableMenuItems("11). Exit");
		menu.addMenuItem(item1);
		menu.addMenuItem(item2);
		menu.addMenuItem(item3);
		menu.addMenuItem(item4);
		menu.addMenuItem(item5);
		menu.addMenuItem(item6);
		menu.addMenuItem(item7);
		menu.addMenuItem(item8);
		menu.addMenuItem(item9);
		menu.addMenuItem(item10);
		menu.addMenuItem(item11);
		menu.addMenuItem(item12);
		menu.display();
	}

}
