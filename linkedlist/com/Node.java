package linkedlist.com;

public class Node<T> {
	T data ;
	Node next;
	public Node(T data) {
		this.data = data;
	}
	public Node(T data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node(){
		
	}
}
