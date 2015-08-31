
public class Tree implements iTree
{
	public Node root;
	
    public Tree()
    {
    	root = null;
    }
    
    public Node returnRoot()
    {
        return root;
    }
    
    public void insert(int item)
    {
        Node newNode = new Node();
        newNode.item = item;
        if(root==null)
        {
        	root = newNode;
        }
        else
        {
            Node current = root;
            Node parent;
            while(true)
            {
                parent = current;
                if(item == current.item)
                {
                	return;
                }
                else if(item < current.item)
                {
                    current = current.leftChild;
                    if(current == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    current = current.rightChild;
                    if(current == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    } 
     
    public void inOrder(Node Root)
    {
        if(Root != null)
        {
            inOrder(Root.leftChild);
            System.out.print(Root.item + " ");
            inOrder(Root.rightChild);
        }
    }
    
    public void postOrder(Node Root)
    {
        if(Root != null)
        {
            postOrder(Root.leftChild);
            postOrder(Root.rightChild);
            System.out.print(Root.item + " ");
        }
    }
}
