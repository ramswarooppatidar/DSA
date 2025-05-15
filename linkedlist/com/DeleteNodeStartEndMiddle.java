package linkedlist.com;

import java.util.Arrays;

public class DeleteNodeStartEndMiddle {

	public static Node deleteStart(Node head) {
		return head.next;
		
	}
	public static Node deleteEnd(Node head) {
		Node current = head;
		while(current.next.next != null) {
			current = current.next;
		}
		current.next = null;
		return head;
	}
	public static Node deleteMiddle(Node head, int pos) {
		Node current = head;
		int i =1;
		while(i<pos-1) {
			i++;
			current = current.next;
		}
		current.next = current.next.next;
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist_01 o1 = new Linkedlist_01();
		 Node llNode = o1.createLinkedList(Arrays.asList(1,2,3,4,5,6,7));
		o1.traversalLL( deleteStart(llNode));
		System.out.println();
		o1.traversalLL(deleteEnd(llNode));
		
		System.out.println();
		o1.traversalLL(deleteMiddle(llNode,3));

	}

}
