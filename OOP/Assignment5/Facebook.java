

import java.awt.DisplayMode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Facebook {

	void enterEntityDetailsInFile ( String entityDetails )
	{
		FileWriter  fw = null;
		try
		{	
			System.out.println(entityDetails);
			fw = new FileWriter("C://Users/Parul/workspace/Assignment8/src/EntityDetails.txt", true);  
			fw.write("\n" + entityDetails);
			fw.close();
		}
		catch( Exception ex )
		{
			System.out.println("test");
			ex.printStackTrace();
		}
	}
	
	
	static List<Entity> loadEntityDetailsFromFile ( List<Entity> nodeList, Person personObj, Organization organizationObj, Graph graphObj )
	{
		InputStream in = null;
		BufferedReader reader = null;
		int index = 0;
		
		try
		{	
		    File file = new File("C://Users/Parul/workspace/Assignment8/src/EntityDetails.txt");
		    FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr);
		    String line;
		    while((line = br.readLine()) != null)
		    {
		    	String arr[] = line.split(",");
		    		System.out.println(arr[5]);
		    	if ( arr[5].equals("person"))
		       	{
		    		personObj = new Person();
		       		personObj.setName(arr[0]);   
		       		personObj.setEmail(arr[1]);
					personObj.setPhoneNumber(arr[2]);
					personObj.setSchool(arr[3]);
					personObj.setInterest(arr[4]);
					
					nodeList = graphObj.addNode(personObj);
		       	}
		       	else if ( arr[5].equals("org"))
		       	{
		       		organizationObj = new Organization();
		       		organizationObj.setName(arr[0]);
		       		organizationObj.setEmail(arr[1]);
		       		organizationObj.setPhoneNumber(arr[2]);
		       		organizationObj.setCourses(arr[3]);
		       		organizationObj.setPlacement(arr[4]);
					
					nodeList = graphObj.addNode(organizationObj);
		       	}
		    }
		    br.close();
		    fr.close();
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}	    
		    
		    
		return nodeList;
	}
	
	public static void main(String[] args) throws IOException {
		
		List<Entity> nodeList = new ArrayList<Entity>();
		Facebook fbObj = new Facebook();
		Graph graphObj = new Graph ();
		SocialNetwork socialNetworkObj = new SocialNetwork();
		Person personObj = null;
		Organization organizationObj = null;
		HashMap entityFriendship = new HashMap();
		Scanner sc = new Scanner(System.in);
		
		nodeList = loadEntityDetailsFromFile ( nodeList, personObj, organizationObj, graphObj);
				
		int choice = 0;
		while(true)
		{
			if ( choice != 2 )
			{
				System.out.println("\nMenu : ");
				System.out.println("1). Sign Up");
				System.out.println("2). Log In");
				System.out.println("3). Exit");
				
				choice = sc.nextInt();
			}
			switch(choice)
			{
				case 1: System.out.println("\nSign Up : ");
						System.out.println("1). Person");
						System.out.println("2). Organisation");
						int entityChoice = sc.nextInt();
						if(entityChoice == 1)
						{
							personObj = new Person ();
							
							boolean bool = true;
							System.out.println("\nEnter your email");
							String email = sc.next();
							for ( Entity entity : nodeList )
							{
								if ( entity.email.equals(email))
								{
									System.out.println("\nYour account already exist");
									bool = false; 
									break;
								}
							}
							
							if (bool)
							{
								personObj.setEmail(email);	
								System.out.println("\nEnter your name");
								personObj.setName(sc.next());
								System.out.println("\nEnter your phone number");
								personObj.setPhoneNumber(sc.next());
								System.out.println("\nEnter your school");
								personObj.setSchool(sc.next());
								System.out.println("\nEnter your interest");
								personObj.setInterest(sc.next());								
								nodeList = graphObj.addNode(personObj);								
								fbObj.enterEntityDetailsInFile( personObj.getName()+","+personObj.getEmail()+","+personObj.getPhoneNumber()
										+","+personObj.getSchool()+","+personObj.getInterest()+",person\n");
							}
							choice = 2;
						}
						else if (entityChoice == 2)
						{
							organizationObj = new Organization();
							
							boolean bool = true;
							System.out.println("\nEnter your email");
							String email = sc.next();
							for ( Entity entity : nodeList )
							{
								if ( entity.email.equals(email))
								{
									System.out.println("\nYour account already exist");
									bool = false; 
									break;
								}
							}
							
							if (bool)
							{
								organizationObj.setEmail(email);
								
								System.out.println("\nEnter your name");
								organizationObj.setName(sc.next());
								System.out.println("\nEnter your phone number");
								organizationObj.setPhoneNumber(sc.next());
								System.out.println("\nEnter your courses");
								organizationObj.setCourses(sc.next());
								System.out.println("\nEnter your placement");
								organizationObj.setPlacement(sc.next());
								
								nodeList = graphObj.addNode(organizationObj);
								
								fbObj.enterEntityDetailsInFile(organizationObj.getName()+","+organizationObj.getEmail()+","+organizationObj.getPhoneNumber()
										+","+organizationObj.getCourses()+","+organizationObj.getPlacement()+",org\n");
							}
						}
						
						
						break;
						
				case 2: System.out.println("\nLog In\nEnter your email id : ");
						String email = sc.next();
						personObj = socialNetworkObj.entityLogIn ( email, nodeList, personObj );
						if ( personObj == null )
						{	
							System.out.println("\nYour account does not exist. Please sign up.");
							choice=1;
							break;
						}
						
						boolean flag1 = true;
						while (flag1)
						{
							System.out.println("\nMenu :");
							System.out.println("1). Add friend");
							System.out.println("2). Remove friend");
							System.out.println("3). Search friend");
							System.out.println("4). Delete account");
							System.out.println("5). Display whole social network");
							System.out.println("6). Logout");
							
							int choice1 = sc.nextInt();
							
							switch(choice1)
							{
								case 1: System.out.println("\nEnter name of person whom u want to be friends with : ");
										String friend = sc.next();
										entityFriendship = socialNetworkObj.addFriend ( personObj, friend, nodeList, entityFriendship );
										break;
							
								case 2: System.out.println("\nEnter name of person whom u want to remove from friend list : ");
										String removeFriend = sc.next();
										entityFriendship = socialNetworkObj.removeFriend ( personObj, removeFriend, nodeList, entityFriendship );
										break;
										
								case 3: System.out.println("\nEnter name of person whom u want to search : ");
										String searchUser = sc.next();
										System.out.println(socialNetworkObj.searchEntity(searchUser, nodeList));
										break;
										
								case 4: boolean flag = graphObj.deleteNode( nodeList, personObj.name, entityFriendship );
										if(flag==true)
										{	
											
											File inputFile = new File("C://Users/Parul/workspace/Assignment8/src/EntityDetails.txt");
											File tempFile = new File("C://Users/Parul/workspace/Assignment8/src/EntityDetailstmp.txt");
											BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
											BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFile));

											String lineToRemove = personObj.email;
											String currentLine;

											while((currentLine = reader1.readLine()) != null) 
											{
											    // trim newline when comparing with lineToRemove
											    String trimmedLine = currentLine.trim();
											    if(trimmedLine.contains(lineToRemove)) continue;
											    writer1.write(currentLine + System.getProperty("line.separator"));
											}
											writer1.close(); 
											reader1.close(); 
											boolean successful = tempFile.renameTo(inputFile);
											
											System.out.println("\nYour account has been successfully deleted");
											flag1 = false;
										}
										else
											System.out.println("\nSorry, no user found with this email id");
										
										break;
										
								case 5 : socialNetworkObj.displaySocialNetwork(entityFriendship);
										break;
										
								case 6: flag1 = false;
										break;
										
								default: System.out.println("\nPlease enter correct choice : ");
										 break;
									}
									
								}
								
								choice = 0;
								break;
						
				case 3: System.exit(0);
						break;
						
				default: System.out.println("\nPlease enter correct choice : ");
						break;
			}
		}
	}

}
