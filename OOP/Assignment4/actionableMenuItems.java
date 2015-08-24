import java.io.IOException;


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
		
		switch(choice)
		{
		case 1 : Payment.paymentUsingCraditCard();
		         break;
		         
		case 2 : Payment.paymentUsingNetBanking();
				 break;
			
		case 3 : Payment.paymentUsingWallet();
				 break;
		}	
	}
		
}

