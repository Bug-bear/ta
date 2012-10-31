public class User{
	private final String NAME;
	private int ID;
	private Library lib;

	public User(String name){
		this.NAME = name;
	}
	
	public String getName(){
		return this.NAME;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public void setID(int id){
		this.ID = id;
	}
	
	public void register(Library lib){
		this.ID = lib.addUser(this.NAME);
	}
	
	public String getLibrary(){
		return this.lib.getName();
	} 
}