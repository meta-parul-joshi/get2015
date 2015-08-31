import java.util.Scanner;
public class Utility 
{
	public static int getIntegerValue(String message)
	{		
		Scanner sc=new Scanner(System.in);
		do
		{
			int number;
			System.out.println(message);
			
//			System.out.println(sc.next());
			String inputStr = sc.next();
			//System.out.println(inputStr);
			
			if(isNumeric(inputStr) && (Integer.parseInt(inputStr)>0))
			{
				number=Integer.parseInt(inputStr);
				return number;
			}
			
		}while(true);
	}
	
	public static boolean isNumeric(String input) 
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
	
	public static String getStringInput(String message)
	{
		System.out.println(message);
		Scanner sc=new Scanner(System.in);
		String inputStr = sc.next();
		//sc.close();
		return inputStr;
	}
	
}
