import org.junit.*;
import static org.junit.Assert.*;

public class NameTest{
	@Test
	public void testsGetInitials(){
		Name name = new Name();
		String input = "Peng Du";
		String output = name.getInitials(input);
		String expected = "PD";
		//System.out.println(output);
		assertEquals(output, expected);
	}
	
	@Test
	public void testsGetInitialsWithSpace(){
		Name name = new Name();
		String input = "Peng  Du";
		String output = name.getInitials(input);
		String expected = "PD";
		//System.out.println(output);
		assertEquals(output, expected);
	}	
}