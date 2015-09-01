
/*Class RoomAllotmentUsingHashTable assign  */
public class RoomAllotmentUsingHashTable
		{
			public static void main(String[] args) 
			{
				System.out.println("Hotel Ranbanka\n"); 
				int numberOfRooms = Utility.getIntegerValue("Enter number of rooms");
				/* Make object of HashTable */ 
				HashTable objectHashTable = new HashTable(numberOfRooms );
				
				 /* Perform HashTable operations */ 
				 while(true)
				 {
					 System.out.println("\n\nWelcome to hotel Ranbanka");
					 System.out.println("\n\n1. Allotcate room "); 
					 System.out.println("2. clear");
					 System.out.println("Exit");
					 int choice = Utility.getIntegerValue("Enter your choice");
					 switch (choice) 
					 {
					 case 1 :if(objectHashTable.getSize() == numberOfRooms)
					 		 {
						 		System.out.println("\nSorry... Hotel is full");
						 		break;
					 		 }
					 		 else
					 		 {
					 			 int age = Utility.getIntegerValue("Enter age of guest : ");
					 			 String name = Utility.getStringInput("Enter name of guest :");
					 			 objectHashTable.insert(age , name ); 
					 		 }
					 		 break;  
					 		 
					 case 2 :objectHashTable.makeEmpty();
					 		 System.out.println("Hotel is free\n");
					 		 break;
					 	
					 case 3 :System.exit(0);
					 		 break;
					 		 
					 default :System.out.println("Wrong Entry \n ");
					 		  break;
				}
					 
				/* Display hash table */
				objectHashTable.printRoomsAlloted();
				System.out.println("\n\nHash table view :");
				objectHashTable.printHashTable();		  
		} 
	}
}