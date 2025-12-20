package com.string3;

public class AlianSort {

	 public static boolean isAlienSorted(String[] words, String order) {
	        int n = words.length;
	        for(int i =0; i<n - 1; i++){
	            String word1 = words[i];
	            String word2 = words[i + 1];
	            int len =  Math.min(word1.length(), word2.length());
	            boolean difference = false;
	            for(int j =0; j<len; j++){
	                char ch1 = word1.charAt(j);
	                char ch2 = word2.charAt(j);
	                if(order.indexOf(ch1) < order.indexOf(ch2)){
	                    difference = true;
	                    break;
	                }else if(order.indexOf(ch1) > order.indexOf(ch2)){
	                    return false;
	                }
	            }
	            if(!difference && word1.length() > word2.length()){
	                return false;
	            }
	        }
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
