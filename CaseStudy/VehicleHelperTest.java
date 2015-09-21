import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
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
		Vehicle objectCar = VehicleHelper.createVehicle(VehicleType.Car, "Varna", "Varna23");
		assertEquals(true, objectCar instanceof Car);
	}
	
	@Test
	// To test for vehicleHelper class
	public void testVehicleHelperForBike() {
		// Check for creation of bike object
		Vehicle objectBike = VehicleHelper.createVehicle(VehicleType.Bike, "Hero", "Dream Yuga");
		assertEquals(true, objectBike instanceof Bike);
	}
	
	@Test
	public void test() {
		Set<Vehicle> listOfVehicle = new HashSet<Vehicle>();
		Vehicle firstVehicle = VehicleHelper.createVehicle(VehicleType.Car, "Varna", "Varna23");
		Vehicle secondVehicle = VehicleHelper.createVehicle(VehicleType.Bike, "Hero", "Dream Yuga");
		Vehicle thirdVehicle = VehicleHelper.createVehicle(VehicleType.Car, "Varna", "Varna23");
		listOfVehicle.add(firstVehicle);
		listOfVehicle.add(secondVehicle);
		listOfVehicle.add(thirdVehicle);
		int actualsizeOfSet = listOfVehicle.size();
		int expectedSizeOfSet = 2;
		assertEquals(expectedSizeOfSet,actualsizeOfSet);
	}
}
