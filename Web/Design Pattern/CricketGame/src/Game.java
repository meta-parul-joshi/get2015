
/**
 * Game is abstract that has common methods related
 * to all variants of cricket
 * @author Parul
 * Date Created : 22/10/2015
 */
public abstract class Game {
	
	/** Method to initialize a game */
	public void initialize() 
	{
		System.out.println("Game is ready to Play");
	}
	
	/** Abstract method to start playing */
	public abstract void startPlay();
	
	/** Abstract method to end playing */
	public void endPlay() {
		System.out.println("End of Game");
	}
	
	/** This method invokes all the methods of the Game class */
	public void play()
	{
		initialize();
		startPlay();
		endPlay();
	}
}
