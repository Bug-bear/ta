public class Book{
	private final String TITLE;
	private final String AUTHORS;
	private boolean onLoan;
	
	public Book(String title, String authors){
		this.TITLE = title;
		this.AUTHORS = authors;
		onLoan = false;
	}
	
	public String getTitle(){
		return this.TITLE;
	}
	
	public String getAuthors(){
		return this.AUTHORS;
	}
	
	public void take(){
		onLoan = true;
	}

	public void returned(){
		onLoan = false;
	}
	
	public boolean taken(){
		return onLoan;
	}
}