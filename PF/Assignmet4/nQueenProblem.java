import java.util.Scanner;

import org.hamcrest.core.IsSame;
/* This class performs nqueen problems using recursion.
 * @parul joshi
 * */
public class nQueenProblem 
{
	public static void main(String[] args) 
	{
		//Initialize object of class to access methods of class.
		nQueenProblem objnQueen=new nQueenProblem();
		int numOfQueen;
		/*Input from user.*/
		numOfQueen=objnQueen.getNumQueen();
		int board[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		boolean result=objnQueen.getNQueenSolution(board,0,numOfQueen);
		if(result)
		{
			System.out.println("Queens are at correct position");
		}
		/*Print postion of queens.*/
		for(int index1=0;index1<board.length;index1++)
		{
			for(int index2=0;index2<board.length;index2++)
			{
				System.out.print(board[index1][index2]+"\t");
			}
			System.out.println();
		}
	}
	
	/*Function takes number of queen as input from console.*/
	int getNumQueen()
	{
		int number=0;
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("Enter number of Queen : ");
			String inputStr = sc.nextLine();
			if(isNumeric(inputStr))
			{
				number=Integer.parseInt(inputStr);
				break;
			}
			
		}while(true);
		
		return number;
	}

	boolean isNumeric(String input) 
	{
		try 
		{
			Integer.parseInt(input);
		} 
		catch (NumberFormatException e) 
		{
			return false;
		}
		
		return true;
	}
	
	/*Function find solution of n queen problem.
	 * it takes board[][],startrow,dimensionOfMatrix as parameter. */
	boolean getNQueenSolution( int board[][], int startRow, int dimensionOfMatrix )
	{ 
	    if (startRow >= dimensionOfMatrix) 
	    {
	        return true;
	    }
	    for(int index = 0; index<dimensionOfMatrix; index++)   
	    { 	
	    	if(isSafe(board, startRow, index, dimensionOfMatrix))
	    	{
	   		        board[startRow][index] = 1;
	   		        if ( getNQueenSolution(board, startRow + 1, dimensionOfMatrix ) == true )
	   		        {
	   		        	return true;
	   		        }
	           
	   		        board[startRow][index] = 0; 

	    	}
	    }
	           
	    return false;
	}
	
	/*Function checks queen is safe.
	 * It takes board[],row,column,dimentionOfMatrix as parameter.*/
	boolean isSafe(int board[][], int row, int column, int dimensionOfMatrix)
	{
	    int index1, index2;   
	    for (index1 = 0; index1 < row; index1++)
	    {
	        if (board[index1][column]!='\0')
	        {
	            return false;
	        }
	    }

	    for (index1 = row, index2 = column; index1 >= 0 && index2 >= 0; index1--, index2--)
	    {
	        if (board[index1][index2]!='\0')
	        {
	            return false;
	        }
	    }
	    
	    for (index1 = row, index2 = column; index2 >= 0 && index1 < dimensionOfMatrix; index1++, index2--)
	    {
	        if (board[index1][index2]!='\0')
	        {
	            return false;
	        }
	    }

	    return true;
	}
	
}

