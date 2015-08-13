import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Class solves tower of Hanoi problem using recursion.
 * @parul joshi
 * */
public class towerOfHanoi 
{	
	public static void main(String[] args) 
	{
		int numOfDisc;
		towerOfHanoi objTowerOfHanoi=new towerOfHanoi();
		/*Input from user.*/
		numOfDisc=objTowerOfHanoi.getNumberOfDisc();
		List<String> stringOutputArray;
		/*Define pag.*/
		String source="A",destination="B",temp="C";
		stringOutputArray =  objTowerOfHanoi.towerOfHanoi(source,destination,temp,numOfDisc) ;
		System.out.println("Implementation of Tower of Hanoi for "+numOfDisc+" disc");
		/*Print solution of tower of Hanoi.*/
		for(String str : stringOutputArray)
		{
			System.out.println(str);
		}
	}
	
	/*Function takes number of disc as input.*/
	int getNumberOfDisc()
	{
		int number=0;
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.println("Enter number of disc :");
			number=Integer.parseInt(sc.nextLine());
		}		
		catch(Exception e)
		{
			System.out.println("Sorry!! invalid input");
			System.exit(0);
		}
		
		return number;
	}
	
	/*Function has to solve tower of Hanoi Problem for n number of disc.
	 * It contains source,destination,temp,numberOfDisc as parameter.*/
	List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisc)
	{	
		List<String> strArray = new ArrayList<String>();
		/*Base case.*/
		if(numOfDisc==0)
		{
			return strArray;	
		}
		else if(numOfDisc>=1)
		{
			strArray.addAll(towerOfHanoi(source,temp,destination,numOfDisc-1));//Recursion
			strArray.add("Move Disc "+numOfDisc+" from "+source+" to "+destination);
			strArray.addAll(towerOfHanoi(temp,destination,source,numOfDisc-1));//Recursion.
		}
		
		return strArray;	
	}
}
