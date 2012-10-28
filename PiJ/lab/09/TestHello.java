import org.junit.*;
import static org.junit.Assert.*;

public class TestHello {
	@Test
	public void testsSayHello() {
		Hello h = new Hello();
		String output = h.sayHello();
		String expected = "Hello World";
		assertEquals(output, expected);
	}
}