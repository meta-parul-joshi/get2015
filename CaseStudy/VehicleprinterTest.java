import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VehicleprinterTest {

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
	// Test for vehiclePrinter class for car
	public void testprintVehicleSpecificationForCar() {
		// checking for print result
		String expectedCarDeatils = "Make : Verna,Model : verna23";
		Vehicle objectCar= VehicleHelper.createVehicle(VehicleType.Car, "Verna", "verna23");
		String actualCarDetails = VehiclePrinter.printVehicleSpecification(objectCar);
		assertEquals(expectedCarDeatils,actualCarDetails);
	}
	
	@Test
	// Test for vehiclePrinter class for bike
	public void testprintVehicleSpecificationForBike() {
		String expectedBikeDeatils = "Make : Hero,Model : Dream yuga";
		Vehicle objectBike= VehicleHelper.createVehicle(VehicleType.Bike, "Hero", "Dream yuga");
		String actualBikeDetails = VehiclePrinter.printVehicleSpecification(objectBike);
		assertEquals(expectedBikeDeatils,actualBikeDetails);
	}
}
