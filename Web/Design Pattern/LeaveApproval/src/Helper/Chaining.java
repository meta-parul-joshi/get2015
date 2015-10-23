package Helper;

import model.LeaveApprover;
/**
 * 
 * @author Parul
 *
 */

public class Chaining 
{
	
	/** This method perform chaining
	 * 
	 * @param mentor : Object of Mentor
	 * @param srMentor : Object of SeniorMentor
	 * @param hrManager : Object of HRManager
	 */
	public static void setChaining(LeaveApprover mentor, LeaveApprover seniorrMentor, LeaveApprover hrManager) 
	{
		mentor.setSuccessor(seniorrMentor);
		seniorrMentor.setSuccessor(hrManager);
	}
}
