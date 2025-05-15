package com.string;

public class AddIntegerString {

	public static String addString(String num1, String num2) {
		StringBuilder sBuilder = new StringBuilder();
		int i = num1.length() -1;
		int j = num2.length() -1;
		int carray = 0;
		/*
		 || carray != 0   this condition for   num1 = "1"  num2="9"  then carry need to add at last
		 */
		while(i >= 0 || j >= 0 || carray != 0) {
			int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
			int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
			int sum = digit1 + digit2 + carray;
			sBuilder.append(sum%10);
			
			carray = (sum/10);
		}
		return sBuilder.reverse().toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(addString("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", "7777777777777777777777777777777777777452714716487111111111114365235623752333379999999999999999999999999999999999999999999999999999453678399292"));

	}

}
