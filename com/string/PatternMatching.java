package com.string;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {

	public static boolean patternMatching(String pattern, String words) {
		HashMap<Character, String> map = new HashMap<>();
		String word[] = words.split(" ");
		for(int i =0; i<pattern.length(); i++) {
			if(!map.containsKey(pattern.charAt(i))) {
				if(!map.containsValue(word[i])) {
					map.put(pattern.charAt(i), word[i]);
				}else {
					return false;
				}
			}else {
				String matchWord = map.get(pattern.charAt(i));
				if(!matchWord.equals(word[i])) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean patMatch(String pat, String wordss) {
		Map<Character, String> map = new HashMap<>();
		String words[] = wordss.split(" ");
		for(int i =0; i<pat.length(); i++) {
			char ch = pat.charAt(i);
			if(map.containsKey(ch)) {
				String matcString = map.get(ch);
				if(!matcString.equals(words[i])) {
					return false;
				}
			}else {
				map.put(ch, words[i]);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(patternMatching("abba", "ram shyam shyam ram"));
		System.out.println(patternMatching("abab", "ram shyam shyam ram"));
		
		System.out.println(patMatch("abba", "ram shyam shyam ram"));
		System.out.println(patMatch("abab", "ram shyam shyam ram"));
	}

}
