public class PduPatientList{
	//inner class
	private class Patient {
		private String name;
		private int age;
		private String illness;
		private Patient nextPatient;
		private Patient lastPatient;
		public Patient(String name, int age, String illness) {
			this.name = name;
			this.age = age;
			this.illness = illness;
			this.nextPatient = null;
			this.lastPatient = null;
		}
	}
	//field of list
	private Patient head = null;
	private Patient tail = null;
		
	public void prepend(String name, int age, String illness){
		Patient p = new Patient(name, age, illness);
		p.nextPatient = head;
		if(head == null){
			tail = p;
		} else{
			head.lastPatient = p;
		}
		head = p;
	}
	
	public void append(String name, int age, String illness){
		Patient p = new Patient(name, age, illness);
		p.lastPatient = tail;
		if(tail == null){
			head = p;
		} else{
			tail.nextPatient = p;
		}
		tail = p;
	}		

	public void remove(String name){
		delete(name,head);
	}
	
	//priave helper method to be called recursively
	private void delete(String name, Patient p){
		if(p == null){
			System.out.println("not found");
			return;
		}
		else if(p.name.equals(name)){
			if(p.nextPatient == null && p.lastPatient == null){
				head = null;
				tail = null;
				return;
			}
			if(p == this.head){
				this.head.nextPatient.lastPatient = null;
				this.head = this.head.nextPatient;
			} 
			else if(p == this.tail){
				this.tail.lastPatient.nextPatient = null;
				this.tail = this.tail.lastPatient;
			}
			else{
				p.lastPatient.nextPatient = p.nextPatient;
				p.nextPatient.lastPatient = p.lastPatient;
			}
		}
		else{
			delete(name, p.nextPatient);
		}
	}
	
	public void traverseForward(){
		Patient p = this.head;
		do{
			if(p == null){
				System.out.println("empty list");
				return;
			}
			System.out.println(p.name);
			p = p.nextPatient;
		} while(p != null);
	}
	
	public void traverseBackward(){
		Patient p = this.tail;
		do{
			if(p == null){
				System.out.println("empty list");
				return;
			}		
			System.out.println(p.name);
			p = p.lastPatient;
		} while(p != null);		
	}	
	
	public static void main(String[] args) {
		PduPatientList ourList = new PduPatientList();
		// add some patients
		for(int i=0; i<2; i++){
			//ourList.prepend("Mr. " + i, i, "phd");
			ourList.append("Mr. " + i, i, "phd");
		}
		
		ourList.traverseForward();
		System.out.println();
		
		ourList.remove("Mr. 0");
		ourList.traverseForward();
		System.out.println();
		
		ourList.remove("Mr. 1");
		ourList.traverseForward();
		System.out.println();		
		ourList.traverseBackward();
	}
}