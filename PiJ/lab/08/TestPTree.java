import static org.junit.Assert.*;
import org.junit.*;

public class TestPTree {
	private static PIntegerTree tree = new PIntegerTree();
	
	@BeforeClass 
	public static void buildTree(){
		tree.add(6);
		tree.add(9);
		tree.add(5);
		tree.add(3);
		tree.add(11);
		tree.add(8);
		tree.add(12);
	}
	
	@Test
	public void testContains(){
		int input1 = 6;
		int input2 = 7;
		int input3 = 12;
		boolean expected1 = true;
		boolean expected2 = false;
		boolean expected3 = true;
		assertEquals(tree.contains(input1),expected1);
		assertEquals(tree.contains(input2),expected2);
		assertEquals(tree.contains(input3),expected3);
	}	
}
