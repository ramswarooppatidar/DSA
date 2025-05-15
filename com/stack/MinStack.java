package com.stack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack ;
	Stack<Integer> minStack;
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>(); 
	}
	public void push(int val) {
		if(minStack.isEmpty() || val <= minStack.peek()) {
			minStack.push(val);
		}else {
			minStack.push(minStack.peek());
		}
		stack.push(val);
	}
	public int getMin() {
		return minStack.peek();
	}
	public int pop() {
		minStack.pop();
		return stack.pop();
	}
	public int top() {
		return stack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println("min is : "+minStack.getMin()); // return -3
		minStack.pop();
		System.out.println("top is :"+minStack.top());   // return 0
		System.out.println("min is : "+minStack.getMin()); // return -2
		
	}

}
