/*Class to stores node information of tree.
 * @author parul.
 * */
public class StudentNode 
{
	/*
	 * @param leftChild points left child of node
	 * @param rightChild points right child of node
	 * @param student is object of class student to access methods of Student class 
	 * */
	StudentNode leftChild;
	StudentNode rightChild;
	public Student student;
	
	/*Constructor.*/
	public StudentNode(int rollnumber, String name)
	{ 
		student = new Student(rollnumber,name);
	}
		
	/*Function to get left child of node.*/
	public StudentNode getLeftChild() 
	{
		return leftChild;
	}
	
	/*Function to get student object.*/
	public Student getstudent() {
		return student;
	}
	
	/*Function to set student object.
	 * It takes student object as key parameter.
	 * */
	public void setstudent(Student student) {
		this.student = student;
	}
	
	/*Function to set left child of node.
	 * It takes leftChild as key parameter.*/
	public void setLeftChild(StudentNode leftChild) 
	{
		this.leftChild = leftChild;
	}
	
	/*Functon to get right child of node.*/
	public StudentNode getRightChild() 
	{
		return rightChild;
	}
	
	/*Function to set right child of node.
	 * It takes rightChild as key parameter. */
	public void setRightChild(StudentNode rightChild) 
	{
		this.rightChild = rightChild;
	}
	
	/*Prints object.*/
	public String toString()
	{
		return student.getStudentName()+"\t\t"+student.getRollnumber() ;
	}
}

