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

    public SortingStudentDataUsingTreeSort()
    {
    	root = null;
    }
    
    public StudentNode returnRoot()
    {
        return root;
    }
    
    public void insert(StudentNode objectOfStudent)
    {
        StudentNode newStudentNode = new StudentNode(objectOfStudent.item.rollnumber,objectOfStudent.item.studentName);
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
                if(objectOfStudent.item.getRollnumber() == current.item.getRollnumber())
                {
                	return;
                }
                else if(objectOfStudent.item.getRollnumber() < current.item.getRollnumber())
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
    
    public void printStudentData()
    {
    	System.out.println("Student name\tRoll number");
    	for(StudentNode student : studentList)
    	{
    		System.out.println(student);
    	}
    }
    
 }
