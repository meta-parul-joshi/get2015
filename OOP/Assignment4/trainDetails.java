import java.util.List;
import java.util.ArrayList;

public class trainDetails 
{
	String id;
	String source;
	String destination;
	String travelTime;
	String fare;
	String type;
	public static List<trainDetails> trainDetailsInformation = new ArrayList<trainDetails>();
	
	//Constructor.
	public trainDetails(String id, String type, String source,String destination,String traveltime,String fare)
	{
		this.id = id;
		this.type = type;
		this.source = source;
		this.destination = destination;
		this.travelTime = traveltime;
		this.fare = fare;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setSource(String source)
	{
		this.source = source;
	}
	
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
	
	public void setTravelTime(String travelTime)
	{
		this.travelTime = travelTime;
	}
	
	public void setFare(String fare)
	{
		this.fare = fare;
	}
	
    public String getID()
    {
    	return id;
    }
    
    public String getSource()
    {
    	return source;
    }
    
    public String getDestination()
    {
    	return destination;
    }
    
    public String getTravelTime()
    {
    	return travelTime;
    }
    
    public String getFare()
    {
    	return fare;
    }
}

class passengerTrainDetails extends trainDetails
{
	
	String availableSeats;
	
	//Constructor.
	public passengerTrainDetails(String id,String type,String source,String destination,String availableSeats,String traveltime,String fare)
	{
		super(id,type,source,destination,traveltime,fare);
		this.availableSeats = availableSeats;
	}
	
	public static List<trainDetails> readPassengerTrainInfo(String[] trainInfo)
	{		
		trainDetailsInformation.add(new passengerTrainDetails(trainInfo[0],trainInfo[1], trainInfo[2], trainInfo[3], trainInfo[4], trainInfo[5], trainInfo[6]));
		return trainDetailsInformation;	
	}
	
		
	public void setType(String type)
	{
		this.type = type;
	}
	
	public void setAvailableSeate(String availableSeats)
	{
		this.availableSeats = availableSeats;
	}
	
	public String getType()
    {
    	return type;
    }
	
	public String getAvailableSeats()
    {
    	return availableSeats;
    }
}

class goodsTrainDetails extends trainDetails
{
	String availableWeight;
	
	//Constructor.
	public goodsTrainDetails(String id,String type,String source,String destination,String availableWeight,String traveltime,String fare)
	{
		super(id,type,source,destination,traveltime,fare);
		this.availableWeight = availableWeight;
	}
	
	public static List<trainDetails> readGoodsTrainInfo(String[] trainInfo)
	{
		
		trainDetailsInformation.add(new goodsTrainDetails(trainInfo[0],trainInfo[1], trainInfo[2], trainInfo[3], trainInfo[4], trainInfo[5], trainInfo[6]));
		return trainDetailsInformation;	
	}
	
	public void setAvailableWeight(String availableWeight)
	{
		this.availableWeight = availableWeight;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getType()
    {
    	return type;
    }
	
	public String getAvailableWeight()
    {
    	return availableWeight;
    }
}