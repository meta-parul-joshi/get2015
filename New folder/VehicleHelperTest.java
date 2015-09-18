import static org.junit.Assert.*;

import java.rmi.server.ObjID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleHelperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	// To test for vehicleHelper class
	public void testVehicleHelperForCar() {
		// Check for creation of car object
		VehicleHelper objectHelper = new VehicleHelper();
		Vehicle objectCar = objectHelper.createVehicle("Car", "Varna", "Varna23");
		assertEquals(true, objectCar instanceof Car);
	}
	
	@Test
	// To test for vehicleHelper class
	public void testVehicleHelperForBike() {
		// Check for creation of bike object
		VehicleHelper objectHelper = new VehicleHelper();
		Vehicle objectBike = objectHelper.createVehicle("Bike", "Varna", "Varna23");
		assertEquals(true, objectBike instanceof Bike);
	}
}
