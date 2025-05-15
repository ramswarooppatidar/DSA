package linkedlist.com;

import java.util.Arrays;
import java.util.List;


public class AddTwoNumber {
	public static Node addTwoNumber(Node<Integer> l1, Node<Integer> l2) {
		Node dummNode = new Node(0);
		Node current = dummNode;
		int carry=0;
		while(l1 != null || l2 != null || carry != 0) {
			int x = l1 != null ? l1.data : 0;
			int y = l2 != null ? l2.data : 0;
			int sum = x + y + carry;
			current.next = new Node<Integer>(sum % 10);
			current = current.next;
			carry = sum / 10;
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;	
		}
		return dummNode.next;
	}
	
	public static Node deleteNthNodeFromEnd(Node head, int n) {
		Node dummyNode = head;
		Node fastNode = head;
		int i =0;
		while(i++<n) {
			fastNode = fastNode.next;
			
		}
		while(fastNode.next != null) {
			fastNode = fastNode.next;
			dummyNode = dummyNode.next;
		}
		dummyNode.next = dummyNode.next.next;
		return head;
	}
	
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
	
	public static Node removeDublicte(Node head) {
		Node current = head;
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
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
		Node<Integer> llNode = o1.createLinkedList(Arrays.asList(9,9,9,9,9,9,9));
		Node<Integer> llNode2 = o1.createLinkedList(Arrays.asList(9,9,9,9));
		Node<Integer> result= addTwoNumber(llNode,llNode2);
		o1.traversalLL(result);
		
		System.out.println();
		Node<Integer> llNod = o1.createLinkedList(Arrays.asList(2,4,3));
		Node<Integer> llNod2 = o1.createLinkedList(Arrays.asList(5,6,4));
		Node<Integer> resut= addTwoNumber(llNod,llNod2);
		o1.traversalLL(resut);
		
		System.out.println();
		Node<Integer> l1 = o1.createLinkedList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		deleteNthNodeFromEnd(l1, 7);
		o1.traversalLL(l1);
		
		
		

	}

}
