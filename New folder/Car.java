/*Class to define car it implements vehicle.
 * @author parul
 * */
public class Car extends Vehicle 
{
	private boolean isAirBags;
	private boolean isAirConditioner;
	private boolean isPowerSteering;

	/*Overrides hash code of object class.*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isAirBags ? 1231 : 1237);
		result = prime * result + (isAirConditioner ? 1231 : 1237);
		result = prime * result + (isPowerSteering ? 1231 : 1237);
		return result;
	}

	/*Overrides equals method of object class.*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (isAirBags != other.isAirBags)
			return false;
		if (isAirConditioner != other.isAirConditioner)
			return false;
		if (isPowerSteering != other.isPowerSteering)
			return false;
		return true;
	}
	
	public boolean isAirBags() {
		return isAirBags;
	}

	public void setAirBags(boolean isAirBags) {
		this.isAirBags = isAirBags;
	}

	public boolean isAirConditioner() {
		return isAirConditioner;
	}

	public void setAirConditioner(boolean isAirConditioner) {
		this.isAirConditioner = isAirConditioner;
	}

	public boolean isPowerSteering() {
		return isPowerSteering;
	}

	public void setPowerSteering(boolean isPowerSteering) {
		this.isPowerSteering = isPowerSteering;
	}

	/*Function overrides calculate on road price method of vehicle class.*/
	@Override
	public double calculateOnRoadPrice()
	{
		return super.calculateOnRoadPrice() + 500;
	}
	
	/*Function overrides toString method of vehicle class.*/
	public String toString()
	{
		return super.toString() + ", " + "Air bag : " + this.isAirBags + ", " + "Air Conditioner : " + this.isAirConditioner + ", " + "Power Steering : " + this.isPowerSteering;
	}
	
}
