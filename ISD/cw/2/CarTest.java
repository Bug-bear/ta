import org.junit.*;
import static org.junit.Assert.*;

public class CarTest{
	static Car car;
	
	@BeforeClass
	public static void setUp(){
		car = new Car("registration");
	}
	
	@Test
	public void testRegistration(){
		String expected = "registration";
		assertEquals(expected, car.getRegistration());
	}
	
	@Test
	public void testSeats(){
		int input = 6;
		car.setNumberOfSeats(input);
		int expected = input;
		int output = car.getNumberofSeats();
		assertEquals(expected, output);
	}
	
	@Test
	public void testBody(){
		Car.BodyStyle input = Car.BodyStyle.SALOON;
		Car.BodyStyle expected = input;
		car.setBody(input);
		Car.BodyStyle output = car.getBody();
		assertEquals(expected, output);
	}
}