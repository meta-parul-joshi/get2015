/** Logger class to log the exceptions 
 * It is a singleton class so only one instance can be
 * created
 * */
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Parul
 */
public class MyLogger {
	
	/* defining object of Logger class */
	private static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());
	/* object initialization of MyLogger class with null */
	private static MyLogger objectOfMyLogger = null;
	
	/* Handler object declaration */
	private Handler fileHandler  = null;
	
	/* private constructor of MyLogger class to create object
	 * and initialize object of FileHandler
	 */
	private MyLogger()
	{
		try {
			/* initialization of fileHandler with a file */
			fileHandler  = new FileHandler("./exceptionlog4.log", true);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Method to perform logging of exceptions 
	 * 
	 * @param logException : stack-trace of exception in String format
	 */
	public void doLogging(String logException)
	{
		/* setting levels of fileHandler, LOGGER */
		fileHandler.setLevel(Level.ALL);
		LOGGER.setLevel(Level.ALL);
		
		/* adding fileHandler to LOGGER */
		LOGGER.addHandler(fileHandler);
		
		/* setting format of log file to Simple Format
		 * by default XML format is used
		 */
		fileHandler.setFormatter(new SimpleFormatter());
		
		/* Logging the exceptions to log file */ 
		LOGGER.log(Level.FINE, logException);
		
		/* removing file handler from the LOGGER */ 
		LOGGER.removeHandler(fileHandler);
	}
	
	/** Method to get the instance of MyLogger class
	 * 
	 * @return instance of MyLogger class
	 */
	public static MyLogger getInstance()
	{
		/* if object is null then create object otherwise return the 
		 * earlier created instance
		 */
		if(objectOfMyLogger == null) 
		{
			/* synchronized is used for multi-threading */
			synchronized (MyLogger.class) 
			{
				if(objectOfMyLogger == null) 
				{
					/* Creating single instance of MyLogger class */
					objectOfMyLogger = new MyLogger();
				}
			}
		}
		return objectOfMyLogger;
	}
}
