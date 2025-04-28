package com.string;

public class FindDifference {
	    public static char findTheDifference(String s, String t) {
	        int tsum = 0;
	        int sum = 0;
	        for(int i =0; i<t.length(); i++){
	             tsum += t.charAt(i);
	             if(i<s.length()){
	              sum +=  s.charAt(i); 
	             }
	        }
	        // for(int i =0; i<s.length(); i++){
	        //      sum +=  s.charAt(i);
	        // }
	        return (char) (tsum -sum);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findTheDifference("abcd", "abcdf");
		System.out.println(findTheDifference("abcd", "abcdf"));
		System.out.println(findTheDifference("abc", "abcd"));
		System.out.println(findTheDifference("", "a"));
	}

}
