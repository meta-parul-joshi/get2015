import ProjectCompany.Utility.Utility;
/**
 * Main class
 * @author Parul
 * Date Created : 22/10/2015
 */
public class Main 
{

	/** Main Function */
	public static void main(String args[]) 
	{
		System.out.println("Cricket Game");
		boolean flag;
		/* choice will hold user's choice */
		int choice;
		while(true)
		{
			flag = false;
			System.out.println("\n1. One Day");
			System.out.println("2. Test");
			System.out.println("3. 20-20");
			System.out.println("4. Exit");
			choice= Utility.getChoice("\nEnter Choice");

			/* creating reference of Game class */
			Game gameObj = null;
			switch(choice) 
			{
				/* If choice is 1, then create object of OneDay */ 	
				case 1:
				{
					gameObj = new OneDay();
					break;
				}
				
				/* If choice is 2, then create object of OneDay */
				case 2:
				{
					gameObj = new Test();
					break;
				}
				
				/* If choice is 3, then create object of OneDay */
				case 3:
				{
					gameObj = new TwentyTwenty();
					break;
				}
				
				/* If choice is 4, then Exit from the System */
				case 4:
				{ 
					System.out.println("System Exited");
					System.exit(0);
					break;
				}
				
				default :
				{ 
					System.out.println("Enter Correct Choice");
					flag = true;
				}
			}
			if(flag) 
				continue;
			/* Invocation of play method */
			gameObj.play();
		}
	}
}
