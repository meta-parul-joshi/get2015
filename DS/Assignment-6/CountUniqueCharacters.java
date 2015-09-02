import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountUniqueCharacters 
{
	/*Initializing Map having String as Key and Set<Character as value.*/
	Map<String,Set<Character>> objectMap = new HashMap<String,Set<Character>>();
	
	/*Function counts unique characters in String.
	 * It takes inputString and map as parameter.
	 * it returns 0 if string already exists in map otherwise count unique characters 
	 * using Set<Character and return number of unique character. */
	public int countUniqueCharacterInString(String inputString)
	{ 
	     boolean flag = checkCache(inputString);
	     if(!flag)
	     {	 
		    /*Convert string into character array using function toCharArray().**/
		    char[] charArray = inputString.toCharArray();
		    
		    /*Set to store characters except spaces and remove duplicates.**/
		    Set<Character> characterSet = new HashSet<Character>();
		    for(char c : charArray)
		    {
		    	if(c != ' ')
		    	{
		    		characterSet.add(c);
		    	}
		    }
		     
		    /*Insert string in map **/
		    objectMap.put(inputString,characterSet);
		    /*return number of unique characters.*/	
	     } 
	     
	     return getUniqueCharacter(inputString);
	}
	
	/*Function checks cache that key exists in map or not.
	 * It takes inputString as parameter.
	 * It returns true if element exist in map or vice-versa.
	 * */
	private boolean checkCache(String inputString)
	{
		boolean flag = false;
		/*Iterator to traverse in map.*/
	    Iterator<Map.Entry<String, Set<Character>>> iterator = objectMap.entrySet().iterator();
	    
	    /*Map traversing.*/
	    while(iterator.hasNext()) 
	    {
	    	/*Get entry of map*/
	    	Map.Entry<String, Set<Character>> me = iterator.next();
	    	
	    	/*Check string exist in map.*/
	    	if(me.getKey().equals(inputString))
	    	{
	    		break;
	    	}
	   	}
	    
	    return flag;
	  
	}
	
	/*Function returns number of characters in inputString.
	 * It takes inputString as parameter.
	 */
	private int getUniqueCharacter(String inputString)
	{
		int numberOfUniqueCharacter = 0; 
		
		/*Iterator to traverse in map.*/
	    Iterator<Map.Entry<String, Set<Character>>> iterator = objectMap.entrySet().iterator();
	    
	    /*Map traversing.*/
	    while(iterator.hasNext()) 
	    {
	    	/*Get entry of map*/
	    	Map.Entry<String, Set<Character>> me = iterator.next();
	    	
	    	/*Check string exist in map.*/
	    	if(me.getKey().equals(inputString))
	    	{
	    		numberOfUniqueCharacter = me.getValue().size();	
	    	}
	   	}
		
	    return numberOfUniqueCharacter;
	}
}
