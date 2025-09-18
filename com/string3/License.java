package com.string3;

import java.util.HashMap;
import java.util.Map;

import array.com.CountCoverdBuilding;

public class License {
	 public static String shortestCompletingWord(String licensePlate, String[] words) {
	       
	        int sortLength = Integer.MAX_VALUE;
	        String result = "";
	        licensePlate = licensePlate.toLowerCase();
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i =0; i<licensePlate.length(); i++){
	        	char ch = licensePlate.charAt(i);
	            if(Character.isLetter(ch)) {
	            	map.put(ch, map.getOrDefault(ch, 0)+1);
	            }
	        }
	        System.out.println("map :"+map);
	       
	        for(int i =0; i<words.length; i++) {
	        	Map<Character, Integer> map2 = new HashMap<>(map);
	        	String word = words[i];
	        	for(int j =0; j<word.length(); j++) {
	        		char ch = word.charAt(j);
	        		if(map2.containsKey(ch)) {
	        			int count = map2.get(ch);
	        			if(count == 1) {
	        				map2.remove(ch);
	        			}else {
	        				map2.put(ch, count - 1);
	        			}
	        		}
	        	}
	        	 if(map2.isEmpty()) {
	        		 if(sortLength > word.length()) {
	        			 sortLength = word.length();
	        			 result = word;
	        			 
	        		 }
	        	 }
	        }
	        return result;	       
	    }
	 
	 public static String shortestCompletingWord2(String licence, String [] words) {
		 
		 licence = licence.toLowerCase();
		 int licFreq[] = new int[26];
		 String result = "";
		 
		 int minLength = Integer.MAX_VALUE;
		 for(int i =0; i<licence.length(); i++) {
			 char ch = licence.charAt(i);
			 if(Character.isLetter(ch)) {
				 licFreq[ch - 'a']++;
			 }
		 }
		 
		 for(String word : words) {
			 int wordFre[] = new int[26];
			 System.out.println("word is :"+word);
			 for(int i =0; i<word.length(); i++) {
				 char ch = word.charAt(i);
				 wordFre[ch - 'a']++;
			 }
			 
			 boolean isValid = true;
			 for(int j = 0; j<26; j++) {
				 if(wordFre[j] < licFreq[j]) {
					 isValid = false;
					 break;
				 }
			 }
			 
			 if(isValid && word.length()<minLength) {
				 minLength = word.length();
				 result = word;
			 }
		 }
		 return result;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = {"step","steps","stripe","stepple"};
		 String string= shortestCompletingWord("1s3 PSt",words );
		 System.out.println("result :"+string);
		 
		 String resultString = shortestCompletingWord2("1s3 PSt", words);
		 System.out.print("result :"+resultString);
	}

}
