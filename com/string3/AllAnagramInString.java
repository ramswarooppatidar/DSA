package com.string3;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

public class AllAnagramInString {
	public static int[] allAnagramInString(String str, String s) {
		List<Integer> list = new ArrayList<Integer>();
		int m = s.length();
		int left = 0;
		int right = left + m - 1;
		String anagramIndexString = indexString(s);
		while(right < str.length()) {
			if(anagramIndexString.equals(indexString(str.substring(left, right+1)))) {
				list.add(left);
			}
			left++;
			right = left + m -1;
		}
		System.out.println("list :"+list);
		return null;
	}
	private static String indexString(String s) {
		int index[] = new int[26];
		for(int i =0; i<s.length(); i++) {
			index[s.charAt(i) - 'a']++;
		}
		String tempString ="";
		for(int i =0; i<26; i++) {
			tempString += index[i];
		}
		return tempString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "ababcgabseababchjsababababcabghsjjabcabhdbabbabababbcbbabcbabc";
		allAnagramInString(string, "abc");
		

	}

}
