package com.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
	public static boolean isIshmorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<>();
		for(int i =0; i<s.length(); i++) {
			if(!map.containsKey(s.charAt(i))) {
				if(!map.containsValue(t.charAt(i))) {
					map.put(s.charAt(i), t.charAt(i));
				}else {
					return false;
				}
			}else {
				char mapped = map.get(s.charAt(i));
				if(mapped != t.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIshmorphic("abb", "dgg"));
		System.out.println(isIshmorphic("aba", "dgg"));
		System.out.println(isIshmorphic("Ram", "shy"));

	}

}
