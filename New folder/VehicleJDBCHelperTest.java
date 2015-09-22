import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;


public class VehicleJDBCHelperTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void validTestCaseForTypeOfVehicleCar()
	{
		Response objectResponse = StaxParser.readVehicle("C://Users/Parul/workspace/AssignmentCaseStudy/src/Vehicle.xml");
		assertEquals(true,objectResponse.vehicleObjectList.get(0) instanceof Car);
	}	
	
	@Test
	public void invalidTestCaseForTypeOfVehicleCar()
	{
		Response objectResponse = StaxParser.readVehicle("C://Users/Parul/workspace/AssignmentCaseStudy/src/Vehicle.xml");
		assertEquals(false,objectResponse.vehicleObjectList.get(0) instanceof Bike);
	}
	
	@Test
	public void validTestCaseForTypeOfVehicleBike()
	{
		Response objectResponse = StaxParser.readVehicle("C://Users/Parul/workspace/AssignmentCaseStudy/src/Vehicle.xml");
		assertEquals(true,objectResponse.vehicleObjectList.get(3) instanceof Bike);
	}
	
	@Test
	public void testCountOfCarTypeObject()
	{
		int actualNumberOfCarObject = 0;
		int expectedNumberOfCarObject = 3;
		Response objectResponse = StaxParser.readVehicle("C://Users/Parul/workspace/AssignmentCaseStudy/src/Vehicle.xml");
		for (Vehicle objVehicle : objectResponse.vehicleObjectList) 
		{
			if(objVehicle instanceof Car)
			{
				actualNumberOfCarObject++;
			}
		}
		assertEquals(expectedNumberOfCarObject,actualNumberOfCarObject);
	}
	
	@Test
	public void testCountOfBikeTypeObject()
	{
		int actualNumberOfCarObject = 0;
		int expectedNumberOfCarObject = 3;
		Response objectResponse = StaxParser.readVehicle("C://Users/Parul/workspace/AssignmentCaseStudy/src/Vehicle.xml");
		for (Vehicle objVehicle : objectResponse.vehicleObjectList) 
		{
			if(objVehicle instanceof Bike)
			{
				actualNumberOfCarObject++;
			}
		}
		assertEquals(expectedNumberOfCarObject,actualNumberOfCarObject);
	}
}
