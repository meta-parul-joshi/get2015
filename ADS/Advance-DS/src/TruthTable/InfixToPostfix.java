package TruthTable;

import java.util.Stack;


/*Class implements interface iInfixToPostfix to find postfix expression of input string.
 * @author parul.
 * */
public class InfixToPostfix<T> 
{
	String strPostfix = "";

	/*Initialize object of class to access methods of class StacksUsingLinkedList.*/
	Stack<Character> objectStack = new Stack<Character> (); 

	/*Function perform push and pop operation on operators depending on their precedence.*/
	public void pushAndPopOperatorsInStack( int precedenceOfInput, char charInfix )
	{
		if ( objectStack.isEmpty() == false )
		{	
			while ( objectStack.isEmpty() == false )
			{
				if ( objectStack.peek().equals("(") || objectStack.peek().equals(")") )
				{
					return;
				}
				else
				{
					int precedenceOfPeek = checkPrecedence ( objectStack.peek().toString().charAt(0) );
					if ( precedenceOfPeek <= precedenceOfInput )
					{
						Object item = objectStack.pop();
						strPostfix = strPostfix.concat(item.toString());
					}
					else
						break;
				}
			}

			objectStack.push ( charInfix );
		}	
		else      // if stack is empty, push item in it
			objectStack.push ( charInfix );
	}

	/*Function finds precedence of input.*/
	public int checkPrecedence ( char charInfix )
	{
		int precedence = 0;
		switch ( charInfix )
		{		   
		case '!' : precedence = 3;
		break;
		case '&' : precedence = 2;
		break;

		case '|' : precedence = 1;
		break;

		case '(' : precedence = 4;
		break;

		case ')' : precedence = 5;
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
			else if ( precedence == 4 )
			{
				objectStack.push(charInfix);
			}
			else if ( precedence == 5 )
			{
				Object item;
				while ( objectStack.peek() != '(' )
				{
					item = objectStack.pop();
					strPostfix = strPostfix.concat(item.toString());
				}

				item = objectStack.pop();
			}
			else
			{
				pushAndPopOperatorsInStack ( precedence, charInfix );
			}
		}
		
		// pops operators left in stack
		while ( !objectStack.empty() )
		{
			strPostfix += objectStack.pop();
		}

		return strPostfix;
	}
}



//, new Comparator<State>() {
//	@Override
//	public int compare(State o1, State o2) {
//		return o1.f() - o2.f();
//	}
//}
//
//
///**
// * This method retrieves a user's input from the console
// * and returns the input as an integer array.
// * @return An array of integers.
// */
//public static int[] getConsoleInput() {
//	System.out.println("\nEnter a valid 8-puzzle below:");
//	Scanner scanner = new Scanner(System.in);
//
//	String t = handleBlankSpaces(scanner.nextLine());
//	String m = handleBlankSpaces(scanner.nextLine());
//	String b = handleBlankSpaces(scanner.nextLine());
//
//	return convertToArray(String.format("%s %s %s", t, m, b));
//}
//
///**
// * This method replaces blanks in the user's input
// * with 0s for easier solving of the puzzle.
// * @param row The row input by the user.
// * @return String the row with blanks replaced with 0s.
// */
//public static String handleBlankSpaces(String row) {
//	row = row.replaceAll("\\s+$", "");
//
//	if (row.length() == 3) row += " 0";
//	row = row.replace("   ", " 0 ").replace("  ", "0 ");
//	return row.trim();
//}
//
///**
// * This method converts a string of user's input into
// * an integer array to be used by the puzzle class.
// * @param s A string of 9 integers separated by spaces.
// * @return The converted integer array.
// */
//public static int[] convertToArray(String s) 
//{
//	if (!isValid(s)) 
//	{
//		System.out.println("Invalid 8-puzzle entered!");
//		System.exit(0);
//	}
//
//	int[] p = new int[9];
//	s = s.replace(" ", "");
//	for(int i = 0; i < s.length(); i++)
//	{
//		p[i] = Integer.parseInt(Character.toString(s.charAt(i)));
//	}
//	
//	return p;
//}
//
///**
// * This method determines whether or not the data inputted by
// * the user is a valid puzzle format.
// * @param puzzleInput A string of the user's input.
// * @return True if it is valid, false if not.
// */
//public static boolean isValid(String puzzleInput) 
//{
//	if (puzzleInput.length() == 17) 
//	{
//		// Check if duplicates exist in the input.
//		HashSet<Integer> lump = new HashSet<Integer>();
//		for(String s : puzzleInput.split(" ")) 
//		{
//			int i = Integer.parseInt(s);
//			if (lump.contains(i) || i > 8) 
//			{
//				return false;
//			}
//			
//			lump.add(i);
//		}
//		
//		return true;
//	}
//	
//	return false;
//}