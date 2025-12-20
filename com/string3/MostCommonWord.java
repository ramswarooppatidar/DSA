package com.string3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	 public static  String mostCommonWord(String paragraph, String[] banned) {
		 Set<String> ban = new HashSet<>(Arrays.asList(banned));
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 
		 String word[] = paragraph.toLowerCase().split("[^a-zA-Z]+");
		 for(String s : word) {
			 map.put(s, map.getOrDefault(s, 0) + 1);
		 }
		 
		 int count =0;
		 String reString = null;
		 for(Map.Entry<String, Integer> entry : map.entrySet()) {
			 String key = entry.getKey();
			 if(!ban.contains(key) && count < entry.getValue()) {
				 reString = key;
				 count = entry.getValue();
			 }
		 }
		 return reString;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
			Output: "ball"
			
			Example 2:
			
			Input: paragraph = "a.", banned = []
			Output: "a"
		 */

	}

}
