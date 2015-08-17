import java.util.ArrayList;
import java.util.List;
public class serviceStationManagement 
{

	public static void main(String[] args) 
	{
		

	}

}

class Mechanic 
{
	String name;// Name of Person
	String carType;// Specification of Person
	int Flag;// To check whether person is busy or not

	

	public Mechanic(String name, String carType, int flag) 
	{
		this.name = name;
		this.carType = carType;
		Flag = flag;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getCarType() 
	{
		return carType;
	}

	public void setCarType(String carType) 
	{
		this.carType = carType;
	}

	public int getFlag()
	{
		return Flag;
	}

	public void setFlag(int flag) 
	{
		Flag = flag;
	}

}

class Cars
{
	String type;
	double serviceRate;

	public Cars(String type, double serviceRate) 
	{
		this.type = type;
		this.serviceRate = serviceRate;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public double getServiceRate() 
	{
		return serviceRate;
	}

	public void setServiceRate(double serviceRate) 
	{
		this.serviceRate = serviceRate;
	}

}

class ServiceStation 
{
	List<Mechanic> mechanicList;
	List<Cars> carsList;
	
	public ServiceStation()
	{
		mechanicList = new ArrayList<Mechanic>();
		carsList = new ArrayList<Cars>();
	}

	public List<Mechanic> getPersonList()
	{
		return mechanicList;
	}

	public void setPersonList(List<Mechanic> personList) 
	{
		this.mechanicList = personList;
	}

	public List<Cars> getCarsList() 
	{
		return carsList;
	}

	public void setCarsList(List<Cars> carsList) 
	{
		this.carsList = carsList;
	}
}

