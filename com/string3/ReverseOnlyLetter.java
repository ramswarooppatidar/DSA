package com.string3;

public class ReverseOnlyLetter {
	 public static String reverseOnlyLetters(String s) {
	        int left  = 0;
	        int right = s.length() - 1;
	        char ch[] = s.toCharArray(); 
	        while(left<right){
	            if(Character.isLetter(ch[left]) && Character.isLetter(ch[right])){
	                char temp = ch[right];
	                ch[right] = ch[left];
	                ch[left] = temp;
	                left++;
	                right--;
	            }else if(Character.isLetter(ch[left])){
	                right--;
	            }else{
	                left++;
	            }
	        }
	        return new String(ch);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String reString = reverseOnlyLetters("ab-hj-gaha-r");
		System.out.println(reString);

	}

}
