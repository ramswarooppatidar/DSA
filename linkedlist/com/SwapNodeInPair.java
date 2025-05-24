package linkedlist.com;

import java.util.Arrays;

public class SwapNodeInPair {
	public static Node swapNode(Node head) {
		Node dummy = new Node(0);
		dummy.next = head;
		Node point = dummy;
		while(point.next != null && point.next.next != null) {
			Node swap1 = point.next;
			Node swap2 = point.next.next;
			
			swap1.next = swap2.next;
			swap2.next = swap1;
			
			point.next = swap2;
			point = swap1;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist_01 o1 = new Linkedlist_01();
		Node l1 = o1.createLinkedList(Arrays.asList(1,2,3,4,5,6,23,4,56,7,89,1,23));
		Node l2 = swapNode(l1);
		o1.traversalLL(l2);

	}

}
