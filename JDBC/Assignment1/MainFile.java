import java.text.ParseException;
import SortingSystem.Utility;


public class MainFile 
{
	public static void main(String[] args) throws ParseException 
	{
		System.out.println("Library Information System");
		LibraryInformationSystemHelper objectOfInformationSystemHelper = new LibraryInformationSystemHelper();
		while(true)
		{
			System.out.println("\n1. Want to know books publishe by author ");
			System.out.println("2. Want to issue book");
			int choice = Utility.getIntegerValue("\nEnter your choice :");
			switch(choice)
			{
				case 1 :String authorName = Utility.getStringInput("Enter author name");
						boolean flag = objectOfInformationSystemHelper.checkAuthorExist(authorName);
						if(!flag)
						{
							System.out.println("There is no book of this author in library");
						}
						break;
				
				case 2:String bookName = Utility.getStringInput("Enter name of book to be isssued");
						flag = objectOfInformationSystemHelper.checkBookInLibrary(bookName);
						if(flag)
						{	
							System.out.println("\nEnter member details :");
							Members objMembers = new Members();			
							String name = Utility.getStringInput("Enter name");
							objMembers.setMemberName(name);
							String addressLine1 = Utility.getStringInput("Enter address line 1");
							objMembers.setAddressLine1(addressLine1);
							String addressLine2 = Utility.getStringInput("Enter address line 2");
							objMembers.setAddressLine2(addressLine2);
							Character category = Utility.getCharacterInput("Enter category");
							objMembers.setCategory(category);
							objectOfInformationSystemHelper.bookIssuedOrNot(objMembers, bookName);
							System.out.println("Book issued successfully");
						}
						else
						{
							System.out.println("Book is not available in library");
						}	
						break;
						
					default : System.out.println("Wrong Choice...!!");
							break;
			}
		}
	}
}
