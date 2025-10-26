package com.string;

public class ExcelProblem {
	public static String convertToTitle(int colNum) {
		StringBuilder sb = new StringBuilder();
		while(colNum >0) {
			int rem = (colNum-1) % 26;
			char ch = (char)('A' + rem);
			sb.append(ch);
			colNum = (colNum - 1)/26;
		}
		return sb.reverse().toString();
	}
	 public static int titleToNumber(String columnTitle) {
	        int n = columnTitle.length();
	        int val=0;
	        for(int i =0; i<n; i++){
	            val = val*26 + (columnTitle.charAt(i) - 'A' + 1);
	        }
	        return val;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(26));
		System.out.println(titleToNumber("AHGD"));

	}

}
