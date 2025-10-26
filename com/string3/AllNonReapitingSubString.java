package com.string3;

public class AllNonReapitingSubString {
	public static String longestSubWithoutRepeting(String str) {
		String longestSubString = "";
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<str.length(); i++) {
			char ch = str.charAt(i);
			int len = sb.capacity();
			while(len > 0 && sb.indexOf(String.valueOf(ch)) != -1) {
				sb.deleteCharAt(0);
			}
			sb.append(ch);
			if(sb.capacity() > longestSubString.length()) {
				longestSubString = sb.toString();
			}
		}
		System.out.println("result :"+longestSubString);
		return longestSubString;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcbahmnfbjshachej";
		longestSubWithoutRepeting(str);
		

	}

}
