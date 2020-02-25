package intlist2;

class Node {
	int value;
	Node next;
}
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
