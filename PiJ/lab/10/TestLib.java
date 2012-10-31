import org.junit.*;
import static org.junit.Assert.*;

public class TestLib{
	private static Book b;
	private static User p;
	private static Library lib;

	@BeforeClass
	public static void setUp(){
		b = new Book("tian long ba bu", "jin yong");
		p = new User("wei xiaobao");
		lib = new Library("mock lib");
	}

	@Test
	public void testsBookName(){
		assertEquals(b.getTitle(), ("tian long ba bu"));
	}
	
	@Test
	public void testsBookAuthors(){
		assertEquals(b.getAuthors(), ("jin yong"));
		
	}	
	
	@Test
	public void testsUserName(){
		assertEquals(p.getName(), "wei xiaobao");
	}
	
	/*
	@Test
	public void testsLibraryRegistration(){
		Library lib = new Library("mock lib");
		p.register(lib);
		assertEquals(p.getLibrary(), lib.getName());
		assertEquals(p.getID(), 11);
	}*/
	
	@Test
	public void testsLibraryMaxPerUser(){
		assertEquals(lib.getMaxBooksPerUser(), 3);
		lib.setMaxBooksPerUser(6);
		assertEquals(lib.getMaxBooksPerUser(), 6);		
	}

	@Test
	public void testsLibraryUserRetrieval(){
		p.register(lib);
		assertEquals(p.getID(), lib.getID(p.getName()));		
		User p2 = new User("duan yu");
		p2.register(lib);
		assertEquals(p2.getID(), lib.getID(p2.getName()));		
	}	
	
	@Test
	public void testsBookList(){
		lib.addBook("she diao", "jin yong");
		lib.addBook("chang sheng jian", "gu long");
		Book output = lib.takeBook("she diao");
		assertEquals(output.getTitle(), "she diao");
		output = lib.takeBook("she diao");
		assertEquals(output, null);
	}
}