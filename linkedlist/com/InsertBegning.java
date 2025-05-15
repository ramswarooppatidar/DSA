package linkedlist.com;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

 

public class InsertBegning {
	 public static Node insertBegning(Node head, int val) {
		  Node newNode = new Node(val);
		  newNode.next = head;
		  head = newNode;
		  return head;
	  }
	 public static Node insertEnd(Node head, int val) {
		 Node newNode = new Node(val);
		 Node current = head;
		 while(current.next != null) {
			 current = current.next;
		 }
//		 System.out.println(current.data);
		 current.next = newNode;
		 return head;
	 }
	 public static Node insertMiddle(Node head, int val, int pos) {
		 Node current = head;
		 Node newNode = new Node(val);
		 int i =1;
		 while(i<pos) {
			 i++;
			 current = current.next;
		 }
		 Node nextNode = current.next;
		 current.next = newNode;
		 newNode.next = nextNode;
		 return head;
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist_01 o1 = new Linkedlist_01();
		 Node llNode = o1.createLinkedList(Arrays.asList(1,2,3,4,5,6,7));
		o1.traversalLL( insertBegning(llNode,1897));
		System.out.println();
		o1.traversalLL( insertEnd(llNode,59505905));
		
		System.out.println();
		 Node ll2 = o1.createLinkedList(Arrays.asList(100,2,56,34,6,5,89,12,1));
		o1.traversalLL(insertMiddle(ll2, -1007, 4));
		
		

	}

}
