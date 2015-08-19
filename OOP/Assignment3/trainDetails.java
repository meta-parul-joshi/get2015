import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class trainDetails 
{
	String id;
	String type;
	String source;
	String destination;
	String availableSeats;
	String travelTime;
	String fare;
	static List<trainDetails> trainInformation = new ArrayList<trainDetails>();
	//Constructor.
	public trainDetails(String id,String type,String source,String destination,String availableSeats,String traveltime,String fare)
	{
		this.id = id;
		this.type = type;
		this.source = source;
		this.destination = destination;
		this.availableSeats= availableSeats;
		this.travelTime = traveltime;
		this.fare = fare;
	}
	
	public static List<trainDetails> readTrainInfo(String[] trainInfo)
	{
		
		trainInformation.add(new trainDetails(trainInfo[0], trainInfo[1], trainInfo[2], trainInfo[3], trainInfo[4], trainInfo[5], trainInfo[6]));
		return trainInformation;
	}
}