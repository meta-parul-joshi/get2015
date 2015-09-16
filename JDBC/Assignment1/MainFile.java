import java.text.ParseException;
import SortingSystem.Utility;


public class MainFile 
{
	public static void main(String[] args) throws ParseException 
	{
		System.out.println("Library Information System");
		
		/*Initialize object of class to 
		 * access methods of class.*/
		LibraryInformationSystemHelper objectOfInformationSystemHelper = new LibraryInformationSystemHelper();
		while(true)
		{
			System.out.println("\n1. Want to know books published by author ");
			System.out.println("2. Want to issue book");
			System.out.println("3. Remove books from library that aer not issued since last one year");
			System.out.println("4.Exit");
			
			/*Input from user.*/
			int choice = Utility.getIntegerValue("\nEnter your choice :");
			switch(choice)
			{
						/*Take input author name from user and displays books written by author.*/
				case 1 :String authorName = Utility.getStringInput("Enter author name");
						List<Title> titleList=new ArrayList<Title>();
						titleList = objectOfInformationSystemHelper.booksPublishedByAuthor(authorName);
						printListOFBooks(titleList);
						break;
						
						/*Take book name and member name as input and display whether book issued or not*/
				case 2:String bookName = Utility.getStringInput("Enter name of book to be isssued");
						System.out.println("\nEnter member details :");		
						String name = Utility.getStringInput("Enter member name");
						boolean flag = objectOfInformationSystemHelper.bookIssuedOrNot( bookName,name);	
						if(flag == true)
						{
							System.out.println("Book issued successfully");
						}
						else
						{
							System.out.println("Book not issued");
						}	
						break;
						
						/*Remove books from library that aer not issued since last one yea*/
				case 3: int numberOfBooksDeleted = objectOfInformationSystemHelper.removeBooksFromThatAreNotIssuedSinceLasttYear();
						System.out.println("Number of books deleted - " + numberOfBooksDeleted);
						break;
						
						/*Exit.*/
				case 4 : System.out.println("System exited ");
						System.exit(0);
						break;
						
						/*Default case.*/
				default : System.out.println("Wrong Choice...!!");
							break;
			}
		}
	}
	
	/*Function to print number of books written by author.
	 * It takes titleList as key parameter.
	 * */
	static void printListOFBooks(List<Title> titleList)
	{
		System.out.println("Title id\tTitle name\tSubject id\tPublisher id");
		for(Title s : titleList)
		{
			System.out.println(s.getTitleId()+"\t\t"+s.getTitleName()
					+"\t"+s.getSubjectId()+"\t"+s.getPublisherId());
		}
	}
}
