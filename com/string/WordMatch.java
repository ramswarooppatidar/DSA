package com.string;

import java.util.HashMap;
import java.util.Map;

public class WordMatch {
	public static boolean patternMatch(String pattern, String s) {
		
		Map<Character, String> match = new HashMap<>();
		Map<String,Character> reverseMatch = new HashMap<>();
		
		String s2[] = s.split(" ");
		
		if(pattern.length() != s2.length) {
			return false;
		}
		
		for(int i =0; i<s2.length; i++) {
			char ch = pattern.charAt(i);
			String word = s2[i];
			if(match.containsKey(ch)) {
				if(!match.get(ch).equals(word)) {
					return false;
				}
			}else {
				if(reverseMatch.containsKey(word)) {
					return false;
				}
				match.put(ch,  word);
				reverseMatch.put(word, ch);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 Input: pattern = "abba", s = "dog cat cat dog"

			Output: true
			
			Explanation:
			
			The bijection can be established as:
			
			'a' maps to "dog".
			'b' maps to "cat".
		 */

		
		System.out.println(patternMatch("abba", "dog cat cat dog"));
		System.out.println(patternMatch("abba", "dog dog cat dog"));
	}

}
