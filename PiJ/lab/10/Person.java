public class Person {
	private final String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name) {
		//this.name = name;
	}
	
	public static void main(String[] args){
		Person p = new Person("Bean");
		System.out.println(p.getName());
	}
}