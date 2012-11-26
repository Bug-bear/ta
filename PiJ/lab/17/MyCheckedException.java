public class MyCheckedException extends Exception{
	private String info;
	
	public MyCheckedException(String loc){
		this.info = "I am a checked exception thown " + loc + " of a try block";
	}
	
	public String toString(){
		return this.info;
	}
}