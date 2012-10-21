public class Person{
	private int ID;
	private int Age;
    private Person next;
	
	public Person(int id, int age){
		this.ID = id;
		this.Age = age;
	}
	
	public int getID() {
	  return this.ID;		
    }	
	
	public int getAge() {
	  return this.Age;		
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