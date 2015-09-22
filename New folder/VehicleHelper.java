/*Class to create vehicle.
 * @author parul
 * */
public class VehicleHelper 
{
	/*Function to create vehicle.
	 * It takes enum type vehicleType, String type make,String type model as key parameter.
	 * It checks enum type according to that car or bike objects are created.
	 * It returns a vehicle object.*/
	public static Vehicle createVehicle(VehicleType vehicleType, String make,String model) 
	{
		Vehicle objectVehicle = null;
		if (vehicleType.equals(VehicleType.Car)) 
		{
			 objectVehicle = createCar(make, model);
		} 
		else 
		{
			objectVehicle = createBike(make, model);
		}
		
		return objectVehicle;
	}
	
	/*Function to create Car object.
	 * It takes String type make,String type model as key parameter.
	 * It returns a vehicle object.*/
	private static Vehicle createCar(String make,String model)
	{
		Vehicle objectCar = new Car();
		objectCar.setMake(make);
		objectCar.setModel(model);
		return objectCar;
	}
	
	/*Function to create Bike.
	 * It takes String type make,String type model as key parameter.
	 * It returns a vehicle object.*/
	private static Vehicle createBike(String make,String model)
	{
		Vehicle objectBike = new Bike();
		objectBike.setMake(make);
		objectBike.setModel(model);
		return objectBike;
	}
}
