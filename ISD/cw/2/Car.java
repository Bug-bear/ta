public class Car extends Vehicle{
	public enum BodyStyle {HATCHBACK, SALOON, FOUR_DOOR, FIVE_DOOR};
	private int seats;
	private BodyStyle body;
	
	public Car(String registration){
		super(registration);
	}
	
	public void setNumberOfSeats(int seats){
		this.seats = seats;
	}
	
	public int getNumberofSeats(){
		return seats;
	}
	
	public void setBody(BodyStyle body){
		this.body = body;
	}
	
	public BodyStyle getBody(){
		return this.body;
	}
	
	public String toString(){
		String ret = super.toString();
		ret += "Number of Seats: " + this.seats + "\n";
		ret += "Body: " + this.body + "\n";
		return ret;
	}
}