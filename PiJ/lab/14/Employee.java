public class Employee{
	private long id;
	private String name;
	private String phone;
	private String title;
	
	public Employee(long id, String name, String phone, String title){
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.title = title;
	}
	
	public long getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public boolean equals(Object other){
		if(this.getClass() != other.getClass()){
			return false;
		}
		else{
			return (this.id == ((Employee)other).getId())
					&& (this.name == ((Employee)other).getName())
					&& (this.phone == ((Employee)other).getPhone())
					&& (this.title == ((Employee)other).getTitle());
		}
	}
	
	public int hashCode(){
		return super.hashCode();
	}
}