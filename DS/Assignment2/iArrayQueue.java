
public interface iArrayQueue 
{
	boolean isEmpty();
	boolean isFull();
	int getSize();
	int peek();
	void enqueue(int item);
	int dequeue();
	void display();
}
