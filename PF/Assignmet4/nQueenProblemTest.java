import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class nQueenProblemTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testnqueen() 
	{
		nQueenProblem objNQueenProblem=new nQueenProblem();
		int[][] board =new int[4][4];
		int[][] expectedOutput={{0,1,0,0},{0,0,0,1},{1,0,0,0},{0,0,1,0}};
		boolean flag=objNQueenProblem.getNQueenSolution(board,0,4);
		if(flag)
		{
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
				assertEquals("Match",expectedOutput[i][j],board[i][j]);
				}
			}	
		}
		
	}

}
