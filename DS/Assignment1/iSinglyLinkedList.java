
public interface iSinglyLinkedList<T> 
{
	boolean addNodeAtLast(T data);
	boolean addNodeAtParticularLocation(T data, int location) ;
	boolean removeFromIndex(int index) ;
	boolean removeByValue(T item);
	 T retrivingItem(int index) ;
	 void sortingOfLinkedlist();
	 void reverseLinkedList();
	 void printLinkedList();
}
