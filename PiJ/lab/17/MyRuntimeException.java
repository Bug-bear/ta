public class MyRuntimeException extends RuntimeException{
	private String info;

	public MyRuntimeException(String loc){
		this.info = "I am a runtime exception thown " + loc + " a try block";
	}
	
	public String toString(){
		return this.info;
	}
}