import java.util.ArrayList;
import java.util.List;




public class actionableMenuItems implements menuItem
{ 
	String displayText; 
	
	actionableMenuItems(String displayText)
	{
		this.displayText = displayText;
	}
	
	
	public void display() 
	{
		System.out.println(displayText);
	}
	
	public void takeAction(int choice) 
	{
		
		//socialNetworkObj.addFriend ( personObj, friend, nodeList, entityFriendship );
	}
		
	
}


