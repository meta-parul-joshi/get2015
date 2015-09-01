 
/** class Job **/
class Job
{
    String jobName;
    int priority;
 
    /** Constructor **/
    public Job( int priority)
    {
        this.priority = priority; 
    }
    
    /** toString() **/
    public String toString() 
    {
        return "\nPriority : "+ priority;
    }
    
    /**Get name of job**/
	public String getJobName() {
		return jobName;
	}
	
	 /**Set name of job**/
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	 /**Get priority of job**/
	public int getPriority() {
		return priority;
	}
	
	/**Set priority of job**/
	public void setPriority(int priority) {
		this.priority = priority;
	}
    
}