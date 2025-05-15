package com.string;

public class Multiplication {
	
	public static String multiplication(String num1, String num2) {
		 int l1 = num1.length();
		 int l2 = num2.length();
		 int result[] = new int[l1 + l2 + 1];
		 for(int i = l1 -1; i>=0; i--) {
			 int d1 = num1.charAt(i) - '0';
			 for(int j = l2 -1; j>=0; j--) {
				 int d2 = num2.charAt(j) - '0';
				 int mult = d1 * d2;
				 int sum = mult +  result[i + j+1];
				 
				 result[i + j+1] = sum %10;
				 result[i+j] += sum/10;   //carry for next step;
				 
			 }
		 }
		 StringBuilder sb = new StringBuilder();
		 for(int num : result) {
			 sb.append(num);
		 }
		 return sb.toString();
	}
	public static String addingString(String num1, String num2) {
		int i = num1.length() -1;
		int j = num2.length() -1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(i>=0 || j>=0 || carry != 0) {
			int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
			int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
			int sum = digit1 + digit2 + carry;
			sb.insert(0, sum%10);
			carry = sum/10;	
		}
		return sb.toString();
		}
  public static void main(String arg[]) {
	  System.out.println(multiplication("12", "334356356789897654"));
	  System.out.println(addingString("12342", "10003"));
  }
}
