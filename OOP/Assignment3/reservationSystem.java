
import java.util.ArrayList;
import java.util.List;
import java.io.*;
/**class for processing train information and displaying details of trains available
 * 
 * @author Parul
 *
 */
public class reservationSystem 
{
	//count is used to check whether trains are found between user specified stations or not
	List<trainDetails> selectedList=new ArrayList<trainDetails>();
	String name, trainId, seatsBooked;
	double amount;
	
	//method to filter trains based on train type
	public List<trainDetails> getTrainsOfType(String type)		//answer stores train type
	{
		selectedList.clear();
		for(trainDetails s:trainDetails.trainInformation)
		{
			if((s.type).equalsIgnoreCase(type))		//adding trains to list if type matches user's desired train type
			{
				selectedList.add(s);
			}
		}
		displayTrainChart(selectedList);
		return selectedList;		//returning the filtered list based on type
	}

	//method to filter the list based on source and destination stations
	public int getTrainsBetweenStations(String from, String to)
	{
		int count=0;
		for(trainDetails s:selectedList)
		{
			if((s.source).equalsIgnoreCase(from) && (s.destination).equalsIgnoreCase(to))
			{
				count++;
				System.out.println("TrainID\t Type\t Source \tDestination \t Seats Available Journey Time \t Cost");
				System.out.println(s.id+"\t "+s.type+"\t "+s.source+"\t "+s.destination+"\t\t\t"+s.availableSeats+"\t\t"+s.travelTime+"\t\t"+s.fare);
			}
		}
		return count;
	}

	//method to book trains availability is sufficient
	public int reservation(int trainId, double seats)
	{
		for(trainDetails s:selectedList)
		{
			if(Integer.parseInt(s.id)==(trainId))
			{
				if(Integer.parseInt(s.availableSeats)>=seats)
				{
				double avaibleSeats=Double.parseDouble(s.availableSeats);
				avaibleSeats=avaibleSeats-seats;
				s.availableSeats=String.valueOf(avaibleSeats);
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

	//method to update train chart after successful booking
	public void updateTrainChart(List<trainDetails> info)
	{
		for(trainDetails s:info)
		{
			for(trainDetails s1:trainDetails.trainInformation)
			{
				if((s.id).equals(s1.id))
				{
					s1.availableSeats=s.availableSeats;
				}
			}
		}
	}

	//method to show train details
	public void displayTrainChart(List<trainDetails> selectedList)
	{
		System.out.println("TrainID\t\tType\t\t Source\t\t Destination\t\tSeats Available\t\tJourney Time\t\t Cost");
		for(trainDetails s:selectedList)
		{
			System.out.println(s.id+"\t\t"+s.type+"\t\t "+s.source+"\t\t"+s.destination+"\t\t\t"+s.availableSeats+"\t\t\t"+s.travelTime+"\t\t"+s.fare);

		}

	}

	//method to print ticket details
	public void getbookingDetails(String name, String trainId, String seatsBooked, double amount)
	{
		this.name = name;
		this.trainId = trainId;
		this.seatsBooked = seatsBooked;
		this.amount = amount;
		int transactionId=76587465;
		System.out.println("\nyour booking is successfull\nbooking deatils are : ");
		System.out.println("transactionId : "+transactionId++);
		System.out.println("\tname : " + name + "\n\ttrain Id : " + trainId + "\n\tseats booked : " +seatsBooked + "\n\tamount : " + amount);

	}


	public void sortingTrainChart(List<trainDetails> info)
	{
		trainDetails temp;
		for(int index=0;index<info.size();index++)
		{
			for(int i=0;i<info.size();i++)
			{ 
				int travelTime1=Integer.parseInt(info.get(index).travelTime);
				int travelTime2=Integer.parseInt(info.get(i).travelTime);
				if(travelTime1<travelTime2)
				{
					temp=info.get(index);
					info.set(index,info.get(i));
					info.set(i,temp);
				}
			}
		}
	}
}