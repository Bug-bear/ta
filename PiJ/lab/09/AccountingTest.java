import org.junit.*;
import static org.junit.Assert.*;

public class AccountingTest{
	@Test
	public void testsAddBillToList(){
		Accounting acc = new Accounting();
		String input[] = {"water", "1", "gas", "2", "END"};
		String output = acc.launchTester(input);
		System.out.println(output);
		String expected = "2 3";
		assertEquals(output, expected);
	}
}