package com.string;

import java.util.Stack;

public class EvaluteExpression {

	public static int evaluteExpression(String s) {
		Stack<Integer> stack = new Stack<>();
		char sign = '+';
		int num =0;
		int n = s.length();
		for(int i =0; i<n; i++) {
			char c = s.charAt(i);
			 if(Character.isDigit(c)) {
				 num = num*10 + (c -'0');
			 }
			 
//			 if(!Character.isDigit(c) && c != ' ' || i == n-1) {
			 if ((!Character.isDigit(c) && c != ' ') || i == n - 1) { 
				 if(sign=='+') {
					 stack.push(num);
				 }else if(sign=='-') {
					 stack.push(-num);
				 }else if(sign=='*') {
					 stack.push(stack.pop()*num);
				 }else if(sign=='/') {
					 stack.push(stack.pop()/num);
				 }
				 
				 sign = c;
				 num =0;
			 }
			
				 
		}
		int result = 0;
		for(int i : stack) {
			result += i;
		}
		return result;
	}
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="3*2-11*3-7+5";
		
		System.out.println(evaluteExpression(string));
       
	}

}
