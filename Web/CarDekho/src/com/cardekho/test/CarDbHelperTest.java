package com.cardekho.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.cardekho.CarDekhoSystemException;
import com.cardekho.db.helper.CarDBHelper;
import com.cardekho.model.Car;

public class CarDbHelperTest {

//	@Test
//	public void testCreateCar() {
//		Car car = new Car();
//		car.setMake("Hyundai");
//		car.setModel("i10");
//		car.setEngineCC("600");
//		car.setFuelCapacity("35");
//		car.setMileage("15");
//		car.setPrice(500000);
//		car.setRoadTax(8);
//		car.setAC("YES");
//		car.setPowerSteering("YES");
//		car.setAccessoryKit("Yes");
//		car.setCreatedBy("Parul Joshi");
//		car.setCreatedTime(Calendar.getInstance().getTime());
//		car.setLastModifiedTime(Calendar.getInstance().getTime());
//		car.setImagePath("car6.jpg");
//		CarDBHelper carDBHelper = new CarDBHelper();
//		boolean flag = true;
//		try {
//			flag = carDBHelper.create(car);
//		} catch (CarDekhoSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(flag);
//		assertFalse(flag);
//	}
//	
//	@Test
//	public void testGetCarDetails() {
//		CarDBHelper carDBHelper = new CarDBHelper();
//		Car car = null;
//		
//		try {
//			car = carDBHelper.getCarDetails(10);
//		} catch (CarDekhoSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		boolean flag = false;
//		if(car.getModel().equals("Punto"))
//		{
//			flag = true;
//		}
//		
//		assertTrue(flag);
//	}
//	
//	@Test
//	public void NegativTestToGetVehicleByModel() {
//		CarDBHelper carDBHelper = new CarDBHelper();
//		boolean flag = false;
//		try {
//			flag = carDBHelper.getVehicleByModel("i10");
//		} catch (CarDekhoSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		assertFalse(flag);
//	}
//	
//	@Test
//	public void PositiveTestToGetVehicleByModel() {
//		CarDBHelper carDBHelper = new CarDBHelper();
//		boolean flag = false;
//		
//		try {
//			flag = carDBHelper.getVehicleByModel("Punto");
//		} catch (CarDekhoSystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		assertTrue(flag);
//	}
	
	@Test
	public void PositiveTestToUpdateCar() {
		CarDBHelper carDBHelper = new CarDBHelper();
		boolean flag = true;
		Car car = new Car();
		car.setMake("Hyundai");
		car.setModel("Verna");
		car.setEngineCC("600");
		car.setFuelCapacity("35");
		car.setMileage("13");
		car.setPrice(1000000);
		car.setRoadTax(8);
		car.setAC("YES");
		car.setPowerSteering("YES");
		car.setAccessoryKit("Yes");
		car.setLastModifiedTime(Calendar.getInstance().getTime());
		car.setImagePath("car6.jpg");
		try 
		{
			flag = carDBHelper.updateByModel(car, 2);
		} 
		catch (CarDekhoSystemException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(flag);
	}
	
}
