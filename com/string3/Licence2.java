package com.string3;

public class Licence2 {
	 public static String shortestCompletingWord(String licensePlate, String[] words) {
		 String sortestResultString = "";
		 int minimumLegth = Integer.MAX_VALUE;
		 int freLicence[] = new int[26];
		 
		 
		 for(int i = 0; i<licensePlate.length(); i++) {
			 char ch = licensePlate.charAt(i);
			 if(Character.isLetter(ch)) {
				 freLicence[ch - 'a']++;
			 }
		 }
		 for(String word : words) {
			 int wordLicence[] = new int[26];
			 for(int i =0; i<word.length(); i++) {
				 char ch = word.charAt(i);
				 wordLicence[ch - 'a']++;
			 }
			 boolean isValid = true;
			 for(int i = 0; i<word.length();i++) {
				 if(wordLicence[i]<freLicence[i]) {
					 isValid = false;
				 }
			 }
			 if(isValid) {
				 if(minimumLegth > word.length()) {
					 minimumLegth = word.length();
					 sortestResultString = word;
				 }
			 }
		 }
		 return sortestResultString;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String licensePlate = "sit564ptt";
		String words[] = {"sit", "sittp", "sitttp"};
		String string =  shortestCompletingWord(licensePlate, words);
		System.out.println("result is :"+string);

	}

}
