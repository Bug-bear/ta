public class VehicleTester{
    public static void main(String[] args){
        // Small test of the Vehicle class 
		Vehicle example = new Vehicle("AB12 ABC");
		System.out.println("Vehicle Registration: " + example.getRegistration());
        example.setMake("Audi");
		System.out.println("Make: " + example.getMake());
				
		example.setEngineSize(1.6);
		System.out.println("Engine Size: " + example.getEngineSize());
		example.setFuel(Vehicle.FuelType.DIESEL);
		System.out.println("Fuel: " + example.getFuel());
		example.setRegistration("EF34 CDE");
		System.out.println();
		System.out.println(example);
    }
}