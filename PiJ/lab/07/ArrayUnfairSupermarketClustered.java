/**
*	Array list version of Supermarket
*/
public class ArrayUnfairSupermarketClustered implements PersonQueue {
	private Person[] customerArray;
    private int size;
    private static int INITIAL_ARRAY_SIZE = 5;
	
	public ArrayUnfairSupermarketClustered(){
		this.customerArray = new Person[INITIAL_ARRAY_SIZE];
		this.size = 0;
	}
	
	public void insert(Person person){	
		this.customerArray[size] = person;
		size++;
	}
	
	public Person retrieve(){
		size--;
		int pos18 = -1;
		Person ret = null;
		// 65+
		for(int i=0; i<=size; i++){
			if(customerArray[i].getAge() > 65){
				ret = customerArray[i];
				rearrange(i);
				return ret;
			} else if(customerArray[i].getAge() > 18 && pos18 == -1){
				pos18 = i;
			}
		}	
		// 18+
		if(pos18 != -1){
			ret = customerArray[pos18];
			rearrange(pos18);
			return ret;
		}
		// 18-
		ret = customerArray[0];
		rearrange(0);
		return ret;
	}
	
	private void rearrange(int pos){
		for(int i=pos; i<this.size; i++){
			customerArray[i] = customerArray[i+1];
		}
		customerArray[size] = null;	
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
		ArrayUnfairSupermarketClustered adsa = new ArrayUnfairSupermarketClustered();
		adsa.addPerson(new Person(1,50));
		adsa.addPerson(new Person(2,66));
		adsa.addPerson(new Person(3,8));
		adsa.addPerson(new Person(4,44));
		adsa.addPerson(new Person(5,31));
		
		adsa.checkQueue();
		adsa.servePerson();
		adsa.checkQueue();
		adsa.servePerson();
		adsa.checkQueue();
		adsa.servePerson();
		adsa.checkQueue();
		adsa.servePerson();
		adsa.checkQueue();
	}
}