/**
*	Linked list version of Supermarket
*/
public class PointerUnfairSupermarketClustered implements PersonQueue {
	private Person head;
	private Person tail;
	
	public PointerUnfairSupermarketClustered(){
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
		Person preRet = null; //the one before oldest person
		Person ret = head;
		Person p = head;
		Boolean plus18 = false;
		
		//65
		if(head.getAge() > 65){
			ret = head;
			head = head.getNext();
			return ret;
		} else if(head.getAge() > 18){
			plus18 = true;
		}
		while(p.getNext() != null){
			if(p.getNext().getAge() > 65){
				preRet = p;
				ret = p.getNext();
				preRet.setNext(p.getNext().getNext());
				return ret;
			} else if(!plus18 && p.getNext().getAge() > 18){
				plus18 = true;
				preRet = p;
			}
			p = p.getNext();
		}
		// by this point preRet the first 18+ or null (if !plus18 or it's the head)
		if(preRet != null){
			ret = preRet.getNext();
			preRet.setNext(preRet.getNext().getNext());
			return ret;
		}
		else{ //it's the head (whether 18+ or not does not matter)
			ret = head;
			head = head.getNext();
			return ret;
		}		
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
		PointerUnfairSupermarketClustered Waitjack = new PointerUnfairSupermarketClustered();
		Waitjack.addPerson(new Person(1,50));
		Waitjack.addPerson(new Person(2,66));
		Waitjack.addPerson(new Person(3,8));
		Waitjack.addPerson(new Person(4,44));
		Waitjack.addPerson(new Person(5,31));
		
		Waitjack.checkQueue();
		//System.out.println(Waitjack.isEmpty());
		Waitjack.servePerson();
		//System.out.println(Waitjack.isEmpty());
		Waitjack.checkQueue();
		Waitjack.servePerson();
		Waitjack.checkQueue();
		Waitjack.servePerson();
		Waitjack.checkQueue();
		Waitjack.servePerson();
		Waitjack.checkQueue();
	}
}