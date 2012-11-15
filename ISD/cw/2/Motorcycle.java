public class Motorcycle extends Vehicle{
	boolean offRoad;
   
	public Motorcycle(String registration){
		super(registration);
	}   
	
	public void setDrivableOffRoad(boolean offRoad){
		this.offRoad = offRoad;
	}
	
	public boolean getDrivableOffRoad(){
		return this.offRoad;
	}

	public String toString(){
		String ret = super.toString();
		ret += "Off Road: " + this.offRoad + "\n";
		return ret;
	}	
}