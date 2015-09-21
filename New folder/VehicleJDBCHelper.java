import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class VehicleJDBCHelper 
{
	public static void createVehicleTable(Vehicle objectVehicle) 
	{
		String query = "CREATE TABLE IF NOT EXISTS Vehicle "
				+"("
				+ "vehicle_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY "
				+ "make VARCHAR(100)"
				+ "model VARCHAR(100)"
				+"engineInCC INT"
				+"fuelCapacity INT"
				+"milage INT"
				+"price DECIMAL"
				+"roadTax DECIMAL"
				+")";

		Statement stmt = null;
		
		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
			if(objectVehicle instanceof Car)
			{
				createCarTable((Car)objectVehicle);
			}
			else
			{
				createBikeTable((Bike)objectVehicle);
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

	}

	public static void createCarTable(Car objectCar) 
	{
		String query = "CREATE TABLE IF NOT EXISTS Car "
				+"("
				+ "vehicle_id INT NOT NULL PRIMARY KEY "
				+ "air_Bag BOOLEAN CHECK (air_Bag IN(true,false))"
				+ "air_Conditioner BOOLEAN CHECK (air_Bag IN(true,false))"
				+ "powerSteering BOOLEAN CHECK (air_Bag IN(true,false))"
				+ "CONSTRAINT `bike_vehicle_id` FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id)"
				+")";

		Statement stmt = null;

		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
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
	}

	public static void createBikeTable(Bike objectBike) 
	{
		String query = "CREATE TABLE IF NOT EXISTS Bike "
				+"("
				+ "vehicle_id INT NOT NULL PRIMARY KEY "
				+ "self_Start CHECK (self_Start IN(true,false))"
				+ "helmet_price DECIMAL"
				+ "CONSTRAINT `bike_vehicle_id` FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id)"
				+")";

		Statement stmt = null;

		/*Connection open.*/
		Connection con = ConnectionUtil.getConnection();				
		try 
		{
			stmt = con.createStatement();
			stmt.execute(query);
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
	}

	public static void insertInVehicleTable(Vehicle objectVehicle)
	{
		PreparedStatement ps = null;
		Connection con = ConnectionUtil.getConnection();
		String query = "INSERT INTO Vehicle(vehicle_id,make,model,engineInCC,fuelCapacity,milage,price,roadTax) VALUES (?,?,?,?,?,?,?,?)";

		try {
			ps = con.prepareStatement(query);

			ps.setInt(1,objectVehicle.getVehicleID());
			ps.setString(2,objectVehicle.getMake());
			ps.setString(3,objectVehicle.getModel());
			ps.setInt(4,objectVehicle.getEngineInCC());
			ps.setInt(5,objectVehicle.getFuelCapacity());
			ps.setInt(6,objectVehicle.getMilage());
			ps.setDouble(7,objectVehicle.getPrice());
			ps.setDouble(1,objectVehicle.getRoadTax());
			ps.executeQuery();
			if(objectVehicle instanceof Car)
			{
				insertInCarTable((Car)objectVehicle);
			}
			else
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
	
	public static void insertInCarTable(Car objectCar)
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
			ps.executeQuery();
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
	
	public static void insertInBikeTable(Bike objectBike)
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
			ps.executeQuery();
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

}
