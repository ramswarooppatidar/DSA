package com.string2;

import java.util.HashMap;
import java.util.Map;

public class firstNonReapitingChar {
	public static void firstNonRepatingChar(String str) {
		int index[]= new int[26];
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			index[ch - 'a']++;
		}
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			if(index[ch - 'a'] == 1) {
				System.out.println(ch);
				break;
			}
		}
		
	}
	public static void firtNonRepatingChar2(String str) {
		int index[] = new int[26];
		for(int i =0; i<str.length(); i++) {
			index[str.charAt(i) - 'a']++;
		}
		for(char ch : str.toCharArray()) {
			if(index[ch - 'a'] == 1) {
				System.out.println(ch);
				break;
			}
		}
	}
	public static void firtNonRepatingChar3(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char ch : str.toCharArray()){
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		for(char ch : str.toCharArray()) {
			if(map.get(ch) == 1) {
				System.out.println(ch);
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "sddsghahjrgsfga";
		firstNonRepatingChar(string);
		firtNonRepatingChar3(string);

	}

}
