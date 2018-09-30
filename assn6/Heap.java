/*
* Name: Tram Ung	
* ID: V00879005
* Date: 1/12/2017
* Filename: Heap.java
* Details: CSC115 Assignment 6
*/ 
import java.util.NoSuchElementException;
import java.util.Vector;

public class Heap<E extends Comparable<E>> {

	private Vector<E> heapArray;;
	public Heap() {
 		heapArray = new Vector<E>(1,1); //size and increment capacity is 1
	}
	/**
	 * Get root item of heap
	 * @return heap root
	 * @throws NoSuchElementException if heap is empty
	 */
 	public E getRootItem() {
 		if (isEmpty()) throw new NoSuchElementException("Heap is empty");
 		return heapArray.get(0);
 	}
 	/**
	 * Insert item at the end of array then rebuild
	 * @param item to be inserted
	 */
 	public void insert(E item) {
 		heapArray.add(item);
 		int currposition = heapArray.size() - 1;
 		int parentposition = (currposition - 1)/2;
 		while (parentposition >= 0 && item.compareTo(heapArray.get(parentposition)) < 0) {
 			E temp = heapArray.get(parentposition);
 			heapArray.set(parentposition, heapArray.get(currposition));
 			heapArray.set(currposition, temp);
 			currposition = parentposition;
 			parentposition = (currposition - 1)/2;
 		}
 	}
	/**
	 * Check if heap is empty
	 * @return true if heap is empty, false if not
	 */
 	public boolean isEmpty() {
 		return size() == 0;
 	}
 	/**
	 * Remove item at the root of heap
	 * @return item at the root of heap that has been removed
	 * @throw NoSuchElementException if heap is empty
	 */
 	public E removeRootItem() {
 		if (isEmpty()) throw new NoSuchElementException("Heap is empty");
 		else {
			E root = heapArray.get(0);
			heapArray.set(0, heapArray.get(size() - 1));
			heapArray.remove(size() - 1);
			reheapify(0);
			return root;
		}
 	}
	/**
	 * Find the number of elements in heap
	 * @return size of heap
	 */
 	public int size() {
 		return heapArray.size();
 	}
	/**
	 * Rebuild the heap using recursion
	 * @param root position
	 */
 	private void reheapify(int root) {
 		int leftchild = 2*root + 1;
 		if (leftchild < heapArray.size()) {
 			int rightchild = leftchild + 1;
 			if (rightchild < heapArray.size() && heapArray.get(rightchild).compareTo(heapArray.get(leftchild)) < 0) {
 				leftchild = rightchild;
 			}
 			if (heapArray.get(root).compareTo(heapArray.get(leftchild)) > 0) {
	 			E temp = heapArray.get(root);
	 			heapArray.set(root, heapArray.get(leftchild));
	 			heapArray.set(leftchild, temp);
	 			reheapify(leftchild);
 			}
 		}
 	}
 	/**
	 * The String representation of a heap array
	 * @return a heap array
	 */
 	public String toString() {
 		return heapArray.toString();
 	}
 	/* Testing */
 	public static void main(String[] args) { 	
 		Heap<Integer> heap = new Heap<Integer>();
 		try {
			System.out.println("Test removing from empty heap");
			heap.removeRootItem();
		} catch (NoSuchElementException e) {
			System.out.println("Heap is empty");
		} 
		try {
			System.out.println("Test get root item from empty queue");
			heap.getRootItem();
		} catch (NoSuchElementException e) {
			System.out.println("Heap is empty");
		}
		System.out.println("Inserting some stuffs");
 		heap.insert(15);
 		heap.insert(67);
 		heap.insert(26);
 		heap.insert(34);
 		heap.insert(0);
 		heap.insert(7);
 		System.out.println("Is it empty? " + heap.isEmpty());
 		System.out.println(heap);
 		System.out.println("Size: " + heap.size()); 
 		System.out.println("Root item: " + heap.getRootItem()); 
 		System.out.print("Deleting root: "); 
 		heap.removeRootItem();
		System.out.println(heap); 		
 	}
}
