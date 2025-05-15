package linkedlist.com;

import java.security.DrbgParameters.NextBytes;

public class HashCycle {
	public static boolean hasCycle(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) {
				return true;
			}	
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
