import java.util.HashSet;
import java.util.Set;

public class Concordance 
{
	/** characterSet is set of characters of given string */
	

	private Set<Character> readCharacters(char[] charArray) 
	{
		
		Set<Character> characterSet = new HashSet<Character>();
		/* character array is traversed using for each loop
		 * and characters are added to characterSet (Repeated characters
		 * will not be stored)
		 */
		for(Character c : charArray)
		{
			characterSet.add(c);
		}	
		
		return characterSet;
	}
	
	
	
	/** Method to find concordance of characters in a string
	 * 
	 * @param string : input String
	 */
	public void findConcordance(String[] arrayOfString) 
	{
		String str="";
		
		for(int i = 0 ; i < arrayOfString.length  ; i++)
		{
			str = str + arrayOfString[i];
		}
		
		char[] charArray = str.toCharArray();
		
		Set<Character> characterSet = new HashSet<Character>();
		/* Internally calling readCharacters() */
		characterSet = readCharacters(charArray);
		for (Character c : characterSet)
		{
			System.out.print(c+"[");
			for(int i = 0 ; i < charArray.length  ; i++)
			{
				if(charArray[i] == c)
				{
				  System.out.print(i+" ");
				}	
			}
			
			System.out.println("]");
		}
	}
}
