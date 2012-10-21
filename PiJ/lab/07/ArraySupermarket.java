/**
*	Array list version of Supermarket
*/
public class ArraySupermarket implements PersonQueue {
	private Person[] customerArray;
    private int size;
    private static int INITIAL_ARRAY_SIZE = 5;
	
	public ArraySupermarket(){
		this.customerArray = new Person[INITIAL_ARRAY_SIZE];
		this.size = 0;
	}
	
	public void insert(Person person){	
		this.customerArray[size] = person;
		size++;
	}
	
	public Person retrieve(){
		size--;
		Person ret = customerArray[0];
		for(int i=0; i<size; i++){
			customerArray[i] = customerArray[i+1];
		}
		customerArray[size] = null;
		return ret;
	}
	
	public void addPerson(Person p){
		if(isAlmostFull()){
			reserveMoreMemory();
		}
		insert(p);
		System.out.println("Customer " + p.getID() + " enters the market");
	}
	
	public void servePerson(){
		if(isEmpty()){
			System.out.println("No one to be served");
			return;
		}
		System.out.println("Customer " + retrieve().getID() + " is being served");
	}	
	
	public boolean isEmpty() {
		return this.size == 0;
	}

    private boolean isAlmostFull() {
	  return (customerArray.length - size < 1);
    }

    private void reserveMoreMemory() {
	  Person[] biggerArray = new Person[size*2];
	  for (int i = 0; i < size; i++) {
		biggerArray[i] = this.customerArray[i];
	  }
	  this.customerArray = biggerArray;
    }	
	
	
	//my helper
	public void checkQueue(){
		System.out.print("There are customer:");
		for(int i=0; i<this.size; i++){
			System.out.print(" " + customerArray[i].getID() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		ArraySupermarket adsa = new ArraySupermarket();
		for(int i=1; i<10; i++){
			adsa.addPerson(new Person(i));
		}
		adsa.checkQueue();
		adsa.servePerson();
		adsa.checkQueue();
	}
}