package com.string;

public class AddBinary {

	  public static String addBinary(String a, String b) {
	        int i = a.length()-1;
	        int j = b.length()-1;
	        int carray =0;
	        StringBuilder sb = new StringBuilder();
	        while(i>=0 || j>= 0 || carray != 0){
	            int d1 = i>=0 ? a.charAt(i--)-'0' : 0;
	            int d2 = j>=0 ? b.charAt(j--) - '0' : 0;
	            int sum = d1 + d2 + carray;
	            sb.append(sum % 2);
	            carray = sum/2;
	        }
	           return sb.reverse().toString();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
