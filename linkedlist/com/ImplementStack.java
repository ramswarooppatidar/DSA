package linkedlist.com;

import java.awt.HeadlessException;
import java.util.Queue;

public class ImplementStack {
	 private static Node<Integer> head;

	 public static void push2(int val) {
//		 this is work for Queue data
		 Node newNode = new Node(val);
		 if(head == null) {
			 head = newNode;
		 }else {
			 Node currentNode = head;
			 while(currentNode.next != null) {
				 currentNode = currentNode.next;
			 }
			 currentNode.next = newNode;
		 }
		 
	 }
	 public static void push(int val) {
		 Node newNode = new Node(val);
		 if(head == null) {
			 head = newNode;
		 }else {
			newNode.next = head;
			head = newNode;
		 }
		 
	 }
	 public static int top() {
		 return head.data;
	 }
	 public static int pop() {
		 int data = top();
		 head = head.next;
		 return data;
	 }
	 public static boolean isEmpty() {
		 return size() == 0;
	 }
	 public static int size() {
		 Node currentNode = head;
		 int count =0;
		 while(currentNode != null) {
			 count++;
			 currentNode = currentNode.next;
		 }
		 return count;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStack o1 = new ImplementStack();
		o1.push(1);
		o1.push(12);
		o1.push(35);
		System.out.println(o1.top());
		System.out.println(o1.pop());
		System.out.println(isEmpty());
		System.out.println(size());
		System.out.println(o1.top());
		
  
	}

}
