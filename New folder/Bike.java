//class for unique features of bike
public class Bike extends Vehicle 
{
	boolean isSelfStart ;
	float price;
	Bike(String make, String model) 
	{
		super(make,model);
	}
	
	public boolean isSelfStart() {
		return isSelfStart;
	}

	public void setSelfStart(boolean isSelfStart) {
		this.isSelfStart = isSelfStart;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isSelfStart ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(price);
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
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
}

