/*Abstract class to define vehicle.
 * @author parul
 * */
import java.sql.Timestamp;
public abstract class Vehicle 
{
	private int vehicleID;
	private String make;
	private String model;
	private int engineInCC;
	private int fuelCapacity;
	private int mileage;
	private double price;
	private double roadTax;
	private Timestamp createdTime;
	private String createdBy;
	
	/*Overrides hash code of object class.*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + engineInCC;
		result = prime * result + fuelCapacity;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + mileage;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roadTax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + vehicleID;
		return result;
	}
	
	/*Overrides equals method of object class.*/
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
		if (mileage != other.mileage)
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
	
	/*Function to get created time.*/
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	
	/*Function to set created time.*/
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	
	/*Function to get vehicle id.*/
	public int getVehicleID() {
		return vehicleID;
	}

	/*Function to set vehicle id.*/
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	/*Function to get make.*/
	public String getMake() {
		return make;
	}

	/*Function to set make.*/
	public void setMake(String make) {
		this.make = make;
	}

	/*Function to get model.*/
	public String getModel() {
		return model;
	}

	/*Function to set model.*/
	public void setModel(String model) {
		this.model = model;
	}

	/*Function to get engineINCC.*/
	public int getEngineInCC() {
		return engineInCC;
	}

	/*Function to set engineInCC.*/
	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}

	/*Function to get fuel capacity.*/
	public int getFuelCapacity() {
		return fuelCapacity;
	}

	/*Function to set fuel cpacity.*/
	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	/*function to get mileage.*/
	public int getmileage() {
		return mileage;
	}

	/*Function to set mileage*/
	public void setmileage(int mileage) {
		this.mileage = mileage;
	}

	/*Function to get price.*/
	public double getPrice() {
		return price;
	}

	/*Function to set price.*/
	public void setPrice(double price) {
		this.price = price;
	}
	
	/*Function to get road tax.*/
	public double getRoadTax() {
		return roadTax;
	}

	/*Function to set road tax.*/
	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}
	
	/*Function to calculate on road price of vehicle.*/
	public double calculateOnRoadPrice()
	{
		return price + roadTax;
	}
	
	/*Function to get created by*/
	public String getCreatedBy() {
		return createdBy;
	}

	/*Function to set value of created by.*/
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/*Function to print object details.*/
	public String toString()
	{
		return "Make : " + this.make + ", "+ "Model : " + this.model 
				+ ", EngineInCC : " + this.engineInCC + ", Fuel Capacity : " 
				+ this.fuelCapacity + ", mileage : " + this.mileage + ", Price : " + this.price 
				+ ", Road Tax : " + this.roadTax + ", Created By : " + this.createdBy 
				+ ", Created Time : " + this.createdTime;
	}
}
