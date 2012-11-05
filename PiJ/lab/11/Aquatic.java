public abstract class Aquatic implements Animal{
	private String name;

	public Aquatic(String name){
		this.name = name;
	}
	
	public void call(){
		System.out.println(this.name + " will not come");
	}
	public abstract void reproduce();
}