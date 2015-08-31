class Node<T>
{
    T value;
    Node<T> link;
 
    /*  Constructor  */
    public Node(T value)
    {
        this.value = value;
        link = null;
    }   
    
    /*  Function to set link to next Node  */
    public void setLink(Node<T> n)
    {
        link = n;
    }    
    /*  Function to set value to current Node  */
    public void setvalue(T d)
    {
        value = d;
    }  
    
    /*  Function to get link to next node  */
    public Node<T> getLink()
    {
        return link;
    }  
    
    /*  Function to get value from current Node  */
    public T getvalue()
    {
        return value;
    }
}
