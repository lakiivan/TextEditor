/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> list2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(41);
		
		list2 = new MyLinkedList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			list2.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list2.remove(10);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		assertEquals("Test add end: check size is correct ", 4, list2.size());
		list2.add(5);
		assertEquals("Test add end: check size is correct ", 5, list2.size());
		assertEquals("Test add end: check size is correct ", (Integer)5, list2.get(4));
		list2.add(6);
		assertEquals("Test add end: check size is correct ", 6, list2.size());
		assertEquals("Test add end: check size is correct ", (Integer)6, list2.get(5));
		
		try {
			list2.add(null);
			fail("Element can not be null");
		}
		catch (NullPointerException e) {
			
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("check size is correct ", 0, emptyList.size());
		assertEquals("check size is correct ", 10, longerList.size());
		assertEquals("check size is correct ", 2, shortList.size());
		assertEquals("check size is correct ", 3, list1.size());
		assertEquals("check size is correct ", 4, list2.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		assertEquals("check size is correct ", 4, list2.size());
		list2.add(1, 22);
		assertEquals("check size is correct ", 5, list2.size());
		assertEquals("Test add at index 1: check value is correct ", (Integer)22, list2.get(1));
		assertEquals("Test add at index 2: check value is correct ", (Integer)2, list2.get(2));
		
		try {
			list2.add(-1, 5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			list2.add(10, 5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}

		try {
			list2.add(3, null);
			fail("Element can not be null");
		}
		catch (NullPointerException e) {
			
		}
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		assertEquals("check size is correct ", 4, list2.size());
		list2.set(1, 22);
		assertEquals("check size is correct ", 4, list2.size());
		assertEquals("Test add at index 1: check value is correct ", (Integer)22, list2.get(1));
		//System.out.println(list2.get(1).toString());
		
		
		try {
			list2.set(-1, 5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			list2.set(10, 5);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list2.set(2, null);
			fail("Element can not be null");
		}
		catch (NullPointerException e) {
			
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
