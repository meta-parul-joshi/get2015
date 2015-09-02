public class CountUniqueCharactersInString
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Unique character in String\n");
		CountUniqueCharacters obj = new CountUniqueCharacters();
		
		while(true)
		{
			/*Show menu to user.*/
			System.out.println("\n1). Count unique characters ");
			System.out.println("2). Exit");
			
			/*Input from console.*/
			int choice = Utility.getIntegerValue("Enter your choice");
			switch(choice)
			{
			
			case 1: String inputString = Utility.getStringInput("Enter string in which unique characters are to calculated");
					if(inputString.equals(""))
					{	
						System.out.println("Empty String");
					}
					else
					{
						int numberOfUniqueCharacter = obj.countUniqueCharacterInString(inputString);
						System.out.println("Number of unique characters-"+numberOfUniqueCharacter);
					}
					break;
					
					/*Exit*/
			case 2: System.out.println("System Exited");
					System.exit(0);
					break;
					
			default:System.out.println("Wrong choice");
					break;
			}
		}
	}
}
