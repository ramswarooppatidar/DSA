package linkedlist.com;

import java.util.Arrays;

public class PrintReverseLinkedList {
	public static void printReverseLinkedList(Node head) {
		if(head == null) {
			return;
		}
		
		printReverseLinkedList(head.next);
		System.out.print(head.data+" ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist_01 o1 = new Linkedlist_01();
		 Node llNode = o1.createLinkedList(Arrays.asList(1,2,3,4,5,6,7));
		 printReverseLinkedList(llNode);
	

	}

}
