import java.util.*;
import java.util.Random;

public class IntegerBinarySearchImpl implements IntegerBinarySearch{


	public static final int DEFAULT_LIST_SIZE = 1000;
	//
	private final List<Integer> list;
	
	
	public IntegerBinarySearchImpl() {
		
		this(DEFAULT_LIST_SIZE);
		
	}
	
	public IntegerBinarySearchImpl(int intialSize) {
		
		list = new ArrayList<>(intialSize);
		Random r = new Random(Integer.MAX_VALUE);
		for (int i = 0; i < intialSize; i++) {
//			list.add(Math.abs(r.nextInt()));
			list.add(i);
		}
//		Collections.sort(list);
	}
	
	public void add (Integer i) {
		
		if (i != null) {
			list.add(i);
		}
	}
	
	public boolean searchFor(Integer i) {
		
		if (i==null) {
			return false;		
		} 
		System.out.println("List" + (list.contains(i) ? " CONTAINS " : " does NOT contain ") + i);
		return findIntegerInListAtIndex (i, (1 + list.size())  / 2, -1);
	}
	
	private boolean findIntegerInListAtIndex(Integer i, int index, int lastPos) {
		
		Integer listItem = list.get(index);
		System.out.println("Searching for " + i + " at position " + index + ", last pos " + lastPos + ", found " + listItem);
		int comparison = i.compareTo(listItem);
		if (comparison == 0) {			
			return true;		
		} else if (index == lastPos) {	// Nowhere for a further search
			return false;			
		} else if(comparison > 0) {			// Search higher, halfway to the last position
			System.out.println("Searching higher...");
			int moveTo = lastPos < index ? list.size() -1 : lastPos;
			int nextPos = index + (( moveTo - index) / 2);
			return findIntegerInListAtIndex(i, nextPos, index);
		} else {							// Search lower, halfway to the last position
			System.out.println("Searching lower...");
			int moveTo = lastPos > index ? 0 : lastPos;
			int nextPos = index - ((index - moveTo) / 2);
			return findIntegerInListAtIndex(i, nextPos, index);
		}				
	}
}