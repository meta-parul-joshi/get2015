import java.util.ArrayList;
import java.util.List;

public class IntAndIntegerDemo {
	
	public static void main(String args[]){
		int number1 = 99;
		int number2 = '\0';
//		int number3 = null;  // gives error
		String s = "67";

		Integer objInteger1 = new Integer(number1);// wrapper for primitive type int
		Integer objInteger2 = new Integer(number2);
		Integer objInteger3 = null;
		Integer objInteger4 = Integer.parseInt(s);

		List<Integer> listOfNumbers = new ArrayList<Integer>();
		listOfNumbers.add(objInteger1);
		listOfNumbers.add(objInteger2);
		listOfNumbers.add(objInteger4);

		//		listOfNumbers.add(objInteger3);   gives null pointer exception

		System.out.println("null object is : "+objInteger3);

		System.out.println("number2 is : "+ number2);

		System.out.println("list is :");
		for(int num : listOfNumbers)
			System.out.println(num);

		int n = objInteger4.intValue();
		System.out.println("Number is : "+n);

	}

}
