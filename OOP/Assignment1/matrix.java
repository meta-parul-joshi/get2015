import java.util.Scanner;
/*This class will implement matrix operations
 * @parul joshi
 * */
public class matrix
{
	/*Properties  of class matrix.*/
	int data[][];
	int noRow;
	int noColumn;
	
	/*Parameterized constructor..*/
	public matrix(int row,int Column)
	{
		noRow=row;
		noColumn=Column;
		data=new int[row][Column];
	}
	
	/*This method of class implements addition of element in matrix at particular position.
	 * It contains row,column,value as parameter.*/
	public void addElement(int row,int column,int value)
	{
		data[row][column]=value;
	}
	
	/*This method of class generates transpose of matrix.
	 * It returns a object.*/
	public matrix transpose()
	{
		matrix objMatrix=new matrix(noRow,noColumn);
		for(int i=0;i<noRow;i++)
		{
			for(int j=0;j<noColumn;j++)
			{
				objMatrix.data[i][j]=data[j][i];		
			}
		}
		
		return objMatrix;
	}
	
	/*This method of class produce output matrix on console.*/
	public void show()
	{
		for(int i=0;i<noRow;i++)
		{
			for(int j=0;j<noColumn;j++)
			{
				System.out.print(data[i][j]+"\t");
			}
			
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) 
	{
		int value,rows,columns;
	    Scanner sc=new Scanner(System.in);
		/*Input from user.*/
		/*Number of rows cannot be zero*/
		
		rows=Utility.GetInput("Enter number of rows in matrix");
		
		/*Number of columns can not be zero.*/

		columns=Utility.GetInput("Enter number of column in matrix");
	
		/*Initialize a new object of class.*/
		matrix objOfMatrix=new matrix(rows,columns);
		
		/*Input matrix element from user and place in matrix..*/
		System.out.println("Enter element in matrix");
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{				
				value=Integer.parseInt(sc.nextLine());
				objOfMatrix.addElement(i, j, value);
			}
		}
		System.out.println("Matrix is :");
		objOfMatrix.show();
		
		/*Initialize another object of class.*/
		matrix objectMatrix=new matrix(rows,columns);
		
		/*Transpose of first matrix is stored in another.*/
		objectMatrix=objOfMatrix.transpose();
		System.out.println("Matrix after transpose is :");
		objectMatrix.show();
	}
}

