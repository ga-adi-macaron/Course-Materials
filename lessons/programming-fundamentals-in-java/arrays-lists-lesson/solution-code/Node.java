package ListLab;

public class Node {
	  Node next;
	    Object data;

	    public Node(Object data) {
	        this(data, null);
	    }

	    public Node(Object data, Node next) {
	        this.next = next;
	        this.data = data;
	    }

	    public Object getData() {
	        return this.data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }

	    public Node getNext() {
	        return this.next;
	    }

	    public void setNext(Node nextNode) {
	        this.next = nextNode;
	    }
}
