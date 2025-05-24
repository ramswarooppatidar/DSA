package com.string2;

public class StringDigitSum {
	public static int digitSum(String str) {
		int sum =0;
		for(int i =0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(Character.isDigit(ch)) {
				int k =0;
				while(Character.isDigit( str.charAt(i))) {
					k = k*10 + Integer.parseInt(String.valueOf(str.charAt(i)));
					i++;
				}
				
				
				sum += k;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "R1a2u3ms4wa5roop";
	int sum = 	digitSum(string);   //output 15
	System.out.println("sum is :"+sum);
	}

}
