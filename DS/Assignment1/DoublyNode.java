
public class DoublyNode<T> 
{
	DoublyNode<T> front;
	DoublyNode<T> back;
	T item;
	public DoublyNode()
	{
	
	}
	
	public DoublyNode(T data)
	{
		front = null;
		back = null;
		item = data;
	}

	public DoublyNode<T> getFront() {
		return front;
	}

	public void setFront(DoublyNode<T> front) {
		this.front = front;
	}

	public DoublyNode<T> getBack() {
		return back;
	}

	public void setBack(DoublyNode<T> back) {
		this.back = back;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}
