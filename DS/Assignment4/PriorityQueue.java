/* Class PriorityQueue */
public class PriorityQueue
{
    private Job[] heap; 
    private int heapSize, length;
 
    /** Constructor **/
    public PriorityQueue(int length)
    {    
        this.length = length + 1;
        heap = new Job[this.length];
        heapSize = 0;
    }
    
    /* function to check if empty */
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
     
    public boolean isFull()
    {
        return heapSize == length - 1;
    }
    /* function to insert Job */
    public void insert( int priority)
    {
        Job newJob = new Job( priority);
        heapSize = heapSize+1;
        heap[heapSize] = newJob;
        int index = heapSize;
        int parent = index /2;
        while (index != 1 && newJob.getPriority() > heap[parent].getPriority())
        {
            heap[index] = heap[parent];
            index =index/2;
            parent = index/2;
        }
        
        heap[index] = newJob;    
    }
  
    /* function to remove Job */
    public Job remove()
    {
        int parent, child;
        Job item, temp;
      
        item = heap[1];
        temp = heap[heapSize--];
 
        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].getPriority() < heap[child + 1].getPriority())
            {
            	child++;
            }
            
            if (temp.priority >= heap[child].priority)
            {
            	break;
            }
 
            heap[parent] = heap[child];
            parent = child;
            child =  child*2;
        }
        
        heap[parent] = temp;
 
        return item;
    }
}