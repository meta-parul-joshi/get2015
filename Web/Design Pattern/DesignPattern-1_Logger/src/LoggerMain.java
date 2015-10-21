/**  This class is Main class for MyLogger class.
 *  
 */

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Parul
 */

public class LoggerMain {

	/** Main Function */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			/* This code will generate ArithmeticException */
			int c = 10/0;
		}
		catch(ArithmeticException e) {
			/* Getting instance of Logger class */
			MyLogger myLogger = MyLogger.getInstance();
			
			/* This code will transfer stack-trace of exception
			 * to the doLogging() method to MyLogger class in
			 * String format
			 */
			Writer sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			myLogger.doLogging(sw.toString());
		}
		
		int[] array = new int[3];
		try {
			/* This code will generate ArrayIndexOutOfBoundsException */
			array[7] = 8;
		} catch(ArrayIndexOutOfBoundsException e) {
			/* Getting instance of Logger class */
			MyLogger myLogger = MyLogger.getInstance();
			
			/* This code will transfer stack-trace of exception
			 * to the doLogging() method to MyLogger class in
			 * String format
			 */
			Writer sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			myLogger.doLogging(sw.toString());
		}
	}
}
