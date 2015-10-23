import Helper.Chaining;
import ProjectCompany.Utility.Utility;
import model.HRManager;
import model.LeaveApprover;
import model.Mentor;
import model.SeniorMentor;
/**
 * Main Class
 * @author Parul
 * Date created : 22/10/2015
 */

public class Main {

	public static void main(String args[]) 
	{
		System.out.println("HRM Leave Approval");
		
		/* Creating objects of different Leave Approvers*/
		LeaveApprover mentor = new Mentor();
		LeaveApprover seniorrMentor = new SeniorMentor();
		LeaveApprover hrManager = new HRManager();
		
		/* setting chain of responsibilities among the approvers */
		Chaining.setChaining(mentor, seniorrMentor, hrManager);
		
		int numberOfLeaves;
		while(true)
		{
			System.out.println("\n1.Want leaves from ofice");
			System.out.println("2 Exit");
			int choice= Utility.getChoice("\nEnter Choice");
			switch(choice)
			{
				/* If choice is 1, then ask user for number of leaves and process request. */
				case 1:
				{
					/* Inputting number of leaves */
					numberOfLeaves = Utility.getChoice("Enter Number of leaves(greater than 0)");
					
					/* processing request for leave */
					mentor.processRequest(numberOfLeaves);
					break;
				}
				
				/* If choice is 2, then Exit from the System */
				case 2:
				{ 
					System.out.println("System Exited");
					System.exit(0);
					break;
				}
				
				default :
				{ 
					System.out.println("Enter Correct Choice");
				}
			}		
		}
	}
}
