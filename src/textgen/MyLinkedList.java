package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		this.head.next = tail;
		this.tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			return false;
		} else {
			LLNode<E> new_node = new LLNode<E>(element);
			this.tail.prev.next = new_node;
			new_node.prev = this.tail.prev;
			new_node.next = tail;
			this.tail.prev = new_node;
			this.size++;
			return true;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= this.size || this.size == 0) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		LLNode<E> curr_node = head.next;
		for(int i = 0; i < index; i++) {
			curr_node = curr_node.next;
			//System.out.println("Curr node value: " + curr_node.data);
		}
		return curr_node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Check out of bounds");
		}
		LLNode<E> curr_node = head.next;
		for(int i = 0; i < index; i++) {
			curr_node = curr_node.next;
			//System.out.println("Curr node value: " + curr_node.data);
		}
		LLNode<E> new_node = new LLNode(element);
		curr_node.prev.next = new_node;
		new_node.prev = curr_node.prev;
		new_node.next = curr_node;
		curr_node.prev = new_node;
		//System.out.println(new_node);
		this.size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		//System.out.println("Remove method called");
		// TODO: Implement this method
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		LLNode<E> target_node = head.next;
		//System.out.println(target_node.data);
		//System.out.println("tn prev data " + target_node.prev.data);
		for(int i = 0; i < index; i++) {
			target_node = target_node.next;
		}
		LLNode<E> prev = target_node.prev;
		//System.out.println("PREV " + prev.data);
		LLNode<E> next = target_node.next;
		//System.out.println("NEXT " + next.data);
		prev.next = next;
		next.prev = prev;
		this.size--;
		return target_node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("Index out of bound");
		}
		
		LLNode<E> target_node = head.next;
		for(int i = 0; i < index; i++) {
			target_node = target_node.next;
		}
		target_node.data = element;
		//System.out.println(target_node);
		return target_node.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode prev, LLNode next) {
		this.data = e;
		this.prev = prev;
		this.next = next;
	}

	public String toString() {
		String node_info = "Node " + this.data + ", prev: " + this.prev.data + ", next: " + this.next.data;
		return node_info;
	}
}
