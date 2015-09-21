import java.util.List;
public class VehicleReadTest {
	public static void main(String args[]) 
	{
	    StaxParser objSaxParser = new StaxParser();
	    List<Vehicle> readVehicleFromConfig = objSaxParser.readVehicle("C://Users/Parul/workspace/AssignmentCaseStudy/src/Vehicle.xml");
	    for (Vehicle objVehicle : readVehicleFromConfig) 
	    {
	      System.out.println(objVehicle);
	      
	      VehicleJDBCHelper.createVehicleTable(objVehicle);
	      
	      VehicleJDBCHelper.insertInVehicleTable(objVehicle);
	    }
	    
	    
	}
}
