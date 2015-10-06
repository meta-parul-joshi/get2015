package TruthTable;


/* Generate Truth table for Postfix Expresultsion */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/* Generate table for operands.*/
public class GenerateTruthTable
{
	/*Count unique Operands */
	private ArrayList<Character> countUniqueOperands(String inputstring)
	{
		ArrayList<Character> charList=new ArrayList<Character>();
		char inputCharacterArray[]=inputstring.toCharArray();
		boolean flag=true;
		for(int index=0;index<inputCharacterArray.length;index++)
		{
			if(Character.isLetter(inputCharacterArray[index]))
			{
				for(int index1 = 0; index1<charList.size();index1++)
				{
					if(inputCharacterArray[index]==(char)charList.get(index1))
					{
						flag=false;
						break;
					}
				}
				if(flag)
				{
					charList.add(inputCharacterArray[index]);
					flag=true;
				}
			}
		}
		
		System.out.println(charList +"    "+inputstring);
		return charList;
	}
	
	/* Generate table for operands.*/
	public void generateTruthTable(String inputstring) 
	{
		ArrayList<Character> charList = countUniqueOperands(inputstring);
		boolean result[] = new boolean[charList.size()];
		generate(result, 0,inputstring,charList);
	}
	
	private void generate(boolean[] result, int start,String inputstring,ArrayList<Character> charList) 
	{
		if (start == result.length)
		{
			System.out.print(Arrays.toString(result));
			boolean output=calculate(inputstring,charList,result);
			System.out.println("   "+output);
		}
		else
		{
			generate(result, start + 1,inputstring,charList);
			result[start] = true;
			generate(result, start + 1, inputstring,charList);
			result[start] = false;
		}
	} 

	/* Generate table for postfix expression. */
	private boolean calculate(String inputstring, ArrayList<Character> charList,boolean result[])  
	{  
		boolean output=false;  
		boolean secondOperand,firstOperand;
		Stack<Boolean> stack=new Stack<Boolean>(); 
		for(int index3=0;index3<inputstring.length();index3++)  
		{  
			char[]  input1=inputstring.toCharArray();
			if(Character.isLetter(input1[index3]))
			{
				int pos=charList.indexOf(input1[index3]);
				stack.push(result[pos]);	        
			}
			else if(input1[index3]=='&' ||input1[index3]=='|')
			{
				firstOperand = (boolean)  stack.pop();
				secondOperand =  (boolean) stack.pop();
				switch(input1[index3])  
				{  
				case '&':output=firstOperand&secondOperand; 
				break;  
				case '|':output=firstOperand|secondOperand;  
				break;
				}  
				
				stack.push(output);  
			}  
			else 
			{
				firstOperand =  (boolean) stack.pop();
				output=!firstOperand;
				stack.push(output);  
			}
		}
		
		output=(boolean) stack.pop();  
		return(output);  
	}  
}












