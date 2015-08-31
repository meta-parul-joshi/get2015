
public interface iInfixToPostfix 
{
	void pushAndPopOperatorsInStack( int precedenceOfInput, char charInfix );
	int checkPrecedence ( char charInfix );
	String convertInfixToPostfix(String inputString);
}
