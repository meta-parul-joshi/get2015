package mirrorImage;

public class BinaryTreeImplementation

{
    boolean compareTree(Node root1,Node root2)
    {
    	if(root1==null && root2==null )
    	{
    		return true;
    	}

    	int data1,data2;
    	data1 = root1.getitem();
    	data2 = root2.getitem();

    	if((data1 == data2) && compareTree(root1.left,root2.right)
    	     && compareTree(root1.right,root2.left))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    public static void main(String[] args)
    { 
    	/* Creating object of BinaryTree */
    	BinaryTree BinaryTreeOne = new BinaryTree();
    	BinaryTree BinaryTreeTwo = new BinaryTree();
    	BinaryTreeImplementation obj = new BinaryTreeImplementation();

    	/*  Perform tree operations  */
    	System.out.println("Binary Tree Test\n");          
    	while(true)    
    	{
    		System.out.println("\n\nBinary Tree Operations\n");
    		System.out.println("1. insert 1");
    		System.out.println("2. insert 2");
    		System.out.println("3. check mirror");
    		int choice = Utility.getValue("\nEnter your choice :");            
    		switch (choice)
    		{
    			case 1 : BinaryTreeOne.insert( Utility.getValue("Enter integer element to insert 1") );                     
    					 break;
    					 
    			case 2 : BinaryTreeTwo.insert( Utility.getValue("Enter integer element to insert 2") );                     
    					 break;
    					 
    			case 3 :if((BinaryTreeOne.returnRoot() != null) && (BinaryTreeTwo.returnRoot() != null))
    					{
        	   				boolean flag = obj.compareTree(BinaryTreeOne.returnRoot(), BinaryTreeTwo.returnRoot());
        	   				if(flag)
        	   				{
        	   					System.out.println("\n mirror image");
        	   					break;
        	   				}
        	   				else
        	   				{
        	   					System.out.println("\n not mirror image");
        	   				}
    					}
           				else
           				{
           					System.out.println("\nEmpty Tree.");
           					break;
           				}
    					
    					break;
           	
    			default :System.out.println("Wrong Entry \n ");
    					 break;   
    		}

           System.out.print("\nPost order 1: ");
           BinaryTreeOne.postorder(BinaryTreeOne.returnRoot());
           System.out.print("\nPost order 2: ");
           BinaryTreeTwo.postorder(BinaryTreeOne.returnRoot());

           
    }                
}
    
    
    


}

