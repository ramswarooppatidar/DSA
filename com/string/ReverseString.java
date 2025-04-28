package com.string;

public class ReverseString {

	public static String revere(String s) {
		String s1 = s.trim();
		String str[] = s1.split("\\s+");
		String resultString ="";
		for(int i = str.length-1; i>=0; i--) {
//			if(str[i] != " ")
			resultString += str[i].trim() + " ";  //remove at last
		}
		System.out.println(resultString);
		return resultString.trim(); //here removed last space
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		revere("i am ram");
		revere(" there is some issue ");
		revere(" all is   well ");
	}

}
