
public interface iArraylist
{
	void addValueInList(Object obj);
	void addValueAtGivenLocation( Object item, int location );
	int findFirstIndexOfItem ( Object item );
	void removeItemFromGivenLocation (int location);
	void removeItemFromList (Object item) ;
	void reverseArrayList();
	void sortArrayList();
	void clearArrayList();
	Object getItemFromList(int location) ;
	void printArrayList();
}
