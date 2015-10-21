package ProjectCompany.Model;

/** Class to create Developers */

/**
 * @author Parul
 */
public class Developer extends Engineer {

	/** Protected parameterized constructor to create Developer */
	protected Developer(String name, EngineerType role) {
		super(name , role);
	}
	
	/** Default constructor */
	protected Developer() {
		
	}

}
