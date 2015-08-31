package mirrorImage;

public class Node

 {    
	Node left, right;
	int item;
	
	/* Constructor */
	public Node()
	{
		left = null;
		right = null;
		item = 0;
	}

	/* Constructor */
	public Node(int n)
	{
		left = null;
		right = null;
		item = n;
	}
	
	/* Function to set left node */
	public void setLeft(Node n)
	{
		left = n;
	}
	
	/* Function to set right node */ 
	public void setRight(Node n)
	{
		right = n;
	}

	/* Function to get left node */
	public Node getLeft()
	{
		return left;
	}
	
	/* Function to get right node */
	public Node getRight()
	{
		return right;
	}
	
	/* Function to set item to node */
	public void setitem(int d)
	{
		item = d;
	}

     /* Function to get item from node */
	public int getitem()
	{
		return item;
	}     
}