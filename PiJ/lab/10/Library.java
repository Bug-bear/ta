import java.util.*;

public class Library{
	private final String NAME;
	private int maxBooksPerUser;
	private ArrayList<String> UserList;
	private ArrayList<Book> BookList;
	
	public Library(String name){
		this.NAME = name;
		this.maxBooksPerUser = 3;
		this.UserList = new ArrayList();
		this.BookList = new ArrayList();
	}
	
	public String getName(){
		return this.NAME;
	}
	
	public void setMaxBooksPerUser(int n){
		this.maxBooksPerUser = n;
	}
	
	public int getMaxBooksPerUser(){
		return this.maxBooksPerUser;
	}
	
	public int addUser(String name){
		for(int i=0; i<UserList.size(); i++){
			if(UserList.get(i).equals(name))
				return -1;
		}
		UserList.add(name);
		return (UserList.size()-1);
	}
	
	public int getID(String name){
		for(int i=0; i<UserList.size(); i++){
			if(UserList.get(i).equals(name))
				return i;
		}
		UserList.add(name);
		return (UserList.size()-1);
	}
	
	public void addBook(String title, String author){
		Book b = new Book(title, author);
		BookList.add(b);
	}
	
	public Book takeBook(String title){
		Book target = null;
		for(int i=0; i<BookList.size(); i++){
			if(BookList.get(i).getTitle().equals(title)){
				target = BookList.get(i);
			}
		}
		if(target == null){
			return null;
		}
		else{
			if(!target.taken()){
				target.take();
				return target;
			}
			else 
				return null;
		}
	}
}