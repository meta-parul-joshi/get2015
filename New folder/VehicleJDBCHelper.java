import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class VehicleJDBCHelper 
{
	/*Function to create vehicle table.
	 *It takes objectVehicle as key parameter.
	 *It checks type of object whether car or bike object,
	 *and corresponding car or bike table created.
	 *It returns a string that defines type of vehicle created.*/
	public static String createVehicleTable(Vehicle objectVehicle) 
	{
		String result = null;
		String query = "CREATE TABLE IF NOT EXISTS Vehicle "
				+"("
				+ "vehicle_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,"
				+ "make VARCHAR(100),"
				+ "model VARCHAR(100),"
				+"engineInCC INT,"
				+"fuelCapacity INT,"
				+"milage INT,"
				+"price DECIMAL,"
				+"roadTax DECIMAL,"
				+ "created_by VARCHAR(100),"
				+ "created_time TIMESTAMP DEFAULT NOW()"
				+")";

		Statement stmt = null;
		
		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
			result = "Vehicle -";
			if(objectVehicle instanceof Car)
			{
				result = result.concat(createCarTable((Car)objectVehicle));
			}
			else if(objectVehicle instanceof Bike)
			{
				result = result.concat(createBikeTable((Bike)objectVehicle));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
			} 	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/*Function to create Car table.
	 * it takes objectVehicle as key parameter.
	 * It returns a string that defines type of vehicle created.*/
	private static String createCarTable(Car objectCar) 
	{
		String result = null;
		String query = "CREATE TABLE IF NOT EXISTS Car "
				+"("
				+ "vehicle_id INT NOT NULL PRIMARY KEY, "
				+ "air_Bag BOOLEAN,"
				+ "air_Conditioner BOOLEAN,"
				+ "powerSteering BOOLEAN,"
				+ "CONSTRAINT `car_vehicle_id` FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE"
				+")";

		Statement stmt = null;

		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
			result = " Car created ";
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
			} 	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/*Function to create bike table.
	 * it takes objectVehicle as key parameter.
	 * It returns a string that defines type of vehicle created.*/
	private static String createBikeTable(Bike objectBike) 
	{
		String result = null;
		String query = "CREATE TABLE IF NOT EXISTS Bike "
				+ "("
				+ "vehicle_id INT NOT NULL PRIMARY KEY, "
				+ "self_Start BOOLEAN,"
				+ "helmet_price DECIMAL,"
				+ "CONSTRAINT `bike_vehicle_id` FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE"
				+ ")";

		Statement stmt = null;

		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
			result = " Bike created";
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
			} 	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/*Function to insert data in vehicle table.
	 * it takes objectVehicle as key parameter.
	 * It checks type of object whether car or bike object,
	 * accordingly data inserted in  vehicle table and corresponding car or bike table.*/
	public static void insertInVehicleTable(Vehicle objectVehicle)
	{
		PreparedStatement ps = null;
		Connection con = ConnectionUtil.getConnection();
		String query = "INSERT INTO Vehicle(vehicle_id,make,model,engineInCC,fuelCapacity,milage,price,roadTax,created_by) VALUES (?,?,?,?,?,?,?,?,?)";

		try
		{
			ps = con.prepareStatement(query);
			ps.setInt(1,objectVehicle.getVehicleID());
			ps.setString(2,objectVehicle.getMake());
			ps.setString(3,objectVehicle.getModel());
			ps.setInt(4,objectVehicle.getEngineInCC());
			ps.setInt(5,objectVehicle.getFuelCapacity());
			ps.setInt(6,objectVehicle.getmileage());
			ps.setDouble(7,objectVehicle.getPrice());
			ps.setDouble(8,objectVehicle.getRoadTax());
			ps.setString(9, objectVehicle.getCreatedBy());
			ps.execute();
			if(objectVehicle instanceof Car)
			{
				insertInCarTable((Car)objectVehicle);
			}
			else if(objectVehicle instanceof Bike)
			{
				insertInBikeTable((Bike)objectVehicle);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (ps != null) 
				{
					ps.close();
				}

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

		}
		
	}
	
	/*Function to insert data in car table.
	 * it takes objectVehicle as key parameter.*/
	private static void insertInCarTable(Car objectCar)
	{
		PreparedStatement ps = null;
		Connection con = ConnectionUtil.getConnection();
		String query = "INSERT INTO Car(vehicle_id,air_Bag,air_Conditioner,powerSteering) VALUES (?,?,?,?)";

		try 
		{
			ps = con.prepareStatement(query);
			ps.setInt(1,objectCar.getVehicleID());
			ps.setBoolean(2,objectCar.isAirBags());
			ps.setBoolean(3,objectCar.isAirConditioner());
			ps.setBoolean(4,objectCar.isPowerSteering());
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (ps != null) 
				{
					ps.close();
				}

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

		}
	
	}
	
	/*Function to insert data in bike table.
	 * it takes objectVehicle as key parameter.*/
	private static void insertInBikeTable(Bike objectBike)
	{
		PreparedStatement ps = null;
		Connection con = ConnectionUtil.getConnection();
		String query = "INSERT INTO Bike(vehicle_id,self_Start,helmet_price) VALUES (?,?,?)";

		try 
		{
			ps = con.prepareStatement(query);
			ps.setInt(1,objectBike.getVehicleID());
			ps.setBoolean(2,objectBike.isSelfStart());
			ps.setDouble(3,objectBike.getHelmetPrice());
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (ps != null) 
				{
					ps.close();
				}

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

		}
	
	}
	
	
	/*Function to delete data from vehicle table.
	 * it takes objectVehicle as key parameter.It checks type of object whether car or bike object,
	 * accordingly data with vehicle id is deleted from vehicle table and and corresponding car or bike table.
	 * It returns a string that defines type of vehicle deleted with vehicle id.*/
	public static String deleteVehicleTable(Vehicle objectVehicle) 
	{
		String result = null;
		if(objectVehicle instanceof Car)
		{
			result = deleteCarTable(objectVehicle);
		}
		else
		{
			result = deleteBikeTable(objectVehicle);
		}
		
		String query = "DELETE FROM Vehicle WHERE vehicle_id = " + objectVehicle.getVehicleID();
		Statement stmt = null;

		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
			result =result.concat( "Vehicle with vehicle id : " + objectVehicle.getVehicleID() + " deleted Successfully");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
			} 	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/*Function to delete data from bike table.
	 * it takes objectVehicle as key parameter.
	 * It returns a string that defines type of vehicle deleted with vehicle id.*/
	private static String deleteBikeTable(Vehicle objectVehicle) 
	{
		String result = null;
		String query = "DELETE FROM Bike WHERE vehicle_id = " + objectVehicle.getVehicleID();
		Statement stmt = null;

		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
			result = "Bike with vehicle id : " + objectVehicle.getVehicleID() + " deleted Successfully";
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
			} 	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/*Function to delete data from car table.
	 * it takes objectVehicle as key parameter.
	 * It returns a string that defines type of vehicle deleted with vehicle id.*/
	private static String deleteCarTable(Vehicle objectVehicle) 
	{
		String result = null;
		String query = "DELETE FROM Car WHERE vehicle_id = " + objectVehicle.getVehicleID();
		Statement stmt = null;

		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
			result = "Car with vehicle id : " + objectVehicle.getVehicleID() + " deleted Successfully";
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 	
		{
			/* close connection */
			try 
			{
				if (con != null) 
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
			} 	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
