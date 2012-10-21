public class Person{
	public int ID;
    private Person next;
	
	public Person(int id){
		this.ID = id;
	}
	
	public int getID() {
	  return this.ID;		
    }	
	
    /**
     * Set the next node to point to the given node
     */
    public void setNext(Person p) {
	  next = p;		
    }

    /**
     * Set the next node to point to the given node
     */
    public Person getNext() {
	  return next;		
    }	
}