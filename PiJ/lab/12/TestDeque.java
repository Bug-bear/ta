import org.junit.*;
import static org.junit.Assert.*;

public class TestDeque{
	@Test
	public void testDnode(){
		Dnode<Integer> d1 = new Dnode<Integer>(2);
		Integer expected = 2;
		assertEquals(d1.value, expected);
	}
	
	@Test
	public void testAppendInt(){
		DequeImpl myDeque = new DequeImpl();
		Dnode<Integer> d1 = new Dnode<Integer>(2);
		myDeque.append(d1);
		assertEquals(d1, myDeque.head);
	}
	
	@Test
	public void testAppendDouble(){
		DequeImpl myDeque = new DequeImpl();
		Dnode<Double> d2 = new Dnode<Double>(2.2);
		myDeque.append(d2);
		assertEquals(d2, myDeque.head);
	}
	
	@Test
	public void testAppendString(){
		DequeImpl myDeque = new DequeImpl();
		Dnode<String> d3 = new Dnode<String>("3.3");
		myDeque.append(d3);
		assertEquals(d3, myDeque.head);
	}
	
	@Test
	public void testPopFront(){
		DequeImpl myDeque = new DequeImpl();
		Dnode<Integer> d1 = new Dnode<Integer>(2);
		Dnode<Integer> d2 = new Dnode<Integer>(3);
		Dnode<String> d3 = new Dnode<String>("wawa");
		myDeque.append(d1);
		myDeque.append(d2);
		myDeque.append(d3);
		assertEquals(d1.value, myDeque.popFront().value);
		assertEquals(d2.value, myDeque.popFront().value);
		assertEquals(d3.value, myDeque.popFront().value);
	}
	
	@Test
	public void testSorted(){
		Deque mySortedDeque = new SortedDequeImpl<Double>();
		Dnode<Double> d1 = new Dnode<Double>(3.3);
		Dnode<Double> d2 = new Dnode<Double>(1.1);
		Dnode<Double> d3 = new Dnode<Double>(6.6);
		mySortedDeque.append(d1);
		mySortedDeque.append(d2);
		mySortedDeque.append(d3);
		System.out.println(mySortedDeque.popFront().value);
		System.out.println(mySortedDeque.popFront().value);
		System.out.println(mySortedDeque.popFront().value);
		//assertEquals(d1.value, mySortedDeque.popFront().value);
		//assertEquals(d2.value, mySortedDeque.popFront().value);
		//assertEquals(d3.value, mySortedDeque.popFront().value);
	}
}