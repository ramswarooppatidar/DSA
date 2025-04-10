package linkedlist.com;

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
			System.out.println(ptr.data);
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
		
		traversalLL(n1);
		
	}
}
