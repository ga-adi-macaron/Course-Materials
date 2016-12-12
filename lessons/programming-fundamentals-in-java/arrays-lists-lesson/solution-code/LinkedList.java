package ListLab;

public class LinkedList {
	
	private Node head;
	private int size = 0;
	
	public int getSize() {
		return size;
	}
	
	public void add(Object obj) {
		if(head == null) {
			this.head = new Node(obj);
		} else {
			Node currentNode = head;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(new Node(obj));
		}
		size++;
	}
	
	public boolean remove(int index) {
		if(index < 0 || index > size) {
			return false;
		} else if(index == 0) {
			if(head.next == null) {
				head = null;
			} else {
				head = head.getNext();
			}
		} else {
			Node currentNode = head;
			if (currentNode != null) {
				Node prevNode = null;
				for (int i = 0; i < index; i++) {
					if (currentNode.getNext() == null) {
						return false;
					}
					prevNode = currentNode;
					currentNode = currentNode.getNext();
				}
				prevNode.setNext(currentNode.getNext());
			}
		}
		size--;
		return true;
	}
	
	public Object get(int index) {
		if(index < 0 || index > size) {
			return null;
		}
		Node currentNode = head;
		if(currentNode != null) {
			for(int i = 0; i < index; i++) {
				currentNode = currentNode.getNext();
			}
		}
		return currentNode.getData();
	}
}
