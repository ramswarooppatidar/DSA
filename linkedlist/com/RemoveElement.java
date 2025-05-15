package linkedlist.com;

import java.util.Arrays;

public class RemoveElement {
	public static Node removeElement(Node<Integer> head, int val) {
		Node current = head;
		while(current.next != null) {
			if((int)current.next.data == val) {
				current.next = current.next.next;
			}else {
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Linkedlist_01 o1 = new Linkedlist_01();
      Node llNode= o1.createLinkedList(Arrays.asList(1,3,5,7,9,11,13,15));
     Node headNode = removeElement(llNode, 9);
     o1.traversalLL(headNode);
	}

}
