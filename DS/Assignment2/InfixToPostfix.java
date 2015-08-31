/*Class implements interface iInfixToPostfix to find postfix expression of input string.
 * @author parul.
 * */
public class InfixToPostfix<T> implements iInfixToPostfix
{
	String strPostfix = "";
	
	/*Initialize object of class to access methods of class StacksUsingLinkedList.*/
	StacksUsingLinkedList<Character> objStackUsingLinkedList = new StacksUsingLinkedList<Character> (); 
	
	/*Function perform push and pop operation on operators depending on their precedence.*/
	public void pushAndPopOperatorsInStack( int precedenceOfInput, char charInfix )
	{
		if ( objStackUsingLinkedList.isEmpty() == false )
		{	
			while ( objStackUsingLinkedList.isEmpty() == false )
			{
				if ( objStackUsingLinkedList.top.getvalue().equals("(") || objStackUsingLinkedList.top.getvalue().equals(")") )
				{
					return;
				}
				else
				{
					int precedenceOfPeek = checkPrecedence ( objStackUsingLinkedList.top.getvalue().toString().charAt(0) );
					if ( precedenceOfPeek <= precedenceOfInput )
					{
						Object item = objStackUsingLinkedList.pop();
						strPostfix = strPostfix.concat(item.toString());
					}
					else
						break;
				}
			}
			
			objStackUsingLinkedList.push ( charInfix );
		}	
		else      // if stack is empty, push item in it
			objStackUsingLinkedList.push ( charInfix );
	}
	
	/*Function finds precedence of input.*/
	public int checkPrecedence ( char charInfix )
	{
		int precedence = 0;
		switch ( charInfix )
		{
			case '*' :
				
			case '/' : precedence = 2;
					   break;
					   
			case '+' :
				
			case '-' : precedence = 1;
					   break;
			
			case '(' : precedence = 3;
					   break;
					   
			case ')' : precedence = 4;
				   	   break;
				   
			default : precedence = 0;
		}
		
		return precedence;
	}
	
	public String convertInfixToPostfix(String inputString)
	{
		for ( int index = 0; index < inputString.length(); index++ )
		{
			char charInfix;
			charInfix = inputString.charAt(index);
			int precedence;
			precedence = checkPrecedence ( charInfix );	
			if ( precedence == 0 )
			{
				strPostfix = strPostfix + charInfix;
			}
			else if ( precedence == 3 )
			{
				objStackUsingLinkedList.push(charInfix);
			}
			else if ( precedence == 4 )
			{
				Object item;
				while ( objStackUsingLinkedList.top.getvalue() != '(' )
				{
					item = objStackUsingLinkedList.pop();
					strPostfix = strPostfix.concat(item.toString());
				}
				
				item = objStackUsingLinkedList.pop();
			}
			else
			{
				pushAndPopOperatorsInStack ( precedence, charInfix );
			}
		}
		
		// pops operators left in stack
		while ( objStackUsingLinkedList.top != null )
		{
			strPostfix += objStackUsingLinkedList.pop();
		}
		
		return strPostfix;
	}
}
