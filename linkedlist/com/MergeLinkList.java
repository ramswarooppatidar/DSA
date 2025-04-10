package linkedlist.com;

import java.lang.classfile.instruction.ReturnInstruction;
import java.util.ArrayList;
import java.util.List;

public class MergeLinkList {
	public static Node mergeListOfShortedLinkedList(List<Node> list) {
		Node resultNode = null;
		for(int i =0; i<list.size(); i++) {
			resultNode = mergeTwoLinkedList(resultNode, list.get(i));
		}
		Node reverseList = reverseLinkedList(resultNode);
//		return resultNode;
		return reverseList;
	}
	public static Node reverseLinkedList(Node head) {
		Node preNode = null;
		Node currNode =  head ;
		
		while(currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = preNode;
			preNode = currNode;
			currNode = nextNode;
		}
		
		
		return preNode;
	}
	public static Node mergeTwoLinkedList(Node l1, Node l2) {
		Node dummy = new Node<Integer>();
		Node preNode = dummy;
		while(l1 != null && l2 != null) {
			if((int) l1.data <= (int) l2.data) {
				dummy.next = l1;
				dummy = dummy.next;
				l1 = l1.next;
			}else {
				dummy.next = l2;
				dummy = dummy.next;
				l2 = l2.next;
			}			
		}
		while(l1 != null) {
			dummy.next = l1;
			dummy = dummy.next;
			l1 = l1.next;
		}
		while(l2 != null) {
			dummy.next = l2;
			dummy = dummy.next;
			l2 = l2.next;
		}
		return preNode.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		Node m1 = new Node(5);
		Node m2 = new Node(15);
		Node m3 = new Node(25);
		Node m4 = new Node(35);
		Node m5 = new Node(45);
		m1.next = m2;
		m2.next = m3;
		m3.next = m4;
		m4.next = m5;
		m5.next = null;
		
		Node o1 = new Node(3);
		Node o2 = new Node(6);
		Node o3 = new Node(9);
		Node o4 = new Node(12);
		Node o5 = new Node(18);
		o1.next = o2;
		o2.next = o3;
		o3.next = o4;
		o4.next = o5;
		o5.next = null;
		
//		Node resNode = mergeTwoLinkedList(n1, m1);
		
		List<Node> list = new ArrayList<>();
		list.add(n1);
		list.add(m1);
		list.add(o1);
		Node resNode2 = mergeListOfShortedLinkedList(list);
		
		while(resNode2 != null) {
			System.out.print(resNode2.data+" ");
			resNode2 = resNode2.next;
		}

	}

}
