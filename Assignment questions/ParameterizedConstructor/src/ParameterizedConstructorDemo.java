
public class ParameterizedConstructorDemo {
	
	public static void main(String args[]) {
		User objUser1 = new User ("Parul","parul.joshi@gmail.com");
		objUser1.setCompanyName("Metacube");
		User objUser2 = new User ("Meeanal","meenal@gmail.com");
		
		System.out.println(objUser1);
		System.out.println(objUser2);
	}
}

class User {
	private String name;
	private String email;
	private String companyName;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", companyName="
				+ companyName + "]";
	}

}
