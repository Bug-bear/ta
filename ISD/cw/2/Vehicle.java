public class Vehicle{
    public enum FuelType {DIESEL, UNLEADED_PETROL, LEADED_PETROL}
    private String registration;
	private String make;
	private double engineSize;
	private FuelType fuel;
    
	// Creates a new Vehicle
	public Vehicle(String registration){
		this.registration = registration;
	}
	
	public void setRegistration(String registration){
		this.registration = registration;
	}
		   
	public String getRegistration(){
	   return this.registration;
	}
	
	public void setMake(String make){
		this.make = make;
	}
	
	public String getMake(){
		return this.make;
	}
	
	public void setEngineSize(double engineSize){
		this.engineSize = engineSize;
	}
	
	public double getEngineSize(){
		return this.engineSize;
	}
	
	public void setFuel(FuelType fuel){
		this.fuel = fuel;
	}
	
	public FuelType getFuel(){
		return this.fuel;
	}
	
	public String toString(){
		String ret = "";
		ret += "Vehicle Registration: " + this.registration + "\n";
		ret += "Make: " + this.make + "\n";
		ret += "Engine Size: " + this.engineSize + "\n";
		ret += "Fuel: " + this.fuel + "\n";
		return ret;
	}
}