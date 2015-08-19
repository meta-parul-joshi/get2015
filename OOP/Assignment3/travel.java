import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class travel {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//public enum trainType{Goods,Passenger};
		List<trainDetails> trainInformation=new ArrayList<trainDetails>();
		BufferedReader objBufferedReader;
		try
		{
			//Reading the questions stored in the txt file
			objBufferedReader=new BufferedReader(new FileReader("C://Users/Parul/workspace/Assignment7/src/trainInfo.txt"));
			String line;
			String[] trainInfo;
			while ((line = objBufferedReader.readLine()) != null)
			{
				trainInfo = line.split(",");									// Reading up details line by line
				trainInformation=trainDetails.readTrainInfo(trainInfo);
			}
		}
		
		//Catches an exception if file not found
		catch(FileNotFoundException e)
		{
			System.out.println(e);

		}
		catch(IOException e)
		{
			System.out.println(e);
		}	
		
		Scanner sc = new Scanner(System.in);
		String userName,typeOfTrain,from,to;
		List<trainDetails> output = new ArrayList<trainDetails>();
		reservationSystem objReservationSystem=new reservationSystem();
		objReservationSystem.sortingTrainChart(trainInformation);
		int id,seats=0,fare,paymentMethod,y=0;
		double weight=0.0,amount=0.0;
		
		
		try
		{
			do
			{
				System.out.println("Enter your name");
				userName=sc.next();
				boolean flag;
				do				//accepting input from user until valid input is entered
				{
					System.out.println("Enter type of train required : Goods or Passenger");
					typeOfTrain=sc.next();
					if((typeOfTrain.equalsIgnoreCase("Goods")==false) && (typeOfTrain.equalsIgnoreCase("Passenger")==false) )
					{
						flag = false;
						System.out.println("Enter a valid input");
					}
					else
					{      
						flag = true;//invoking method to filter the list based on train type
						output=objReservationSystem.getTrainsOfType(typeOfTrain);
					}
					
				}while(flag==false);
				
				int countTrainsBetweenStation=0;
				do				//accepting input from user until valid input is entered
				{
					
					System.out.println("Enter station journey From :");
					from=sc.next();
					System.out.println("To :");
					to=sc.next();
					countTrainsBetweenStation=objReservationSystem.getTrainsBetweenStations(from, to);		//invoking method to filter the list based on source and destination
					if(countTrainsBetweenStation==0)
					{
						System.out.println("No trains found between "+from+" and "+to);
						System.out.println("Enter trains available in chart");
					}
					
				}while(countTrainsBetweenStation==0);

				do			//accepting input from user until valid input is entered
				{
					if(typeOfTrain.equalsIgnoreCase("Passenger"))
					{
						System.out.println("Enter the id of train to be booked "); //and number of seats");
						id=sc.nextInt();
						System.out.println("Enter number of to be booked ");
						seats=sc.nextInt();
						fare=objReservationSystem.reservation(id, seats);		//invoking method to return price of booked train
					}
					else
					{
						System.out.println("Enter the id of train to be booked ");
						id=sc.nextInt();
						System.out.println("Enter weight of to be booked ");
						weight=sc.nextDouble();
						fare=objReservationSystem.reservation(id, weight);		//invoking method to return price of booked train
					}
					if(fare==0)
					{
						System.out.println("Enter valid id");
					}

				}while(fare==0);

				do			//accepting input from user until valid input is entered
				{
					System.out.println("chose payment method\n\t1. credit card\n\t2. net banking\n\t3.Wallet");
					paymentMethod = sc.nextInt();
					if(paymentMethod!=1 && paymentMethod!=2 && paymentMethod!=3)
					{
						System.out.println("Enter a valid input");
					}
					else
					{
						flag=true;
					}
					
				}while(flag == false);

				switch(paymentMethod)
				{
				case 1:	
					System.out.println("enter credit card details");
					System.out.println("enter card number");
					String cardNum = sc.next();
					System.out.println("enter cvv number");
					String cvv = sc.next();
					Payment objPaymentByCraditCard = new Payment();

					if(typeOfTrain.equalsIgnoreCase("Passenger"))
					{
						amount = objPaymentByCraditCard.makePayment(seats, fare);
						objReservationSystem.getbookingDetails(userName, String.valueOf(id) , String.valueOf(seats), amount);
					}
					else
					{
						amount = objPaymentByCraditCard.makePayment(weight, fare);
						objReservationSystem.getbookingDetails(userName, String.valueOf(id) , String.valueOf(weight), amount);
					}
								//invoking function to display ticket details
					break;

				case 2:
					System.out.println("Enter net banking details");
					System.out.println("Enter Id");
					int accNum = sc.nextInt();
					System.out.println("enter password");
					String pass = sc.next();
					Payment objPaymentByNetBanking = new Payment();

					if(typeOfTrain.equalsIgnoreCase("Passenger"))
					{
						amount = objPaymentByNetBanking.makePayment(seats, fare);
						objReservationSystem.getbookingDetails(userName, String.valueOf(id) , String.valueOf(seats), amount);
					}
					else
					{
						amount = objPaymentByNetBanking.makePayment(weight, fare);
						objReservationSystem.getbookingDetails(userName, String.valueOf(id) , String.valueOf(weight), amount);
					}
					break;
					
				case 3 : System.out.println("Cash payment");
						 Payment objPaymentByWallet = new Payment();

					if(typeOfTrain.equalsIgnoreCase("Passenger"))
					{
						amount = objPaymentByWallet.makePayment(seats, fare);
						objReservationSystem.getbookingDetails(userName, String.valueOf(id) , String.valueOf(seats), amount);
					}
					else
					{
						amount = objPaymentByWallet.makePayment(weight, fare);
						objReservationSystem.getbookingDetails(userName, String.valueOf(id) , String.valueOf(weight), amount);
					}
				}
				
				System.out.println("Updated Train chart");
				objReservationSystem.updateTrainChart(trainInformation);
				objReservationSystem.displayTrainChart(trainInformation);

				System.out.println("Want more booking press 0");
				y=sc.nextInt();
			}while(y==0);
			
		}
		
		//Catchs exception on entering invalid input
		catch(Exception e)
		{
			System.out.println("Enter a valid input !!!!");
		}
		sc.close();
	}
}
