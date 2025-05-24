package linkedlist.com;

import java.lang.classfile.Opcode;
import java.util.Arrays;

public class ReverseLinkedList {
	public static Node reverseLinkedList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node preNode = null;
		Node current = head;
		while(current != null) {
			Node nextNode = current.next;
			current.next = preNode;
			preNode = current;
			current = nextNode;
	}
//	    head = preNode;
//		return head;
		return preNode;
	}
	public static Node reverseL(Node head) {
		Node preNode = null;
		Node current = head;
		while(current != null) {
			Node nextNode = current.next;
			current.next = preNode;
			preNode = current;
			current = nextNode;
		}
		return preNode;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist_01 o1 = new Linkedlist_01();
		 Node llNode = o1.createLinkedList(Arrays.asList(1,2,3,4,5,6,7));
		 Node heNode=reverseLinkedList(llNode);
		 o1.traversalLL(heNode);
		

	}

}
