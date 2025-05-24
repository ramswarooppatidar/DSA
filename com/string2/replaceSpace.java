package com.string2;

public class replaceSpace {
	public static void replacSpace(String s1){
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<s1.length(); i++) {
			char ch = s1.charAt(i);
			if(ch == ' ') {
				sb.append("%20");
			}else {
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}
	public static void main(String args[]) {
		
	}
}
