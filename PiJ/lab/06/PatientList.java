class Patient {
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

	public void addPatient(Patient newPatient) {
		if (this.nextPatient == null) {
			// this means this is the last patient in the list
			this.nextPatient = newPatient;
			newPatient.lastPatient = this;
		} else {
			this.nextPatient.addPatient(newPatient);
		}
	}
	
	// this is a member method of class Patient
	// returns true if the patient was found and removed, false otherwise
	public boolean deletePatient(Patient patient) {
		if (this.nextPatient == null) {
			// patient to remove was not found
			System.out.println("not found");
			return false;
		} else if (this.nextPatient.name.equals(patient.name)) {
			// We found it! It is the next one!
			// Now link this patient to the one after the next
			this.nextPatient = nextPatient.nextPatient;
			if(nextPatient != null) //if it is not the end of existing list
				nextPatient.lastPatient = this;
			return true;
		} else {
			return this.nextPatient.deletePatient(patient);
		}
	}	
	
	public void traverseForward(){
		if(this != null){
			System.out.println(this.name);
			if(this.nextPatient!=null){
				this.nextPatient.traverseForward();
			}
		}		
	}
	
	public void traverseBackward(){
		Patient tail = this;
		while(tail.nextPatient != null){
			tail = tail.nextPatient;
		}
		
		while(tail != null){
			System.out.println(tail.name);
			tail = tail.lastPatient;
		}
	}	
}

public class PatientList{
	private Patient head = null;
	
	public static void main(String[] args) {
		PatientList ourList = new PatientList();
		ourList.head = new Patient("bean", 50, "phd");
		
		/*
		for(int i=0; i<10; i++){
			Patient newPatient = new Patient("douzi" + i, i, "master");
			ourList.head.addPatient(newPatient);
		}
		
		ourList.head.traverseForward();
		System.out.println();
		
		Patient toDel = new Patient("douzi5", 5, "master");
		ourList.head.deletePatient(toDel);
		toDel = new Patient("douzi9", 9, "master");
		ourList.head.deletePatient(toDel);
		
		ourList.head.traverseForward();
		System.out.println();
		ourList.head.traverseBackward();
		System.out.println();
		
		Patient toAdd = new Patient("wawa", 6, "bsc");
		ourList.head.addPatient(toAdd);		
		ourList.head.traverseForward();
		System.out.println();
		ourList.head.traverseBackward();
		System.out.println();
		
		toDel = new Patient("none", 9, "master");
		ourList.head.deletePatient(toDel);
		*/
		
		/* no way to remove everything from the list
		ourList.head.traverseForward();
		Patient toDel = new Patient("bean", 6, "bsc");
		ourList.head.deletePatient(toDel);
		ourList.head.traverseForward();
		*/
	}
}