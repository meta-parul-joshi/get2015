import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Class find permutation of string using recursion.
 * @parul joshi
 * */
public class permutation 
{

	public static void main(String[] args) 
	{
		String inputStr=new String();
		/*Initialize object of class to access its methods.*/
		permutation  obj = new permutation ();
		List<String> stringArray=new ArrayList<String>();
		/*Input from user.*/
		Scanner sc =new Scanner(System.in);
		try
		{
			System.out.println("Enter the string");
			inputStr = sc.next();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		stringArray =  obj.generatePermutations(inputStr) ;
		/*Print permutation of input string.*/
		System.out.println("Permutations are : ");
		for(String str : stringArray)
		{
			System.out.println(str);
		}
	}
	
	/*Function Initialize varibles used to find permutation of string.
	 * It takes inputStr as parameter.
	 * it return List.*/
	List<String> generatePermutations(String inputStr)
	{	
		/*Convert inputStr into character array.*/
		char arr[]=inputStr.toCharArray();
		/*Initialize a list.*/
		List<String> stringArray=new ArrayList<String>();
		/*Initialize a boolean array.*/
		boolean used[] = new boolean [inputStr.length()];
		List<String> outputStr = new ArrayList<String>() ;
		/*Initialize a string buffer .*/
		StringBuffer output = new StringBuffer(); 
        stringArray=doPermutation(arr, output, used,outputStr);
        
        return stringArray;
	}

	/*Function perform operation to find permutation of character array.
	 * It takes array,output,used[],outputStr as parameter.*/
	List<String> doPermutation(char[] array, StringBuffer output, boolean used[],List<String> outputStr) 
	{
		boolean flag = false;
		/*Base condition.*/
		if(output.length()==array.length) 
        {
			/*Condition to remove duplicates.*/
			for(String s : outputStr)
			{
				if(s.equals(new String(output)))
				{
					flag = true;
					break;
				}
			}
			
			if(flag == false)
			{
				outputStr.add(output.toString());
			}
			return outputStr;
		}
		
        for (int index=0; index<array.length; index++)	    
        {
        	/*Condition to check character is used or not.*/
        	if (used[index])
        	{
        		continue;
        	}
        	
        	output.append(array[index]);
        	used[index] = true;
        	doPermutation(array, output, used,outputStr); 
        	used[index] = false;
        	output.setLength (output.length()-1); 
        }
    
        return outputStr;
	}
}
