import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class carServiceStationTest {

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
	public void testCountMechanic() 
	{
		mechanic objMechanicSedan = new mechanic("Sedan");
		int expectedNumMechanic=1;
		int actualNumMec=objMechanicSedan.numOfMechanicOfCarType();
		assertEquals("Match",expectedNumMechanic,actualNumMec);
	}
	
	@Test
	public void testCountNumCar() 
	{
		car objCarSedan = new car("Sedan");
		int actualCar=objCarSedan.numOfCarType();
		int expectedcars=1;
		assertEquals("Match",expectedcars,actualCar);
	}
	
	@Test
	public void testCostCar() 
	{
		mechanic objMechanicSedan = new mechanic("Sedan");
		int expectedCost=2000;
		int actualCost=objMechanicSedan.costOfCarServiced(1);
		assertEquals("Match",expectedCost,actualCost);
	}
	
	@Test
	public void testNumCarServiced() 
	{
		carServiceStation objServiceStation = new carServiceStation();
		int expectedNumCarServiced=2;
		int numberCars=2;
		int NumberMechanic=4;
		int actualNumCarServiced=objServiceStation.numOfCarServiced(numberCars,NumberMechanic);
		assertEquals("Match",expectedNumCarServiced,actualNumCarServiced);
	}
}

