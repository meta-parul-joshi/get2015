import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {

	public static void main(String args[])
	{
		
		List<Integer> listObj = new LinkedList<Integer>();
		LinkedListInsert linkedListInsertObj = new LinkedListInsert();
		System.out.println("\nInsertion in sorted linked list :");
		while(true)
		{
			System.out.println("\n1). Insertion.");
			System.out.println("2). Print Linked list.");
			System.out.println("3). Exit");
			int choice = Utility.getIntegerValue("Enter your choice");
			switch(choice)
			{
				case 1: int number = Utility.getIntegerValue("\nEnter element to insert");
						linkedListInsertObj.insert(0,number, listObj);
						break;
				case 2 : System.out.println("Sorted linked list is :");
						 linkedListInsertObj.printLinkedlist(listObj);
						 break;
				case 3 : System.out.println("System exited");
					 	System.exit(0);
					 	break;
				default :System.out.println("Wrong choice...!!");
						 break;
			}
			
			System.out.println("Sorted linked list is :");
			linkedListInsertObj.printLinkedlist(listObj);	
		}
	}
}
