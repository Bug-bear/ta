import java.util.*;

public class Friends{
	private Map<String,List<String>> map;
	
	public Friends(){
		this.map = new HashMap<String,List<String>>();
	}
	
	public void addFriends(String name, String... friends){
		List<String> list = new ArrayList<String>();
		for(String s : friends){
			list.add(s);
		}
		this.map.put(name, list);
	}
	
	public List<String> getFriends(String name){
		return this.map.get(name);
	}
	
	public static void main(String[] args){
		Friends f = new Friends();
		f.addFriends("Sue", "Bob","Jose","Alex","Cathy");
		f.addFriends("Cathy", "Bob","Alex");
		f.addFriends("Bob", "Alex","Jose","Jerry");
		
		System.out.println(f.getFriends("Sue"));
	}
}