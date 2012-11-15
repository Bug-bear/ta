import org.junit.*;
import static org.junit.Assert.*;

public class MotorTest{
	static Motorcycle motor;
	
	@BeforeClass
	public static void setUp(){
		motor = new Motorcycle("registration");
	}
	
	@Test
	public void testRegistration(){
		String expected = "registration";
		assertEquals(expected, motor.getRegistration());
	}
	
	@Test
	public void testOffRoad(){
		boolean input = true;
		motor.setDrivableOffRoad(input);
		boolean expected = input;
		boolean output = motor.getDrivableOffRoad();
		assertEquals(expected, output);
	}
}