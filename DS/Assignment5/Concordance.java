import java.util.HashSet;
import java.util.Set;

public class Concordance 
{
	/** characterSet is set of characters of given string */
	private Set<Character> characterSet = new HashSet<Character>();

	private void readCharacters(String string) 
	{
		
		/* input string is converted into a character array */
		char[] charArray = string.toCharArray();
		
		/* character array is traversed using for each loop
		 * and charaters are added to characterSet (Repeated characters
		 * will not be stored)
		 */
		for(char c : charArray)
		{
			if(c != ' ')
			characterSet.add(c);
		}		
	}
	
	
	/** Method to find concordance of characters in a string
	 * 
	 * @param string : input String
	 */
	public void findConcordance(String string) 
	{
		/* Internally calling readCharacters() */
		readCharacters(string);
		int index = 0;
		for (char c : characterSet)
		{
			System.out.print(c+"[");
			for(int i =0 ; i < string.length() ; i++)
			{
				if(string.charAt(i) == c)
				{
				  index = i; 
				  System.out.print(index+" ");
				}	
			}
			
			System.out.println("]");
		}
	}
}

