package com.string;

public class DedectCapital {
	/*
	 We define the usage of capitals in a word to be right when one of the following cases holds:

		All letters in this word are capitals, like "USA".
		All letters in this word are not capitals, like "leetcode".
		Only the first letter in this word is capital, like "Google".
	 Given a string word, return true if the usage of capitals in it is right.
	 */
	public static boolean detectCaptial(String word) {
		
		if(word.equals(word.toUpperCase())) {
			return true;
		}
		
		if(word.equals(word.toLowerCase())) {
			return true;
		}
		
		if(word.charAt(0) == word.toUpperCase().charAt(0)
				&& word.substring(1, word.length()).equals(word.substring(1,word.length()).toLowerCase())
				){
			return true;
		}
//		 if(word.charAt(0) == word.toUpperCase().charAt(0)
//			       && word.substring(1,word.length()).equals(word.substring(1,word.length()).toLowerCase()) ){
//			        return true;
//			       }
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(detectCaptial("HELLO"));
		System.out.println(detectCaptial("leetcode"));
		System.out.println(detectCaptial("True"));
		System.out.println(detectCaptial("TruE"));

	}

}
