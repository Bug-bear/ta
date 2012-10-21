/**
*	Array list version of Supermarket
*/
public class ArrayUnfairSupermarketSimple implements PersonQueue {
	private Person[] customerArray;
    private int size;
    private static int INITIAL_ARRAY_SIZE = 5;
	
	public ArrayUnfairSupermarketSimple(){
		this.customerArray = new Person[INITIAL_ARRAY_SIZE];
		this.size = 0;
	}
	
	public void insert(Person person){	
		this.customerArray[size] = person;
		size++;
	}
	
	public Person retrieve(){
		size--;
		int pos = getOldest();
		Person ret = customerArray[pos];
		for(int i=pos; i<size; i++){
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
		System.out.println("Customer " + p.getID() + "at the age of " + p.getAge() + " enters the market");
	}
	
	public void servePerson(){
		if(isEmpty()){
			System.out.println("No one to be served");
			return;
		}
		Person customer = retrieve();
		System.out.println("Customer " + customer.getID() + " at the age of " + customer.getAge() + " is being served");
	}	
	
	private boolean isEmpty() {
		return this.size == 0;
	}
	
	private int getOldest(){
		int maxAge = this.customerArray[0].getAge();
		int pos = 0;
		for(int i=1; i<size; i++){
			if(maxAge < customerArray[i].getAge()){
				maxAge = customerArray[i].getAge();
				pos = i;
			}
		}
		return pos;
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
		ArrayUnfairSupermarketSimple adsa = new ArrayUnfairSupermarketSimple();
		adsa.addPerson(new Person(1,50));
		adsa.addPerson(new Person(2,51));
		adsa.addPerson(new Person(3,23));
		adsa.addPerson(new Person(4,31));
		adsa.addPerson(new Person(5,44));
		
		adsa.checkQueue();
		adsa.servePerson();
		adsa.checkQueue();
		adsa.servePerson();
		adsa.checkQueue();
		adsa.servePerson();
		adsa.checkQueue();
	}
}