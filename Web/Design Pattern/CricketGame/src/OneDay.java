
/**
 * This class information specific to One day cricket
 * @author Parul
 * Date Created : 22/10/2015
 */
public class OneDay extends Game{

	/** Method for start playing */
	@Override
	public void startPlay() 
	{
		System.out.println("Each Team will play for at most 50 overs\n"
				+ "The team that will make more runs will win");
	}
}
