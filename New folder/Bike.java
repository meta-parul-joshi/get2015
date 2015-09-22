/*Class to define bike it implements vehicle.
 * @author parul
 * */
public class Bike extends Vehicle 
{
	private boolean isSelfStart ;
	private double helmetPrice;
	
	/*Overrides hash code of object class.*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isSelfStart ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(helmetPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Bike other = (Bike) obj;
		if (isSelfStart != other.isSelfStart)
			return false;
		if (Double.doubleToLongBits(helmetPrice) != Double
				.doubleToLongBits(other.helmetPrice))
			return false;
		return true;
	}

	/*Function to set helmet price.*/
	public void setHelmetPrice(double price) {
		this.helmetPrice = price;
	}

	/*Function to get self start.*/
	public boolean isSelfStart() {
		return isSelfStart;
	}

	/*Function to set self start.*/
	public void setSelfStart(boolean isSelfStart) {
		this.isSelfStart = isSelfStart;
	}
	
	/*Function to get helmet price.*/
	public double getHelmetPrice() {
		return helmetPrice;
	}
	
	/*Function overrides calculate on road price method of vehicle class.*/
	@Override
	public double calculateOnRoadPrice()
	{
		return super.calculateOnRoadPrice() + 100;
	}
	
	/*Function overrides toString method of vehicle class.*/
	@Override
	public String toString()
	{
		return super.toString() + ", " + "Self Start : " + this.isSelfStart + ", " + "Helmet Price : " + this.helmetPrice;
	}
}
