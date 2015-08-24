
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**class for processing train information and displaying details of trains available
 * 
 * @author Parul
 */

public class reservationSystem 
{
	List<trainDetails> selectedList = new ArrayList<trainDetails>();
	String name, trainId, seatsBooked;
	double amount;
	
	public List<trainDetails> getTrains(List<trainDetails> trainDetailsInformation,TrainType typeOfTrain)
	{	
		selectedList.clear();
		System.out.println(typeOfTrain);
		for(trainDetails t : trainDetailsInformation)
		{
			if(TrainType.valueOf(t.type).equals(typeOfTrain))
			{
				selectedList.add(t);
			}		
		}
		
		displayTrainChart(selectedList,typeOfTrain);
		return selectedList;
	}
	
	//method to filter the list based on source and destination stations
	public List<trainDetails> getTrainsBetweenStations(String from, String to,List<trainDetails> trainInformation, TrainType type)
	{
		List<trainDetails> selectedList = new ArrayList<trainDetails>();
		for(trainDetails s:trainInformation)
		{
			if((s.source).equalsIgnoreCase(from) && (s.destination).equalsIgnoreCase(to))
			{
				selectedList.add(s);
			}
		}
		
		displayTrainChart(selectedList,type);	
		return selectedList;
	}
	
	//method to book trains availability is sufficient
	public int reservationInPassengerTrain(int trainId, double seats)
	{
		for(trainDetails s:selectedList)
		{
			if(Integer.parseInt(s.id) == (trainId))
			{
				passengerTrainDetails objPassengerTrain = (passengerTrainDetails)s;
				if(Integer.parseInt(objPassengerTrain.availableSeats)>=seats)
				{
					double avaibleSeats = Double.parseDouble(objPassengerTrain.availableSeats);
					avaibleSeats = avaibleSeats-seats;
					objPassengerTrain.availableSeats = String.valueOf(avaibleSeats);
					return (Integer.parseInt(s.fare));
				}
				else 
				{
					System.out.println("available seats are less than required");
				}
			}
		}
		
		return 0;
	}
	
	public int reservationInGoodsTrain(int trainId, double weight)
	{
		for(trainDetails s:selectedList)
		{
			goodsTrainDetails objGoodsTrain = (goodsTrainDetails)s;
			if(Integer.parseInt(s.id)==(trainId))
			{
				if(Integer.parseInt(objGoodsTrain.availableWeight)>=weight)
				{
					double avaibleWeight = Double.parseDouble(objGoodsTrain.availableWeight);
					avaibleWeight = avaibleWeight-weight;
					objGoodsTrain.availableWeight=String.valueOf(avaibleWeight);
					return (Integer.parseInt(s.fare));
				}
				else 
				{
					System.out.println("available weight are less than required");
				}
			}
		}
		
		return 0;
	}

	//method to show train details
	public void displayTrainChart(List<trainDetails> trainDetailsInformation, TrainType type)
	{
		if((type).equals(TrainType.Passenger))
		{
			System.out.println("\n\t\t\t\t\tPassenger Trains Chart\n ");
			System.out.println("TrainID\t\tType\t\t\t Source\t\t Destination\t\tAvailableSeats\t\tJourney Time\t\t Cost");
			for(trainDetails s : trainDetailsInformation)
			{
				passengerTrainDetails objPassengerTrain = (passengerTrainDetails)s;
				System.out.println(s.id+"\t\t"+s.type+"\t\t "+s.source+"\t\t"+s.destination+"\t\t\t"+objPassengerTrain.availableSeats+"\t\t\t"+s.travelTime+"\t\t"+s.fare);
			}
		}
		else if((type).equals(TrainType.Goods))
		{
			System.out.println("\n\t\t\t\t\t Goods Trains Chart\n ");
			System.out.println("TrainID\t\tType\t\t Source\t\t Destination\t\tAvailableWeight\t\tJourney Time\t\t Cost");
			for(trainDetails s : trainDetailsInformation)
			{
				goodsTrainDetails objGoodsTrain = (goodsTrainDetails)s;
				System.out.println(s.id+"\t\t"+s.type+"\t\t "+s.source+"\t\t"+s.destination+"\t\t\t"+objGoodsTrain.availableWeight+"\t\t\t"+s.travelTime+"\t\t"+s.fare);
			}
		}
	}
	
	//method to print ticket details
	public void getbookingDetails(String name, String trainId, String Booked, double amount,TrainType type)
	{
		this.name = name;
		this.trainId = trainId;
		this.seatsBooked = seatsBooked;
		this.amount = amount;
		int transactionId = 76587465;
		System.out.println("\nyour booking is successfull\nbooking deatils are : ");
		System.out.println("transactionId : "+transactionId++);
		if(type.equals(TrainType.Passenger))
		{
			System.out.println("\tname : " + name + "\n\ttrain Id : " + trainId + "\n\tseats booked : " +Booked + "\n\tamount : " + amount);
		
		}
		else
		{
			System.out.println("\tname : " + name + "\n\ttrain Id : " + trainId + "\n\tWeight booked : " +Booked + "\n\tamount : " + amount);
		}
		displayTrainChart(selectedList, type);
		
	}

	public void sortingTrainChart(List<trainDetails> info)
	{
		trainDetails temp;
		for(int index = 0; index < info.size(); index++)
		{
			for(int i = 0; i < info.size(); i++)
			{ 
				int travelTime1 = Integer.parseInt(info.get(index).travelTime);
				int travelTime2 = Integer.parseInt(info.get(i).travelTime);
				if(travelTime1 < travelTime2)
				{
					temp=info.get(index);
					info.set(index,info.get(i));
					info.set(i,temp);
				}
			}
		}
	}	
}