import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class matrixTest 
{

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
	
	int isArrayEqual(int expected[][],int actual[][])
	{

	for(int index1=0;index1<2;index1++)
	{
		for(int index2=0;index2<2;index2++)
		{
			if(expected[index1][index2]!=actual[index1][index2])
			{
				return 0;
			}
		}
	}
	
	return 1;	
	}
	
	@Test
	public void testTransposeOfMatrix() 
	{
		matrix objMatrix=new matrix(2,2);
		int expectedmatrix[][]={{1,3},{2,4}};
		int inputmatrix[][]={{1,2},{3,4}};
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				objMatrix.addElement(i, j,inputmatrix[i][j]);
			}
		}
		matrix obj=objMatrix.transpose();
		int a=isArrayEqual(expectedmatrix,obj.data);
		assertEquals("match",1,a);
	}
	
	@Test
	public void testAddElement() 
	{
		matrix objMatrix=new matrix(1,1);
		int expectedValue=4;
		objMatrix.addElement(0,0,4);
		assertEquals("match",expectedValue,objMatrix.data[0][0]);
	}

}
