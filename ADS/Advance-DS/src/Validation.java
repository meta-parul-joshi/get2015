public class Validation {

	/* Method to validate expression*/
	public static boolean isExpression(String expression) 
	{
		if(expression == null)
		{
			return false;
		}
		
		char[] expressionArray = expression.toCharArray();
		int length = expressionArray.length;
	    int openCount = 0, closeCount = 0;
	    int i = 0;
	    
	    for(i = 0; i < (length-1); i++)
	    {
	    	if(expressionArray[i] == ')')
	    	{
	    		if(Character.isDigit(expressionArray[i+1]) || expressionArray[i+1] == '(')
	    		{
	    			return false;
	    		}
	    	}
	    	
	    	if(expressionArray[i] == '(')
	    	{
	    		if(expressionArray[i+1] == ',')
	    				return false;
	    	}
	    	
	    	if(Character.isDigit(expressionArray[i])) 
	    	{
	    		if(expressionArray[i+1] == '(') 
	    		{
	    			return false;
	    		}
	    	}
	    }

	    
	    /* Validation for acceptable symbols number or open and closed braces */
	   for (char c : expressionArray) 
	    {
	    	if(!(Character.isDigit(c)) && !(c == ',') && !(c == '(') && !(c == ')')) {
	    		return false;
	    	}
	        else
	        {
	        	if(c == '(')
	        	{
	        		openCount++;
	        	}
	            else if(c == ')')
	            {
	            	closeCount++;
	            }
	        }
	    }
	   
	    if(openCount == closeCount)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
}
