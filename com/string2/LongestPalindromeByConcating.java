package com.string2;

import java.util.HashMap;

public class LongestPalindromeByConcating {

	public static int longestPalindromLength(String []words) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int length = 0;
		for(String word : words) {
			String rev = new StringBuilder(word).reverse().toString();
			if(map.containsKey(rev) && map.get(rev)>0) {
				length += 4;
				map.put(rev, map.get(rev) - 1);
			}else {
				map.put(word, map.getOrDefault(map, 0)+1);
			}
		}
		//check for middle 
		for(String str : map.keySet()) {
			if(str.charAt(0) == str.charAt(1) && map.get(str)>0) {
				length += 2;
				break;
			}
		}
		return length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1[] = {"ab", "ba", "cc","ll","ba"};
		System.out.println(longestPalindromLength(s1));

	}

}
