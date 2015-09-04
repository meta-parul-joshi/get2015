import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*Class perform sorting using tree sort.
 * @author parul.
 * **/
public class SortingStudentDataUsingTreeSort 
{
	/*@param root points first node of tree.
	 * @param studentList stores list of students.
	 * @param numberOftudents stores number of student in school.
	 *  */
	public StudentNode root;
	List<StudentNode> studentList = new ArrayList<StudentNode>();
	int numberOfStudent;
	
	/*Constructor.*/
    public SortingStudentDataUsingTreeSort()
    {
    	root = null;
    }
    
	/*Function to get number of student*/
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	
	/*Function to set number of students.
	 * it takes numberOfStudent as key parameter.
	 * */
	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

    /*Function to get root of tree.*/
    public StudentNode returnRoot()
    {
        return root;
    }
    
    /*Function to insert node in tree.
     * It takes a StudentNode as key parameter.
     * if tree is empty it puts node as root node otherwise it checks roll of of new node to root node
     * if its is less than root it moves to left and check empty condition if true place node or move again.
     * If roll number of new node is larger than root it moves in right.*/
    public void insert(StudentNode objectOfStudent)
    {
        StudentNode newStudentNode = new StudentNode(objectOfStudent.student.rollnumber,objectOfStudent.student.studentName);
        if(root==null)
        {
        	root = newStudentNode;
        }
        else
        {
            StudentNode current = root;
            StudentNode parent;
            while(true)
            {
                parent = current;
                if(objectOfStudent.student.getRollnumber() == current.student.getRollnumber())
                {
                	return;
                }
                else if(objectOfStudent.student.getRollnumber() < current.student.getRollnumber())
                {
                    current = current.leftChild;
                    if(current == null)
                    {
                        parent.leftChild = newStudentNode;
                        return;
                    }
                }
                else
                {
                    current = current.rightChild;
                    if(current == null)
                    {
                        parent.rightChild = newStudentNode;
                        return;
                    }
                }
            }
        }
    } 
     
    /*Function traverse tree in inOrder.
     * It takes root node of tree as key parameter.*/
    public void inOrder(StudentNode root)
    {
        Stack<StudentNode> objectStack = new Stack<StudentNode>();
        
        StudentNode studentNode = root;
        while(!objectStack.isEmpty() || studentNode != null)
        {
        	if(studentNode != null)
        	{
        		objectStack.push(studentNode);
        		studentNode = studentNode.leftChild;
        	}
        	else
        	{
        		StudentNode newNode = objectStack.pop();
        		studentList.add(newNode);
        		studentNode = newNode.getRightChild();
        	}
        }
    }
    
    /*Function to print Tree.*/
    public void printStudentData()
    {
    	System.out.println("Student name\tRoll number");
    	for(StudentNode student : studentList)
    	{
    		System.out.println(student);
    	}
    	studentList.clear();
    }
    
 }
