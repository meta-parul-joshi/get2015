import java.util.Scanner;


public class Utility 
{
	public static int getValue(String message)
	{
		
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println(message);
			int number;
			String inputStr = sc.next();
			if(isNumeric(inputStr) && (Integer.parseInt(inputStr)>0))
			{
				number=Integer.parseInt(inputStr);
				return number;
			}
			sc.close();
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
	
	public static String getInput(String message)
	{
		System.out.println(message);
		Scanner sc=new Scanner(System.in);
		String inputStr = sc.nextLine();
		sc.close();
		return inputStr;
	}
	
	public static String getTypeOfTrain(String message)
	{
		String type;
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		type = sc.next();
		if((type.toLowerCase().equals("goods")) || (type.toLowerCase().equals( "g")))
		{
			type = "Goods";
		}
		else if((type.toLowerCase().equals("passenger")) || (type.toLowerCase().equals("p")))
		{
			type = "Passenger";
		}
		else
		{
			type = "";
		}
		sc.close();
		return type;
	}
}
