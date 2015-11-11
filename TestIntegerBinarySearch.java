import org.junit.*;
import static org.junit.Assert.*;
//import java.util.Random;
//import java.lang.*;

public class TestIntegerBinarySearch {

	private IntegerBinarySearch instance;
	
	@Before
	public void init() {
		
		instance = new IntegerBinarySearchImpl();
	}
	
//	@Test
	public void searchForNotAddedTest() {
		
		boolean expected = false;
		boolean result = instance.searchFor(new Integer(-1));		
		assertEquals(expected, result);
	}
	
	@Test
	public void searchForNullTest() {
		
		boolean expected = false;
		boolean result = instance.searchFor(null);		
		assertEquals(expected, result);
	}
	
	@Test
	public void searchForItemAddedTest() {
	
		boolean expected = true;
//		Integer searchFor = new Integer(500);
//		instance.add(searchFor);
		
//		for (int i = 1; i < 500; i++) {
			
			boolean result = instance.searchFor(7);
			assertEquals(expected, result);
//		}


	}
	
	@Test
	public void addTest() {
		
		instance.add(new Integer(0));		
		instance.add(null);
	}
}