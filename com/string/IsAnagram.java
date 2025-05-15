package com.string;

public class IsAnagram {

	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		int index[] = new int[26];
		for(int i =0; i<s.length(); i++) {
			index[s.charAt(i) - 'a']++;
			index[t.charAt(i) - 'a']--;
		}
		for(int i : index) {
			if(i != 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
