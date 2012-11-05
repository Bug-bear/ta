public abstract class Helpless implements Animal{
	private String name;

	public Helpless(String name){
		this.name = name;
	}
	
	public void call(){
		System.out.println(this.name + " is coming");
	}
	public abstract void reproduce();
}