public class MenuNew
{
	
	public void showMenu()
	{
		menu menu = new menu();
		actionableMenuItems item = new actionableMenuItems("Press 1 for Credit Card");
		actionableMenuItems item2 = new actionableMenuItems("Press 2 for NetBanking");
		actionableMenuItems item3 = new actionableMenuItems("Press 3 for Wallet");
		menu.addMenuItem(item);
		menu.addMenuItem(item2);
		menu.addMenuItem(item3);
		menu.display();
	}

}
