/*Class perform infix to postfix conversion.
 * @author parul.
*/
public class InfixToPostfixConversion
{	
	public static void main(String[] args)
    {
		System.out.println("Infix to Postfix Conversion");
        /*Initialize object of class to access methods of class InfixToPostfix.*/
		InfixToPostfix<Character> objInfixToPostfix = new InfixToPostfix<Character>();     
        while(true)
        {
        	System.out.println ( "\n1).Convert infix notation into postfix notation " );
			System.out.println ( "2). Exit");
            int choice = Utility.getIntegerValue("Enter your choice");
            switch (choice)
            {
            	case 1 : String inputInfixNotation = Utility.getStringInput("Enter the infix string : ");
            			 String outputPostfixNotation = objInfixToPostfix.convertInfixToPostfix(inputInfixNotation);
            			 System.out.println ( "\nInput : "+inputInfixNotation );
            			 System.out.println ( "\nOutput Infix to postfix : "+outputPostfixNotation );
            			 break;   
            	case 2 : System.exit(0);
        			 	 break;   
            	default: System.out.println("Wrong Entry \n ");
                	 	 break;
            }         
        }                                                         
    }    
}
