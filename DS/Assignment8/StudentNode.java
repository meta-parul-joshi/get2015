
public class StudentNode 
{
	
	StudentNode leftChild;
	StudentNode rightChild;
	public Student item;
	
	public StudentNode(int rollnumber, String name)
	{ 
		item = new Student(rollnumber,name);
	}
		
	public StudentNode getLeftChild() 
	{
		return leftChild;
	}
	
	public Student getItem() {
		return item;
	}

	public void setItem(Student item) {
		this.item = item;
	}

	public void setLeftChild(StudentNode leftChild) 
	{
		this.leftChild = leftChild;
	}
	
	public StudentNode getRightChild() 
	{
		return rightChild;
	}
	
	public void setRightChild(StudentNode rightChild) 
	{
		this.rightChild = rightChild;
	}
	
	public String toString()
	{
		return item.getStudentName()+"\t\t"+item.getRollnumber() ;
	}
}

