package com.string3;

import java.util.ArrayList;
import java.util.List;

public class ShortestToChar {

	 public static int[] shortestToChar(String s, char c) {
		 int res[] = new int[s.length()];
		 List<Integer> charIndexes = new ArrayList<Integer>() ;
		 for(int i =0; i<s.length(); i++) {
			 char ch = s.charAt(i);
			 if(ch == c) {
				 charIndexes.add(i);
			 }
		 }
		 for(int i =0; i<s.length(); i++) {
			 int min = s.length();
			 for(int j : charIndexes) {
				 if(Math.abs(i - j) < min) {
					 min = Math.abs(i - j);
				 }
			 }
			 res[i] = min;
		 }
		 return res;
		 
	 }
	public static void main(String[] args) {
		/*
		 Input: s = "loveleetcode", c = "e"
         Output: [3,2,1,0,1,0,0,1,2,2,1,0]
		 */
		String s = "loveleetcode";
		char c = 'e';
		
		int res[] = shortestToChar(s, c);
		for(int i : res) {
			System.out.print(i+" ");
		}

	}

}
