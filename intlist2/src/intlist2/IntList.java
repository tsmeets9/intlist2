package intlist2;

import java.util.Arrays;


class Node {
	int value;
	Node next;
}

/**
 * Each instance of this class stores a list of integers.
 * @author thiba
 *
 */
public class IntList {
	private Node firstNode;
	
//	public IntList() {
//		throw new RuntimeException("Not yet implemented");
//	}
	
	public int getSize() {
		int count = 0;
		Node node = firstNode;
		while (node!=null) {
			count ++;
			node = node.next;
		}
		return count;
	}
	/**
	 * @pre The given index is between 0 and one less then the size of the list.
	 * 			|0 <= index && index <= getSize()
	 * @param index
	 * @return
	 */
	public int get(int index) {
		Node node = firstNode;
		for (int i = 0; i<index;i++) {
			node = node.next;
		}
		return node.value;
	}
	
	public int[] getElements() { 
		int [] result = new int[getSize()];
		Node node = firstNode;
		for (int i=0; i < result.length; i++) {
			result[i] = node.value;
			node = node.next;
		}
		return result;
			
	}
	
	/**
	 * Adds the given element to the end of the list.
	 * @post The size of the list equals its old size plus 1.
	 * 			|getSize() == old(getSize()) +1
	 * @post The elements of the list are the old elements with the given element added to the end. 
	 * 			|Arrays.equals(getElements(), 0, old(getSize()),old(getElements()), 0, old(getSize()))
	 * @post The last element in this list equals the given value. 
	 * 			| getElements()[old(getSize())] == element
	 * 
	 */
	public void add(int element) {
		if (firstNode == null) {
			firstNode = new Node();
			firstNode.value = element;
		}
		else {
			Node node = firstNode;
			while (node.next!=null) {
				node = node.next;
			}
			node.next = new Node();
			node.next.value = element;
		}
		
	}
	
	/** 
	 * Removes the element at the given index from the list
	 * @pre The given index is between 0 (inclusive) and the list's size (exclusive)
	 * 			|0<= index && index < getSize()
	 * @post The list's size equals its old size minus 1.
	 * 			|getSize() == old(getSize()) - 1 
	 * @post This lists elements at indices less than the given index remained unchanged.
	 * 			|Arrays.equals(getElements(), 0, index, old(getElements()),0, index)
	 * @post This list elements at indices not less than the given index equals the old ones + 1
	 * 			|Arrays.equals(getElements(), index, getSize(),old(getElements()), index + 1, old(getSize()))
	 * @param index
	 */
	public void remove(int index) { 
		if (index == 0) {
			firstNode = firstNode.next;
		}
		else {
			Node node = firstNode;
			for (int i = 0; i < index - 1; i++) {
				node = node.next;
			}
			node.next = node.next.next;
		}
	}
	/**
	 * Inserts the given value into this list at the given index.
	 * @pre The given index is between 0 (inclusive) and the list's size (exclusive)
	 * 			|0<= index && index < getSize()
	 * @post The list's size is it's old size + 1 
	 * 			|getSize() == old(getSize()) + 1 
	 * @post This lists elements at indices less than the given index remained unchanged
	 * 		| Arrays.equals(getElements(), 0, index, old(getElements()),0,index)
	 */
	public void insert(int index, int value) {
		if (index == 0) {
			Node node = firstNode;
			firstNode = new Node();
			firstNode.value = value;
			firstNode.next = node;
		}
		else { 
			Node node = firstNode;
			for (int i = 0; i<index -1; i++) {
				node = node.next;
			}
			Node nextNode = node.next;
			node.next = new Node();
			node.next.value = value;
			node.next.next = nextNode;
		}
	}
}
