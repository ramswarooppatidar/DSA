package com.string;

public class RepetedSubstring {

	public static boolean repetedString(String s) {
		String doubledString = s + s;
		String trimmedString = doubledString.substring(1, doubledString.length() - 1);
		return trimmedString.contains(s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(repetedString("abab"));
     System.out.println(repetedString("abcdabcd"));
     System.out.println(repetedString("abc"));
	}

}
