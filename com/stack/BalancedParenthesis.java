package com.stack;

import java.security.Identity;
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
//	public static boolean isValid2(String str) {
//		int count=0;
//		Stack<Character> stack = new Stack<>();
//		for(int i =0; i<str.length(); i++) {
//			char ch = str.charAt(i);
//			if(ch == '*') {
//				count++;
//				stack.push(ch);
//			}else if(ch == '(') {
//				stack.push(ch);
//			}else {
//				if(stack.peek() != '(' || stack.peek() != '*') {
//					return false;
//				}
//				if(!stack.isEmpty()) {
//					stack.pop();
//				}
//			}
//		}
//		return stack.size() == 0;
//	}
	public static boolean isValid2(String str) {
	    Stack<Integer> open = new Stack<>();
	    Stack<Integer> star = new Stack<>();

	    for (int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        if (ch == '(') {
	            open.push(i);
	        } else if (ch == '*') {
	            star.push(i);
	        } else if (ch == ')') {
	            if (!open.isEmpty()) {
	                open.pop();
	            } else if (!star.isEmpty()) {
	                star.pop(); // treat * as (
	            } else {
	                return false;
	            }
	        }
	    }

	    // Now check unmatched '(' must be closed by a later '*'
	    while (!open.isEmpty() && !star.isEmpty()) {
	        if (open.pop() > star.pop()) {
	            return false;
	        }
	    }

	    return open.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("(()){}[]"));
		System.out.println(isValid("((}){}[]"));
		System.out.println(isValid("(()){}[]"));
		System.out.println(isValid2("(*))*)"));
	}

}
