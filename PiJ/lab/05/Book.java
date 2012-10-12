public class Book{
	private int pageNumber;
	private int price;
	
	public Book(int num,int p){
		pageNumber = num;
		price = p;
	}
	
	public int getPage(){
		return pageNumber;
	}
	
	public int getPrice(){
		return price;
	}
}