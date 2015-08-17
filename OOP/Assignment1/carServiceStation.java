import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class mechanic 
{
	String carType;
	
	//Constructor.
	public mechanic(String carType)
	{
		this.carType = carType ;
	}
	
	//Function count number of mechanic available in file for particular car type.
	int numOfMechanicOfCarType()
	{
		int numOfMechanic = 0;
		try
		{	
			//Read from file.
			File file = new File("C://Users/Parul/workspace/Assignment5/src/mechanic.txt");
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine())
	        {
	           if(scanner.nextLine().indexOf(carType)!= -1)
	        	   numOfMechanic = numOfMechanic + 1;
	        }
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return numOfMechanic;		
	}
	
	//Function calculates total earning of particular mechanic.
	//It contains carCount as parameter.
	int costOfCarServiced( int carCount)
	{
		int totalCost = 0;
		try
		{
			//Read from file.
			InputStream in = new FileInputStream ( new File("C://Users/parul/workspace/Assignment5/src/mechanic.txt") );
			BufferedReader reader = new BufferedReader (new InputStreamReader(in));
			String line;
			while((line = reader.readLine())!= null)
			{
				if(line.indexOf(carType)!=-1)
				{
					int index = line.lastIndexOf(',');
					String cost = line.substring(index+2); 
					totalCost = Integer.parseInt(cost)* carCount ;
					break;
				}
			}
			in.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return totalCost;
	}			
}

class car
{
	String carType;
	
	//Constructor.
	public car (String carType)
	{
		this.carType = carType;
	}
	
	//Function counts number of cars arrived at service station of particular type.
	int numOfCarType() 	
	{
		int numOfCar = 0;
		try
		{
			//Read from file.
			File file = new File("C://Users/Parul/workspace/Assignment5/src/serviceCars.txt");
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine())
	        {
	           if(scanner.nextLine().indexOf(carType)!= -1)
	        	   numOfCar = numOfCar + 1;
	        }
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return numOfCar;
	}
}


public class carServiceStation 
{
	/*Function compares number of mechanic available and cars at service station and 
	/*return how many cars can be serviced.
	/*It contain countCarTypr and countMechanicType as parameter.*/
	int numOfCarServiced( int countCarType, int countMechanicType)
	{	
		if(countCarType == 0)
		return 0;
		else if ( countCarType < countMechanicType)
			return countCarType;
		else
			return countMechanicType;
	}	
	
	public static void main(String[] args) 
	{
		File file;
		int numOfCars,index;
		try
		{			
			Scanner sc = new Scanner (System.in);
			List<String> carList = new ArrayList<String>() ;
			//Input from user.
			numOfCars = Utility.GetInput("Enter the num of cars to service : ");
			System.out.println("Enter the Type of cars to service : ");
			//Write in file.
			OutputStream out = new FileOutputStream ( new File("C://Users/Parul/workspace/Assignment5/src/serviceCars.txt") );
			BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(out));
			index = 0;
			while(index<numOfCars)
			{
				String line = sc.nextLine()+"\n";  
				out.write(line.getBytes());
				index++;
			}	
			out.close();
			
			//Initialize object of class service station.
			carServiceStation objServiceStation = new carServiceStation();
			
			//Initialize object of class car for cartype Sedan.
			car objCarSedan = new car("Sedan");
			int countCarSedan = objCarSedan.numOfCarType();
			
			//Initialize object of class mechanic for cartype Sedan
			mechanic objMechanicSedan = new mechanic("Sedan");
			int countMechanicSedan = objMechanicSedan.numOfMechanicOfCarType();
			
			int numOfSedanServiced = objServiceStation.numOfCarServiced(countCarSedan, countMechanicSedan);
			
			//Prints how many cars serviced of HatchBack type.
			System.out.println("Sedan : "+numOfSedanServiced);			
			int earningBySedan = objMechanicSedan.costOfCarServiced(numOfSedanServiced);
			
			//Initialize object of class car for cartype Hatchback .
			car objCarHatchback = new car("Hatchback");
			int countCarHatchback = objCarHatchback.numOfCarType();
			
			//Initialize object of class mechanic for cartype Hatchback.
			mechanic objMechanicHatchback = new mechanic("Hatchback");
			int countMechanicHatchback = objMechanicHatchback.numOfMechanicOfCarType();
			int numOfHatchbackServiced = objServiceStation.numOfCarServiced(countCarHatchback, countMechanicHatchback);
			
			//Prints how many cars serviced of HatchBack type.
			System.out.println("HatchBack : "+numOfHatchbackServiced);
			int earningByHatchback = objMechanicHatchback.costOfCarServiced(numOfHatchbackServiced);

			//Initialize object of class car for cartype SUV. 
			car objCarSUV = new car("SUV");
			int countCarSUV = objCarSUV.numOfCarType();
			
			//Initialize object of class mechanic for cartype SUV.
			mechanic objMechanicSUV = new mechanic("SUV");
			int countMechanicSUV = objMechanicSUV.numOfMechanicOfCarType();
			int numOfSUVServiced = objServiceStation.numOfCarServiced(countCarSUV, countMechanicSUV);
			
			//Prints how many cars serviced of SUV type.
			System.out.println("SUV : "+numOfSUVServiced);
			int earningBySUV = objMechanicSUV.costOfCarServiced(numOfSUVServiced);
			
	        //Prints total earning.
			System.out.println("Total earning : "+( earningBySedan + earningByHatchback + earningBySUV ));
				
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
