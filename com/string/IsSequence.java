package com.string;

public class IsSequence {
	 public static boolean isSubsequence(String s, String t) {
		 int k =0;
		 for(int i =0; i<t.length() && k< s.length(); i++) {
			 if(t.charAt(i) == s.charAt(k)) {
				 k++;
			 }
		 }
		 return k == s.length();
	 }
	public static void main(String[] args) {
		/*
		Example 1:
		Input: s = "abc", t = "ahbgdc"
		Output: true
		
		Example 2:
		Input: s = "axc", t = "ahbgdc"
		Output: false
 
		 */
		System.out.println(isSubsequence("abc","ahbgdc" ));
		System.out.println(isSubsequence("","ahbgdc" ));
		System.out.println(isSubsequence("axc","ahbgdcx" ));

	}

}
