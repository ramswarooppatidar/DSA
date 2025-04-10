package linkedlist.com;

//import java.lang.classfile.components.ClassPrinter.ListNode;

public class oddEvenList {
	 public Node oddEvenList(Node head) {
	        if(head == null){
	            return head;
	        }
	        Node odd = head;
	        Node even = head.next;
	        Node evenHead = even;
	        while(even != null && even.next != null){
	            odd.next =odd.next.next;
	            odd = odd.next;

	            even.next = even.next.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        return head;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
