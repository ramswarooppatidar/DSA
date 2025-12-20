package com.string3;

public class GoatLatin {
	
	 public static String toGoatLatin(String sentence) {
	        String words[] = sentence.split(" ");
	        String res = "";
	         int count =0;
	        for(int i =0; i<words.length; i++){
	            String w = words[i];
	            char ch = w.charAt(0);
	            String word="";
	            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
	                word += w;
	                 word += "ma";
	                 int k =0;
	                 while(k<i + 1){
	                    word += 'a';
	                    k++;
	                 } 
	            }else if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
	                word += w;
	                 word += "ma";
	                 int k =0;
	                 while(k<i + 1){
	                    word += 'a';
	                    k++;
	                 } 
	            }
	            else{
	                word += w.substring(1,w.length());
	                word += ch;
	                word += "ma";
	                int k =0;
	                 while(k<i + 1){
	                    word += 'a';
	                    k++;
	                 } 
	            }
	            res += word;
	            res += " ";
	        }
	        return res.trim();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I speak Goat Latin";
		//outpur = "Imaa peaksmaaa oatGmaaaa atinLmaaaaa";
		String res = toGoatLatin(s);
		System.out.print(res);
		/*
		 You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.

		We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
		
		If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
		For example, the word "apple" becomes "applema".
		If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
		For example, the word "goat" becomes "oatgma".
		Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
		For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
		Return the final sentence representing the conversion from sentence to Goat Latin.
		
		 
		
		Example 1:
		
		Input: sentence = "I speak Goat Latin"
		Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
		Example 2:
		
		Input: sentence = "The quick brown fox jumped over the lazy dog"
		Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
				 */

	}

}
