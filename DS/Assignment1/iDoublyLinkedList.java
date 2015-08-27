
public interface iDoublyLinkedList<T>
{
	void insertAtStart(T value) ;
	void insertAtEnd(T value) ;
	void insertAtposition(T value , int position);
	boolean deleteAtposition(int position);
	boolean deleteByValue(T item);
	void reverseLinkedList() ;
	void sortLinkedList();
	void display();
}
