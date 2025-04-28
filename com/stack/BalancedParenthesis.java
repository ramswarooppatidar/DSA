package com.stack;

import java.util.Stack;

public class BalancedParenthesis {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		if(s.length()%2 != 0) {
			return false;
		}
		for(int i =0;i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch== '(' || ch == '{' || ch== '[') {
				stack.push(ch);
			}else if(!stack.isEmpty() && (
					(ch == ']' && stack.pop() != '[') 
					|| (ch == '}' && stack.pop() != '{')
					|| (ch == ')' && stack.pop() != '(')
					)) {
				return false;
			}					
		}
		 return stack.size()>0 ? false : true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("(()){}[]"));
		System.out.println(isValid("((}){}[]"));
		System.out.println(isValid("(()){}[]"));
	}

}
