package linkedlist.com;import java.awt.HeadlessException;
import java.util.Arrays;

public class RemoveDublicate {

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
	public static Node removeDublicte2(Node head) {
		Node prev = head;
		Node temp = prev.next;
		while(temp != null) {
			if(prev.data == temp.data) {
				temp = temp.next;
				continue;
			}
			
			prev.next = temp;
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist_01 o1 = new Linkedlist_01();
		 Node llNode = o1.createLinkedList(Arrays.asList(1,2,2,2,2,3,3,4,5,6,7,7,7,7,7));
		 Node resultNode= removeDublicte2(llNode);
		 o1.traversalLL(resultNode);

	}

}
