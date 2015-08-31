/**/
public class TreeTraversal 
{
	public static void main(String[] args) 
	{
		System.out.println("\n Tree implementation. ");
		Tree objectTree = new Tree();
		while(true)
		{
			System.out.println("\n\n1). Insert element in tree.");
			System.out.println("2). Inorder Traversal.");
			System.out.println("3). Postorder Traversal.");
			System.out.println("4). Exit");
			int choice = Utility.getValue("\nEnter your choice");
			switch(choice)
			{
			case 1 :int item = Utility.getValue("Enter element to insert ");
					objectTree.insert(item);
					break;
			case 2: System.out.println("\nInorder traversal");
					objectTree.inOrder(objectTree.returnRoot());
					break;
			case 3:	System.out.println("\nPostorder traversal");
					objectTree.postOrder(objectTree.returnRoot());
					break;
			case 4: System.exit(0);
					break;
			default:System.out.println("Wrong choice...!!");
					break;
			}
		} 
	}
}
