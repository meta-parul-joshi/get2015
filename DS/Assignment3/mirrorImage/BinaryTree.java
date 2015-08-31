package mirrorImage;

 /* Class BinaryTree */

public class BinaryTree implements iBinaryTree
{
	private Node root;
	
	/* Constructor */
	public BinaryTree()
	{
		root = null;
	}
    
	/*Function returns root node.*/
	public Node returnRoot()
     {
    	 return root;
     }
    
	/* Functions to insert data */
	public void insert(int data)
	{
		root = insert(root, data);
	}

     /* Function to insert data recursively */
	private Node insert(Node node, int data)
	{
		if (node == null)
		{
			node = new Node(data);
		}
		else
		{
			if (node.getRight() == null)
			{
				node.right = insert(node.right, data);
			}
			else
			{
				node.left = insert(node.left, data);             
			}
		}
		
		return node;
	}     

	/* Function for postorder traversal */
	public void postorder(Node r)
	{
		if (r != null)
		{
			postorder(r.getLeft());             
			postorder(r.getRight());
			System.out.print(r.getitem() +" ");
		}
	}     
}

 
