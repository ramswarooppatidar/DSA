package com.string;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
	
	public static boolean canConstruct(String ransomeNote,String magazine) {
		int []index = new int[27];
		for(int i =0; i<magazine.length(); i++) {
			index[magazine.charAt(i)-'a']++;
		}
		
		for(int i =0; i<ransomeNote.length(); i++) {
			if(--index[ransomeNote.charAt(i)-'a'] < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean canConstruct2(String ransomeNote,String magazine) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char ch : magazine.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for(char ch : ransomeNote.toCharArray()) {
			if(!map.containsKey(ch) || map.get(ch) == 0) {
				return false;
			}
			  map.put(ch, map.get(ch) - 1);
		}
		return true;
	}
	
	public static boolean canConstruct3(String ransomeNote,String magazine) {
		StringBuilder sb = new StringBuilder(magazine);
		for(char ch : ransomeNote.toCharArray()) {
			int index = sb.indexOf(String.valueOf(ch));
			if(index == -1) {
				return false;
			}
			sb.deleteCharAt(index);
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canConstruct("ab", "aab"));
		System.out.println(canConstruct("aab", "baa"));
		System.out.println(canConstruct("bf", "fgadjtfwruifhjnkmb"));
		
		System.out.println();
		System.out.println(canConstruct2("ab", "aab"));
		System.out.println(canConstruct2("aab", "baa"));
		System.out.println(canConstruct2("bfffff", "fgadjtfwruifhjnkmb"));
		
		System.out.println();
		System.out.println(canConstruct3("ab", "aab"));
		System.out.println(canConstruct3("aab", "baa"));
		System.out.println(canConstruct3("bffff", "fgadjtfwruifhjnkmb"));


	}

}
