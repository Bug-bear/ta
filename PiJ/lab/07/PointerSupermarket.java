/**
*	Linked list version of Supermarket
*/
public class PointerSupermarket implements PersonQueue {
	private Person head;
	private Person tail;
	
	public PointerSupermarket(){
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
		Person ret = head;
		head = head.getNext();
		return ret;
	}
	
	public void addPerson(Person p){
		insert(p);
		System.out.println("Customer " + p.getID() + "at the age of " + p.getAge() + " enters the market");
	}
	
	public void servePerson(){
		Person customer = retrieve();
		if(customer != null){
			System.out.println("Customer " + customer.getID() + " is being served");
		} else{
			System.out.println("No one is here");
		}
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
		PointerSupermarket Waitjack = new PointerSupermarket();
		for(int i=1; i<10; i++){
			Waitjack.addPerson(new Person(i,50-i));
		}
		Waitjack.checkQueue();
		Waitjack.servePerson();
		Waitjack.checkQueue();
	}
}