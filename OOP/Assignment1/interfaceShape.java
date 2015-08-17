import java.util.Scanner;
/*Interface shape implemented by circle and square classes
 * @parul joshi
 */
interface Shape 
{
	String draw();
	double getArea();
}

class Circle implements Shape
{
	//Radius stores radius of a user.
	private int radius;
	private double pi=3.14;
	
	//Constructor of the class.
	public Circle(int radius)
	{
		this.radius=radius;
	}
	
	//Returns the message. 
	public String draw()
	{
		return "In Circle";
	}
	
	//Calculates the area of circle.
	public double getArea()
	{
		double Area=pi*radius*radius;
		return Area;
	}
}

class Square implements Shape 
{
	//Side stores the side of square. 
	private int side;
	
	//Constructor of the class.
	public Square(int side)
	{
		this.side=side;
	}
	
	//Returns the message. 
	public String draw()
	{
		return "In Square";
	}
	
	//Calculates the area of square.
	public double getArea()
	{
		double area=side*side;
		return area;
	}
}

public class interfaceShape 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int radius,side;
		
		//Takes input from the user
		radius=Utility.GetInput("Enter the radius of circle");
		Shape circleShape=new Circle(radius);
		interfaceShape object=new interfaceShape();
		
		//Object of class is made with input parameter.
		object.printShape(circleShape);

		//Takes input from the user
		side=Utility.GetInput("Enter the side of square");
				
		//Object of class is made with input parameter.
		Shape squareShape=new Square(side);
		object.printShape(squareShape);
	}	

	//used to call the function of the class whose object is passed
	void printShape(Shape shapeObject)
	{
		System.out.println(shapeObject.draw());
		System.out.println("Area is : "+shapeObject.getArea());
	}
}