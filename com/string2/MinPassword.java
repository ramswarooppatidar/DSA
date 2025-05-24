package com.string2;

public class MinPassword {
	public static int minimumNumber(int n, String password) {
	    // Return the minimum number of characters to make the password strong
	    int number =0;
	    int lower =0;
	    int upper =0;
	    int special=0;
	    int added=0;
	      for(char ch : password.toCharArray()){
	         if(Character.isUpperCase(ch)){
	            upper++;
	         }else if(Character.isLowerCase(ch)){
	            lower++;
	         }else if(Character.isDigit(ch)){
	            number++;
	         }else{
	            special++;
	         }
	      }
	 
	        if(number<1){
	            added++;
	        }
	        if(lower<1){
	            added++;
	        }
	        if(upper<1){
	            added++;
	        }
	        if(special<1){
	            added++;
	        }
	         return Math.max(added, 6 - n);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
