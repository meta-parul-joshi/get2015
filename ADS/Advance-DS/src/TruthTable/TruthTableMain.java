package TruthTable;

public class TruthTableMain {
	
	public static void main(String args[]) 
	{
		System.out.println("\t\tTruth Table\n");
		while(true)
		{
			System.out.println("\n1. Generate truth table for expression");
			System.out.println("2. Exit");
			int choice = Utility.getIntegerValue("\nEnter your choice");
			switch(choice)
			{
					/*Generate truth table for expression.*/
			case 1 :/*Take infix expression as input from user.*/
					String inputInfixstring=Utility.getStringInput("Enter infix expression with paranthesis()");
					
					/*Initialize object of class to access their methods.*/
					GenerateTruthTable objectTruthTable =new GenerateTruthTable();
					InfixToPostfix<Character> objInfixToPostfix = new InfixToPostfix<Character>();
					
					/*Convert infix expression into postfix.*/
					String postfixString = objInfixToPostfix.convertInfixToPostfix(inputInfixstring);
					System.out.println("TRUTH TABLE\n");
					
					objectTruthTable.generateTruthTable(postfixString);
					break;
					
					/*Exit*/
			case 2 :System.out.println("System exited");
					System.exit(0);
					break;
					
					/*Default case.*/
			default :System.out.println("Wrong choice...!!");
					 break;	
			}			
		}
	}
}
