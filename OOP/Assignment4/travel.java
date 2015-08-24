import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class travel
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{		
		List<trainDetails> trainDetailsInformation = new ArrayList<trainDetails>();
		List<trainDetails> passengerTrainInformation = new ArrayList<trainDetails>();
		List<trainDetails> goodsTrainInformation = new ArrayList<trainDetails>();
		List<trainDetails> availabletrains = new ArrayList<trainDetails>();
		BufferedReader objBufferedReader;
		try
		{
			objBufferedReader = new BufferedReader(new FileReader("C://Users/Parul/workspace/Assignment7/src/trainInfo.txt"));
			String line;
			String[] trainInfo;
			while ((line = objBufferedReader.readLine()) != null)
			{
				trainInfo = line.split(",");
				if(trainInfo[1].equals("Passenger"))
				{
					trainDetailsInformation=passengerTrainDetails.readPassengerTrainInfo(trainInfo);
				}
				else
				{
					trainDetailsInformation=goodsTrainDetails.readGoodsTrainInfo(trainInfo);
				}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}	
	
		Scanner sc = new Scanner(System.in);
		String userName, typeOfTrain, journeyFrom, journeyTo;
		reservationSystem objReservationSystem = new reservationSystem();					
		objReservationSystem.sortingTrainChart(trainDetailsInformation);
		int id, seats = 0, fare, y = 0;
		double weight = 0.0,amount = 0.0;
		try
		{
			do
			{
				userName = Utility.getInput("Enter your name");
				boolean flag;
				do				
				{
					typeOfTrain = Utility.getTypeOfTrain("Enter type of train required : Goods or Passenger");	
					if(TrainType.valueOf(typeOfTrain).equals(TrainType.Goods))
					{      
						flag = true;
						goodsTrainInformation = objReservationSystem.getTrains(trainDetailsInformation,TrainType.Goods);
					}
					else if(TrainType.valueOf(typeOfTrain).equals(TrainType.Passenger))
					{
						flag = true;
						passengerTrainInformation = objReservationSystem.getTrains(trainDetailsInformation,TrainType.Passenger);
					}
					else
					{
						flag = false;
						System.out.println("Enter a valid input");
					}
				
				}while(flag == false);
				
				do				//accepting input from user until valid input is entered
				{
					journeyFrom = Utility.getInput("Enter station journey From :");
					journeyTo = Utility.getInput("To :");
					if(TrainType.valueOf(typeOfTrain).equals(TrainType.Goods))
					{
						availabletrains=objReservationSystem.getTrainsBetweenStations(journeyFrom, journeyTo, goodsTrainInformation, TrainType.Goods);
					}
					else
					{
						availabletrains=objReservationSystem.getTrainsBetweenStations(journeyFrom, journeyTo, passengerTrainInformation, TrainType.Passenger);
					}
					
					if(availabletrains.size() == 0)
					{
						System.out.println("No trains found between "+journeyFrom+" and "+journeyTo);
						System.out.println("Enter trains available in chart");
					}
					
				}while(availabletrains.size() == 0);

				do			//accepting input from user until valid input is entered
				{
					id = Utility.getValue("Enter the id of train to be booked ");
					if(TrainType.valueOf(typeOfTrain).equals(TrainType.Passenger))
					{
						seats = Utility.getValue("Enter number of to be booked ");
						fare=objReservationSystem.reservationInPassengerTrain(id, seats);		//invoking method to return price of booked train
					}
					else
					{
						System.out.println("Enter weight of to be booked ");
						weight = sc.nextDouble();
						fare=objReservationSystem.reservationInGoodsTrain(id, weight);		//invoking method to return price of booked train
					}
					
					if(fare == 0)
					{
						System.out.println("Enter valid id");
					}

				}while(fare == 0);

				MenuNew objectMenu = new MenuNew();
				objectMenu.showMenu();
				Payment objPaymentByNetBanking = new Payment();
				if(typeOfTrain.equalsIgnoreCase("Passenger"))
				{
					amount = objPaymentByNetBanking.makePayment(seats, fare);
					objReservationSystem.getbookingDetails(userName, String.valueOf(id) , String.valueOf(seats), amount,TrainType.Passenger);
				}
				else
				{
					amount = objPaymentByNetBanking.makePayment(weight, fare);
					objReservationSystem.getbookingDetails(userName, String.valueOf(id) , String.valueOf(weight), amount,TrainType.Goods);
				}
				
				System.out.println("Want more booking press 0");
				y = sc.nextInt();
				
			}while(y == 0);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: " + e.getMessage());
		}
		
		sc.close();
	}
}
