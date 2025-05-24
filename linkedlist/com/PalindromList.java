package linkedlist.com;

import java.util.Arrays;

public class PalindromList {
	public static boolean isPalindrome(Node head) {
		Node fastNode = head;
		Node slowNode = head;
		while(fastNode != null && fastNode.next != null) {
			 fastNode = fastNode.next.next;
			 slowNode = slowNode.next;
		}
		if(fastNode != null) { //if ll is odd
			slowNode = slowNode.next;
		}
		slowNode = reverse(slowNode);
		fastNode = head;
		while(slowNode != null) {
			if(slowNode.data != fastNode.data) {
				return false;
			}
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		return true;
		
		
	}
	public static Node reverse(Node head) {
		Node preNode = null;
		Node current = head;
		while(current != null) {
			Node nexNode = current.next;
			//break link
			current.next = preNode;
			//set pre node to current
			preNode = current;
			//set current to next node
			current = nexNode;
		}
		return preNode;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist_01 o1 = new Linkedlist_01();
		Node l1 = o1.createLinkedList(Arrays.asList(1,2,3,4,5,6,4,3,2,1));
		System.out.println(isPalindrome(l1));
	}

}
