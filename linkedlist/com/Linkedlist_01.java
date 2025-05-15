package linkedlist.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Linkedlist_01 {
	public static void traversalLL(Node node) {
		Node<Integer> head = node;
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
//		System.out.println(node.data);
		Node ptr = head;
		while(ptr != null) {
//			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	public static int findNode(Node<Integer> node, int x) {
		Node<Integer> head = node;
		Node<Integer> ptrNode = node;
		while(ptrNode != null) {
			if(ptrNode.data == x) {
				return ptrNode.data;
			}
			node = ptrNode.next;
		}
		return -1;
	}
	public static Node<Integer> createLinkedList(List<Integer> list){
	    Node node = new Node();
	    Node current = node;
	    for(int i =0; i<list.size(); i++) {
	    		Node newNode = new Node(list.get(i));
	    		current.next = newNode;
	    		current = newNode;		
	    }
//	    traversalLL(node);
	    return node.next;
	    
	}
	public static List<Node<Integer>> evenOddList(Node<Integer> node){
		Node<Integer> evenNode = new Node<>();
		Node<Integer> currentEven = evenNode;
		
		Node<Integer> oddNode = new Node<>();
		Node<Integer> currentOdd = oddNode;
		List<Node<Integer>> ansList = new ArrayList<Node<Integer>>();
		
		while(node.next != null) {
			Node curentNode = node.next;
			if((int)curentNode.data %2 ==0) {
				Node newNode = new Node(curentNode.data);
				if(evenNode == null) {
					evenNode = newNode;
				}else {
					currentEven.next = newNode;
					currentEven  = newNode;
					node = curentNode.next;
				}
				
			}else {
				Node newNode = new Node(curentNode.data);
				if(oddNode == null) {
					oddNode = newNode;
				}else {
					currentOdd.next = newNode;
					currentOdd  = newNode;
					node = curentNode.next;
				}
				
			}
		}
		ansList.add(oddNode);
		ansList.add(evenNode);
		return ansList;
	}
	public static List<Node<Integer>> evenOddList2(Node<Integer> head){
		Node<Integer> evenNode = new Node<>(-1);
		Node<Integer> currentEven = evenNode;
		
		Node<Integer> oddNode = new Node<>(-1);
		Node<Integer> currentOdd = oddNode;
		List<Node<Integer>> ansList = new ArrayList<Node<Integer>>();
		
		Node<Integer> current = head;
		while(current != null) {
			if(current.data %2 ==0) {
				Node newNode = new Node<>(current.data);
				currentEven.next = newNode;
				currentEven = newNode;	
			}else {
				currentOdd.next= new Node(current.data);
				currentOdd = currentOdd.next;	
			}
			current = current.next;
		}
		ansList.add(oddNode.next);
		ansList.add(evenNode.next);
		return ansList;
	}
	public static void main(String ar[]) {
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
		
//		traversalLL(n1);
		
	Node<Integer> llNode=createLinkedList(Arrays.asList(1,4,7,9,6,11,17,18,22,27,84,19,23,34,45,56,14,15,20,11,56,43,21));
	
	List<Node<Integer>> result = evenOddList2(llNode);
		for(Node<Integer> lNode : result) {
//			System.out.println(lNode);
			traversalLL(lNode);
			System.out.println();
		}
		
	}
}
