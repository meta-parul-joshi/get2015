
import java.util.ArrayList;
import java.util.List;
import java.io.*;
/**class for processing train information and displaying details of trains available
 * 
 * @author Parul
 *
 */
public class bookingInformation {
	int count;				//count is used to check whether trains are found between user specified stations or not
	List<trainDetails> selectedList=new ArrayList<trainDetails>();
	
	String name, trainId, seatsBooked;
	double amount;
	
	public bookingInformation()
	{

	}

	public bookingInformation(String name, String trainId, String seatsBooked, double amount){		//constructor to initialize booking class objects
		this.name = name;
		this.trainId = trainId;
		this.seatsBooked = seatsBooked;
		this.amount = amount;
	}

	//method to filter trains based on train type
	public List<trainDetails> typeFiltering(String answer)		//answer stores train type
	{
		selectedList.clear();
		count=0;
		
		if((answer.equalsIgnoreCase("Goods")==false) && (answer.equalsIgnoreCase("Passenger")==false) )
			return selectedList;		//returns null if user enter invalid train type
		
		for(trainDetails s:trainDetails.trainInformation)				
			if((s.trainType).equalsIgnoreCase(answer))		//adding trains to list if type matches user's desired train type
			{
				count++;
				selectedList.add(s);
			}

		if(count==0)
		{
			System.out.println("No train found");		//count == 0 means no trains are found between entered stations
			return selectedList;
		}
		if(count>0)
		{
			return selectedList;
		}
		return selectedList;		//returning the filtered list based on type
	}

	//method to filter the list based on source and destination stations
	public String trainBtwStations(String from, String to)
	{
		count=0;
		for(trainDetails s:selectedList)
		{
			if((s.trainFromStation).equalsIgnoreCase(from) && (s.trainToStation).equalsIgnoreCase(to))
			{
				count++;
				System.out.println("TrainID\t Type\t Source Destination \t Seats Available Journey Time \t Cost");
				System.out.println(s.trainId+"\t "+s.trainType+"\t "+s.trainFromStation+"\t "+s.trainToStation+"\t "+s.availableSeats+"\t "+s.travelTime+"\t "+s.price);
			}
		}
		if(count==0)
		{
			System.out.println("No train found");
			return "";
		}
		return "true";
	}

	//method to book trains availability is sufficient
	public int reservation(int trainId, double seats)
	{
		count=0;
		for(trainDetails s:selectedList)
		{
			if(Integer.parseInt(s.trainId)==(trainId))
			{
				if(Integer.parseInt(s.availableSeats)>=seats)
				{
				double total=Double.parseDouble(s.availableSeats);
				total=total-seats;
				s.availableSeats=String.valueOf(total);
				count++;
				return (Integer.parseInt(s.price));
				}
				else 
				{
					System.out.println("available seats are less than required");
				}
			}
			else
			{
				System.out.println("Enter a valid trainId");
				return 0;
			}
		}
		
		return 0;
	}

	//method to update train chart after successful booking
	public void update(List<trainDetails> info)
	{
		for(trainDetails s:info)
		{
			for(trainDetails s1:trainDetails.trainInformation)
			{
				if((s.trainId).equals(s1.trainId))
				{
					s1.availableSeats=s.availableSeats;
				}
			}
		}
	}

	//method to show train details
	public void displayAll(List<trainDetails> selectedList)
	{
		System.out.println("TrainID \t Type \t Source Destination \t Seats Available Journey Time \t Cost");
		for(trainDetails s:selectedList)
		{
			System.out.println(s.trainId+"\t \t"+s.trainType+"\t "+s.trainFromStation+"\t "+s.trainToStation+"\t "+s.availableSeats+"\t \t  "+s.travelTime+"\t \t  "+s.price);

		}

	}

	//method to print ticket details
	public void bookingDetails()
	{
		int transactionId=76587465;
		System.out.println("\nyour booking is successfull\nbooking deatils are : ");
		System.out.println("transactionId : "+transactionId++);
		System.out.println("\tname : " + name + "\n\ttrain Id : " + trainId + "\n\tseats booked : " +seatsBooked + "\n\tamount : " + amount);

	}


public void sorting(List<trainDetails> info)
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