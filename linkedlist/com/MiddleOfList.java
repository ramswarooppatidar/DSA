package linkedlist.com;

import java.util.Arrays;

public class MiddleOfList {
	public static Node middle(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist_01 o1 = new Linkedlist_01();
		Node l1= o1.createLinkedList(Arrays.asList(1,3,5,7,9,11,13,15,17));
		o1.traversalLL(l1);
		System.out.println();
		Node midleNode = middle(l1);
		System.out.println(midleNode.data);
		

	}

}
