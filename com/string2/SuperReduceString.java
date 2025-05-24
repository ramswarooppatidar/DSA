package com.string2;

import java.util.Stack;

public class SuperReduceString {
	public static String superReduceString(String s) {
		StringBuilder sb = new StringBuilder();
		for(char ch : s.toCharArray()){
			int len = sb.length();
			if(len > 0 && sb.charAt(len - 1) == ch) {
				sb.deleteCharAt(len - 1);
			}else {
				sb.append(ch);
			}
		}
		 return sb.length() == 0 ? "Empty String" : sb.toString();
//		return sb.length() > 0 ? sb.toString():"Empty String";
	}
	
	public static String superReduceString2(String s) {
		Stack<Character> stack = new Stack();
		for(char ch : s.toCharArray()){

			if( !stack.isEmpty() && stack.peek() == ch) {
				stack.pop();
			}else {
				stack.push(ch);
			}
		}
		if(stack.isEmpty()) {
			return "Empty String";
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : stack) {
			sb.append(ch);
		}
		return sb.toString();
//		return sb.length() > 0 ? sb.toString():"Empty String";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(superReduceString("aabbbs"));
		System.out.println(superReduceString2("aabbbs"));

	}

}
