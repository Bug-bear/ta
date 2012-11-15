import java.util.ArrayList;
public class Portfolio
{
    public static void main(String[] args){        
		Car example1 = new Car("AB12 ABC");
		example1.setMake("Audi");
		example1.setEngineSize(1.6);   
		example1.setFuel(Vehicle.FuelType.DIESEL);
		example1.setNumberOfSeats(4);
		example1.setBody(Car.BodyStyle.HATCHBACK);
		System.out.println(example1);
		
		Car example2 = new Car("EF34 CDE");
		example2.setMake("Volkswagen");
		example2.setEngineSize(2.0);   
		example2.setFuel(Vehicle.FuelType.UNLEADED_PETROL);
		example2.setNumberOfSeats(6);
		example2.setBody(Car.BodyStyle.SALOON);
		System.out.println(example2);
				 
		Motorcycle example3 = new Motorcycle("JK78 MNP");
		example3.setMake("Kawasaki");
		example3.setEngineSize(144);   
		example3.setFuel(Vehicle.FuelType.UNLEADED_PETROL);
		example3.setDrivableOffRoad(true);
		System.out.println(example3);
		
		ArrayList<Vehicle> portfolio = new ArrayList<Vehicle>();
		portfolio.add(example1);
		portfolio.add(example2);
		portfolio.add(example3);
		System.out.println( "*** Display Unleaded Vehicles Only ***" );
		System.out.println();
		Vehicle.FuelType fuel;
		fuel = Vehicle.FuelType.UNLEADED_PETROL;
		DisplayVehiclesWithFuel(portfolio,fuel);
		System.out.println( "*** Display Diesel Vehicles Only ***" );
		System.out.println();
		fuel = Vehicle.FuelType.DIESEL;
		DisplayVehiclesWithFuel(portfolio,fuel);
		
	}
		
	//Missing method body
	public static void DisplayVehiclesWithFuel(ArrayList<Vehicle> portfolio, Vehicle.FuelType fuel){
		for(Vehicle element : portfolio){
			if(element.getFuel() == fuel){
				System.out.println(element);
			}
		}
	}
}