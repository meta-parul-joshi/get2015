
import java.util.List;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class trainDetails 
{
	String trainId;
	String trainType;
	String trainFromStation;
	String trainToStation;
	String availableSeats;
	String travelTime;
	String price;
	
	static List<trainDetails> trainInformation = new ArrayList<trainDetails>();
	
	public trainDetails(String trainId,String trainType,String trainFromStation,String trainToStation,String availableSeats,String traveltime,String price)
	{
		this.trainId = trainId;
		this.trainType = trainType;
		this.trainFromStation = trainFromStation;
		this.trainToStation = trainToStation;
		this.availableSeats= availableSeats;
		this.travelTime = traveltime;
		this.price = price;
	}
	public static List<trainDetails> readTrainInfo()
	{
		BufferedReader br;
		try
		{
			//Reading the questions stored in the txt file
			br=new BufferedReader(new FileReader("C://Users/Parul/workspace/Assignment7/src/trainInfo.txt"));
			String line=" ";
			String[] trainInfo;
			while ((line = br.readLine()) != null)
			{
				trainInfo = line.split(",");									// Reading up details line by line
			   // setting up train object and storing it in train list												
				trainInformation.add(new trainDetails(trainInfo[0], trainInfo[1], trainInfo[2], trainInfo[3], trainInfo[4], trainInfo[5], trainInfo[6]));

			}
			//sorting(trainInformation);
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

		return trainInformation;
	}
	}