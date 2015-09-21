//Helper class.
public class VehicleHelper {

	// to check whether car or bike input
	public static Vehicle createVehicle(VehicleType vehicleType, String make,String model) 
	{
		if (vehicleType.equals(VehicleType.Car)) 
		{
			
			return createCar(make, model);
		} 
		else 
		{
			return createBike(make, model);
		}
	}
	
	private static Vehicle createCar(String make,String model)
	{
		Vehicle objectCar = new Car();
		objectCar.setMake(make);
		objectCar.setModel(model);
		return objectCar;
	}
	
	private static Vehicle createBike(String make,String model)
	{
		Vehicle objectBike = new Bike();
		objectBike.setMake(make);
		objectBike.setModel(model);
		return objectBike;
	}
}
