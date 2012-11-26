import org.junit.*;
import static org.junit.Assert.*;

public class PrimeDivisorListTest{
	static PrimeDivisorList list;
	
	@BeforeClass
	public static void setUp(){
		list = new PrimeDivisorList();
	}
	
	@Test
	public void testToString(){
		list.add(2);
		list.add(3);
		list.add(7);
		list.add(3);
		String expected = "[ 2 * 3^2 * 7 = " + (2*3*7*3) + " ]";
		String output = list.toString();
		assertEquals(output, expected);
	}
	
	@Test(expected=NullPointerException.class)
	public void addNull(){
		list.add(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNonPrime(){
		list.add(6);
	}	
}