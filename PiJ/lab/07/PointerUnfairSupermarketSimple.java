/**
*	Linked list version of Supermarket
*/
public class PointerUnfairSupermarketSimple implements PersonQueue {
	private Person head;
	private Person tail;
	
	public PointerUnfairSupermarketSimple(){
		head = null;
		tail = null;
	}
	
	public void insert(Person person){
		if(head == null){
			head = tail = person;
		} else{
			tail.setNext(person);
		}
		tail = person;
	}
	
	public Person retrieve(){
		if(head == null){
			return null;
		}
		int maxAge = head.getAge();
		Person preRet = null; //the one before oldest person
		Person ret = head;
		Person p = head;
		while(p.getNext() != null){
			if(maxAge < p.getNext().getAge()){
				maxAge = p.getNext().getAge();
				preRet = p;
			}
			p = p.getNext();
		}
		if(preRet == null){
			ret = head;
			head = head.getNext();
		} else{
			ret = preRet.getNext();
			preRet.setNext(preRet.getNext().getNext());
		}
		return ret;
	}
	
	public void addPerson(Person p){
		insert(p);
		System.out.println("Customer " + p.getID() + "at the age of " + p.getAge() + " enters the market");
	}
	
	public void servePerson(){
		Person customer = retrieve();
		if(customer != null){
			System.out.println("Customer " + customer.getID() + "at the age of " + customer.getAge() + " is being served");
		} else{
			System.out.println("No one is here");
		}
	}	
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	//my helper
	public void checkQueue(){
		Person p = head;
		System.out.print("There are customer:");
		while(p != null){
			System.out.print(" " + p.getID() + " ");
			p = p.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		PointerUnfairSupermarketSimple Waitjack = new PointerUnfairSupermarketSimple();
		Waitjack.addPerson(new Person(1,51));
		Waitjack.addPerson(new Person(2,50));
		Waitjack.addPerson(new Person(3,23));
		Waitjack.addPerson(new Person(4,31));
		Waitjack.addPerson(new Person(5,44));
		
		Waitjack.checkQueue();
		//System.out.println(Waitjack.isEmpty());
		Waitjack.servePerson();
		//System.out.println(Waitjack.isEmpty());
		Waitjack.checkQueue();
		Waitjack.servePerson();
		Waitjack.checkQueue();
		Waitjack.servePerson();
		Waitjack.checkQueue();
	}
}