package com.string4;

public class RemoveOutermostParenthesis {
	public static String removeOutermostParenthesis(String s) {
		StringBuilder sb = new StringBuilder();
		int depth = 0;
		for(char c : s.toCharArray()) {
			if(c == '(') {
				if(depth > 0) {
					sb.append(c);
				}
				depth++;
			}else if(c == ')') {
				depth--;
				if(depth > 0) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeOutermostParenthesis("() ( () ) (()()) ( () (()) )"));

	}

}
