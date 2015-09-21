//class for unique features of bike
public class Bike extends Vehicle 
{
	boolean isSelfStart ;
	double helmetPrice;
	
	public boolean isSelfStart() {
		return isSelfStart;
	}

	public void setSelfStart(boolean isSelfStart) {
		this.isSelfStart = isSelfStart;
	}

	public double getHelmetPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isSelfStart ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Bike other = (Bike) obj;
		if (isSelfStart != other.isSelfStart)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	public void setHelmetPrice(double price) {
		this.helmetPrice = price;
	}
	
	@Override
	public double calculateOnRoadPrice()
	{
		return super.calculateOnRoadPrice() + 100;
	}
	
	public String toString()
	{
		return super.toString();
	}
}
