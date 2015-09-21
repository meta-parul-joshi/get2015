//vehicle detail class
public class Vehicle 
{
	int vehicleID;
	String make;
	String model;
	int engineInCC;
	int fuelCapacity;
	int milage;
	double price;
	double roadTax;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + engineInCC;
		result = prime * result + fuelCapacity;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + milage;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roadTax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + vehicleID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (engineInCC != other.engineInCC)
			return false;
		if (fuelCapacity != other.fuelCapacity)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (milage != other.milage)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(roadTax) != Double
				.doubleToLongBits(other.roadTax))
			return false;
		if (vehicleID != other.vehicleID)
			return false;
		return true;
	}
	
	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}


	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getEngineInCC() {
		return engineInCC;
	}

	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}
	
	public double calculateOnRoadPrice()
	{
		return price + roadTax;
	}
	
	public String toString()
	{
		return "Make : " + this.make + ","+ "Model : " + this.model;
	}
}
