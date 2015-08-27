public class Node<T>
{
	T item;
	Node<T> link;
	
	public Node()
	{
		
	}
	
    /*  Constructor  */
	public Node(T data)
	{
		item = data;
		link = null;
	}
	
	/*  Function to get value to current Node  */
	public T getItem() 
	{
		return item;
	}
	
	/*  Function to set value to current Node  */
	public void setItem(T item) 
	{
		this.item = item;
	}
	
	/*  Function to get link to next node  */
	public Node<T> getLink() 
	{
		return link;
	}
	
	/*  Function to set link to next node  */
	public void setLink(Node<T> link) 
	{
		this.link = link;
	}
}
