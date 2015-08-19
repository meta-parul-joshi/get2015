import java.util.Scanner;


public class Utility {
	
	public static int GetInput(String message)
	{
		int number=0;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println(message);
			String inputStr = sc.nextLine();
			if(isNumeric(inputStr) && Integer.parseInt(inputStr) > 0)
			{
				number=Integer.parseInt(inputStr);
				break;
			}
			
		}while(true);
		
		return number;
	}
	

	private static boolean isNumeric(String input) 
	{
		try 
		{
			Integer.parseInt(input);
		} 
		catch (NumberFormatException e) 
		{
			return false;
		}
		
		return true;
	}

	private String hi()
	{
		return "HI";
	
	}
}
