/**class for calculating the total amount for a booking
 * 
 * @author Parul
 *
 */
public class Payment
{
	double amount = 0;
	double makePayment(double toBook, int price)
	{		//toBook holds the number of seats/weight to be booked by the user
		amount = toBook * (price);
		return amount;
	}
	
	public static void paymentUsingCraditCard()
	{
		System.out.println("enter credit card details :");
		String cardNum = Utility.getInput("enter card number :");
		String cvv = Utility.getInput("enter cvv number :");
	}
	
	public static void paymentUsingNetBanking()
	{
		System.out.println("Enter net banking details");
		String bankName = Utility.getInput("Enter Bank Name :");
		int accNum = Utility.getValue("Enter user name :");
		String pass = Utility.getInput("enter password :");
	}
	
	public static void paymentUsingWallet()
	{
		System.out.println("Cash payment");
	}
}
