public abstract class Flying implements Animal{
	private String name;

	public Flying(String name){
		this.name = name;
	}
	
	public void call(){
		System.out.println(this.name + " may come when tired");
	}
	public abstract void reproduce();
}