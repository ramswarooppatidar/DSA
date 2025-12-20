package com.string3;

import java.util.HashSet;
import java.util.Set;

public class UniqeMoresReprsentation {

	 public int uniqueMorseRepresentations(String[] words) {
	        Set<String> set = new HashSet<>();
	        String morse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

	        for(int i =0;i<words.length; i++){
	            String word = words[i];
	            String str = "";
	            for(int j =0; j<word.length(); j++){
	                char ch = word.charAt(j);
	                str += morse[ch - 'a'];
	            }
	            set.add(new String(str));
	        }
	        return set.size();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
