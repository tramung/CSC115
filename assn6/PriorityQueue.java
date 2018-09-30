/*
* Name: Tram Ung	
* ID: V00879005
* Date: 1/12/2017
* Filename: PriorityQueue.java
* Details: CSC115 Assignment 6
*/ 
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> {
	
	private Heap<E> heap;

	public PriorityQueue() {
 		heap = new Heap<E>();
	}
	/**
	 * Remove the item with the highest priority from the queue
	 * @return item with the highest priority
	 * @throw NoSuchElementException if queue is empty
	 */
 	public E dequeue() {
 		if (heap.isEmpty()) throw new NoSuchElementException("Queue is empty!");
 		return heap.removeRootItem();
 	}
	/**
	 * Insert item into the queue
	 * @param item to be inserted
	 */
 	public void enqueue(E item) {
 		heap.insert(item);
 	}
	/**
	 * Check if queue is empty
	 * @return true if queue is empty, false if not
	 */
 	public boolean isEmpty() {
 		return heap.isEmpty();
 	}
 	/**
	 * Retrieve the item with the highest priority 
	 * @return item with highest priority
	 * @throw NoSuchElementException if queue is empty
	 */
	public E peek() {
		if (heap.isEmpty()) throw new NoSuchElementException("Queue is empty!");
		return heap.getRootItem();
	}	
 	/**
	 * The String representation of a priority queue
	 * @return a priority queue
	 */
	public String toString() {
		return heap.toString();
	}
	/* Testing */
	public static void main(String[] agrs) {
		PriorityQueue test = new PriorityQueue();
		try {
			System.out.println("Test removing from empty queue");
			test.peek();
		} catch (NoSuchElementException e) {
			System.out.println("Queue is empty");
		} 
		try {
			System.out.println("Test dequeuing from empty queue");
			test.dequeue();
		} catch (NoSuchElementException e) {
			System.out.println("Queue is empty");
		} 
		System.out.println("Adding patients");
		test.enqueue(new ER_Patient("Walk-in"));
		test.enqueue(new ER_Patient("Life-threatening"));
		test.enqueue(new ER_Patient("Chronic"));
		test.enqueue(new ER_Patient("Major fracture"));
		test.enqueue(new ER_Patient("Chronic"));
		System.out.println("Is the queue empty? " + test.isEmpty());
 		System.out.println("List of patients: ");
 		System.out.println(test);
 		System.out.println("First Priority Patient: " + test.peek()); 
 		System.out.println("Removing Patient: " + test.dequeue()); 
		System.out.println(test); 
		System.out.println("Next Priority Patient: " + test.peek()); 
 		System.out.println("Removing Patient: " + test.dequeue());

	}	
}
	
