package com.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWordKeyboard {
	public static String[] findWords(String[] words) {
	    Map<Character, Integer> rowMap = new HashMap<>();

	    // Row 0 -> "qwertyuiop"
	    // Row 1 -> "asdfghjkl"
	    // Row 2 -> "zxcvbnm"
	    String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

	    for (int i = 0; i < rows.length; i++) {
	        for (char c : rows[i].toCharArray()) {
	            rowMap.put(c, i);  // map character to its row number
	        }
	    }
	    System.out.println(rowMap);

	    List<String> result = new ArrayList<>();

	    for (String word : words) {
	        String lower = word.toLowerCase();
	        int firstRow = rowMap.get(lower.charAt(0)); // get row of first character
	        boolean sameRow = true;

	        for (char c : lower.toCharArray()) {
	            if (rowMap.get(c) != firstRow) {
	                sameRow = false;
	                break;
	            }
	        }

	        if (sameRow) {
	            result.add(word); // word is valid
	        }
	    }

	    return result.toArray(new String[0]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findWords(new String[] {"hello", "ram", "patidar"});
		/*
		 Given an array of strings words, return the words that can be typed using letters of the alphabet on
		  only one row of American keyboard like the image below.

		Note that the strings are case-insensitive, both lowercased and uppercased of the same letter are 
		treated as if they are at the same row.
		
		In the American keyboard:
		
		the first row consists of the characters "qwertyuiop",
		the second row consists of the characters "asdfghjkl", and
		the third row consists of the characters "zxcvbnm".
		
		Example 1:

		Input: words = ["Hello","Alaska","Dad","Peace"]
		
		Output: ["Alaska","Dad"]
		
		Explanation:
		
		Both "a" and "A" are in the 2nd row of the American keyboard due to case insensitivity.
		
		Example 2:
		
		Input: words = ["omk"]
		
		Output: []
		
		Example 3:
		
		Input: words = ["adsdf","sfd"]
		
		Output: ["adsdf","sfd"]
		
		 
		
		Constraints:
		
		1 <= words.length <= 20
		1 <= words[i].length <= 100
		words[i] consists of English letters (both lowercase and uppercase). 

		 */
	}

}
