//class for unique features of car
public class Car extends Vehicle 
{
	boolean isAirBags;
	boolean isAirConditioner;
	boolean isPowerSteering;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isAirBags ? 1231 : 1237);
		result = prime * result + (isAirConditioner ? 1231 : 1237);
		result = prime * result + (isPowerSteering ? 1231 : 1237);
		return result;
	}

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

	@Override
	public double calculateOnRoadPrice()
	{
		return super.calculateOnRoadPrice() + 500;
	}
	
	public String toString()
	{
		return super.toString();
	}
	
}
