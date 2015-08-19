import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class travel {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		List<trainDetails> trainInformation=new ArrayList<trainDetails>();
		
		trainInformation=trainDetails.readTrainInfo();
		String userName,typeOfTrain;
		List<trainDetails> output = new ArrayList<trainDetails>();
		bookingInformation object=new bookingInformation();
		object.sorting(trainInformation);
		String result="",answer,from,to;
		
		int id,seats=0,price,paymentMethod,y=0;
		double weight=0.0,amount=0.0;
		
		try
		{
			do
			{
				System.out.println("Enter your name");
				String user=sc.next();

				do				//accepting input from user until valid input is entered
				{
					System.out.println("Enter type of train required : Goods or Passenger");
					answer=sc.next();
					output=object.typeFiltering(answer);		//invoking method to filter the list based on train type
					if((output.size())==0)
					{
						System.out.println("Enter a valid input");
					}
					
				}while((output.size())==0);
				
				object.displayAll(output);

				do				//accepting input from user until valid input is entered
				{
					result="";
					System.out.println("Enter station journey From :");
					from=sc.next();
					System.out.println("To :");
					to=sc.next();
					result=object.trainBtwStations(from, to);		//invoking method to filter the list based on source and destination
				}while(result.equals("")==true);

				do			//accepting input from user until valid input is entered
				{
					if(answer.equalsIgnoreCase("Passenger"))
					{
						System.out.println("Enter the id of train to be booked and number of seats");
						id=sc.nextInt();
						seats=sc.nextInt();
						price=object.reservation(id, seats);		//invoking method to return price of booked train
					}
					else
					{
						System.out.println("Enter the id of train to be booked and number of weight");
						id=sc.nextInt();
						weight=sc.nextDouble();
						price=object.reservation(id, weight);		//invoking method to return price of booked train
					}

				}while(price==0);

				do			//accepting input from user until valid input is entered
				{
					System.out.println("chose payment method\n\t1. credit card\n\t2. net banking");
					paymentMethod = sc.nextInt();
					if(paymentMethod!=1 && paymentMethod!=2)
					{
						System.out.println("Enter a valid input");
					}
					
				}while(paymentMethod!=1 && paymentMethod!=2);

				switch(paymentMethod)
				{
				case 1:	
					System.out.println("enter credit card details");
					int cardNum = Utility.GetInput("enter card number");
					int cvv = Utility.GetInput("enter CVV");
					Payment testObj = new Payment();

					bookingInformation bookingObject;
					if(answer.equalsIgnoreCase("Passenger"))
					{
						amount = testObj.makePayment(seats, price);
						bookingObject = new bookingInformation(user, String.valueOf(id) , String.valueOf(seats), amount);
					}
					else
					{
						amount = testObj.makePayment(weight, price);
						bookingObject = new bookingInformation(user, String.valueOf(id) , String.valueOf(weight), amount);
					}
					bookingObject.bookingDetails();				//invoking function to display ticket details
					break;

				case 2:
					System.out.println("Enter net banking details");
					System.out.println("Enter Id");
					int accNum = sc.nextInt();
					System.out.println("enter password");
					String pass = sc.next();
					Payment testObj1 = new Payment();

					bookingInformation bookingObject1;
					if(answer.equalsIgnoreCase("Passenger"))
					{
						amount = testObj1.makePayment(seats, price);
						bookingObject1 = new bookingInformation(user, String.valueOf(id) , String.valueOf(seats), amount);
					}
					else
					{
						amount = testObj1.makePayment(weight, price);
						bookingObject1 = new bookingInformation(user, String.valueOf(id) , String.valueOf(weight), amount);
					}
					bookingObject1.bookingDetails();  			//invoking function to display ticket details
					break;
				}
				System.out.println("Updated Train chart");
				object.update(trainInformation);
				object.displayAll(trainInformation);

				System.out.println("Want more booking press 0");
				y=sc.nextInt();
			}while(y==0);
			
		}
		//Catchs exception on entering invalid input
		catch(Exception e)
		{
			System.out.println("Enter a valid input hiii");
		}
	}
}
