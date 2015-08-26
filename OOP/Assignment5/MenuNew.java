public class MenuNew
{
	
	public void showMenu()
	{
		menu menu = new menu();
		actionableMenuItems item1 = new actionableMenuItems("\nMenu : ");
		actionableMenuItems item2 = new actionableMenuItems("1). Sign Up");
		actionableMenuItems item3 = new actionableMenuItems("2). Log In");
		actionableMenuItems item4 = new actionableMenuItems("3). Exit");
		menu.addMenuItem(item1);
		menu.addMenuItem(item2);
		menu.addMenuItem(item3);
		menu.addMenuItem(item4);
		menu.display();
	}
	
	public void showSubMenu()
	{
		menu menu = new menu();
		actionableMenuItems item1 = new actionableMenuItems("\nSign Up : ");
		actionableMenuItems item2 = new actionableMenuItems("1). Person");
		actionableMenuItems item3 = new actionableMenuItems("2). Organisation");

		menu.addMenuItem(item1);
		menu.addMenuItem(item2);
		menu.addMenuItem(item3);
		
		menu.display();
	}

}
