
public class ListNode 
{
	/* Data Members */
	int tag;
	Object data;
	ListNode next;
	
	/* Method to get tag value of a node */
	public int getTag()
	{
		return tag;
	}
	
	/* Method to set tag value of a node*/
	public void setTag(int tag) 
	{
		this.tag = tag;
	}
	
	/* Method to get data of a node*/
	public Object getData() 
	{
		return data;
	}
	
	/* Method to set data of a node*/
	public void setData(Object data) 
	{
		this.data = data;
	}
	
	/* Method to get next of a node*/
	public ListNode getNext() 
	{
		return next;
	}
	
	/* Method to set next of a node*/
	public void setNext(ListNode next)
	{
		this.next = next;
	}
	
	@Override
	public String toString() 
	{
		return "ListNode [tag=" + tag + ", data=" + data + ", next=" + next
				+ "]";
	}
	
}
