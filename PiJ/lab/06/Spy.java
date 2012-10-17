public class Spy{
	private static int spyCount;
	private int id;
	
	public Spy(int id){
		this.id = id;
		spyCount++;
		System.out.println("Spy number " + this.id + 
			" created. There are currently " + this.spyCount + " spies.");
	}
	
	public void die(){
		spyCount--;
		System.out.println("Spy " + this.id + 
			" has been vaporised. There are " + this.spyCount + " left.");
	}
	
	public static void main(String[] args){
		Spy bond = new Spy(7);
		Spy english = new Spy(8);
		
		bond.die();
		bond = null;
	}
}