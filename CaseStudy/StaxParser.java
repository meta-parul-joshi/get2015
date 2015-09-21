import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaxParser 
{
	final String VEHICLE = "vehicle";
	final String CAR = "car";
	final String BIKE = "bike";
	final String VEHICLEID = "vehicleId";
	final String MAKE = "make";
	final String MODEL = "model";
	final String ENGINEINCC = "engineInCC";
	final String FUELCAPACITY = "fuelCapacity";
	final String MILAGE = "milage";
	final String PRICE = "price";
	final String ROADTAX = "roadTax";
	final String AC = "ac";
	final String POWERSTERING = "powerStering";
	final String ACCESSORYKIT = "accessoryKit";
	final String SELFSTART = "selfStart";
	final String HELMETPRICE = "helmetPrice";

	// @SuppressWarnings({ "unchecked", "null" })
	public List<Vehicle> readVehicle(String configFile) 
	{
		List<Vehicle> vehicleObjectList = new ArrayList<Vehicle>();
		try
		{
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Vehicle objVehicle = null;

			while (eventReader.hasNext()) 
			{
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) 
				{
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart() == (CAR)) 
					{
						objVehicle = new Car();
					}
					else if (startElement.getName().getLocalPart() == (BIKE)) 
					{
						objVehicle = new Bike();
					}
					
					if (event.isStartElement()) 
					{
						if (event.asStartElement().getName().getLocalPart().equals(VEHICLEID)) 
						{
							event = eventReader.nextEvent();
							objVehicle.setVehicleID(Integer.parseInt(event.asCharacters().getData()));
							continue;
						}
					}

					if (event.isStartElement()) 
					{
						if (event.asStartElement().getName().getLocalPart().equals(MAKE)) 
						{
							event = eventReader.nextEvent();
							objVehicle.setMake(event.asCharacters().getData());
							continue;
						}
					}

					if (event.asStartElement().getName().getLocalPart().equals(MODEL)) 
					{
						event = eventReader.nextEvent();
						objVehicle.setModel(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(ENGINEINCC))
					{
						event = eventReader.nextEvent();
						objVehicle.setEngineInCC(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(FUELCAPACITY)) 
					{
						event = eventReader.nextEvent();
						objVehicle.setFuelCapacity(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(MILAGE)) 
					{
						event = eventReader.nextEvent();
						objVehicle.setMilage(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(PRICE))
					{
						event = eventReader.nextEvent();
						objVehicle.setPrice(Double.parseDouble(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(ROADTAX)) 
					{
						event = eventReader.nextEvent();
						objVehicle.setRoadTax(Double.parseDouble(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(MILAGE))
					{
						event = eventReader.nextEvent();
						objVehicle.setMilage(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(PRICE)) 
					{
						event = eventReader.nextEvent();
						objVehicle.setPrice(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(ROADTAX))
					{
						event = eventReader.nextEvent();
						objVehicle.setMake(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(AC)) 
					{
						event = eventReader.nextEvent();
						((Car) objVehicle).setAirConditioner(Boolean.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(POWERSTERING))
					{
						event = eventReader.nextEvent();
						((Car) objVehicle).setPowerSteering(Boolean.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(ACCESSORYKIT)) 
					{
						event = eventReader.nextEvent();
						((Car) objVehicle).setAirBags(Boolean.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(SELFSTART)) 
					{
						event = eventReader.nextEvent();
						((Bike) objVehicle).setSelfStart(Boolean.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(HELMETPRICE)) 
					{
						event = eventReader.nextEvent();
						((Bike) objVehicle).setHelmetPrice(Double.parseDouble(event.asCharacters().getData()));
						continue;
					}
				}

				if (event.isEndElement()) 
				{
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (CAR)||endElement.getName().getLocalPart() == (BIKE) ) 
					{
						vehicleObjectList.add(objVehicle);
					}
				}
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (XMLStreamException e)
		{
			e.printStackTrace();
		}

		return vehicleObjectList;
	}
}