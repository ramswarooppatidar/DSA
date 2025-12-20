package com.string3;

public class NumberOfLines {
	
	public static int[] numberOfLines(int[] widths, String s) {
		int res[] = new int[2];
		int width =0;
		int line = 1;
		for(int i =0; i<s.length(); i++) {
			char ch = s.charAt(i);
			int w = widths[ch - 'a'];
			if(width + w > 100) {
				line++;
				width = w;
			}else {
				width += w;
			}
		}
		res[0] = line;
		res[1] = width;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,
				10,10,10,10,10,10,10,10,10,10,10,10};
		String s = "abcdefghijklmnopqrstuvwxyz";
		
		int res1[] = numberOfLines(widths, s);
		for(int i : res1) {
			System.out.print(i+" ");
		};
		System.out.println();
		
		
		int [] widths2 = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String s2 = "bbbcccdddaaa";
		int res2[] = numberOfLines(widths2, s2);
		for(int i : res2) {
			System.out.print(i+" ");
		};


		/*
		 Example 1:

		Input: widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "abcdefghijklmnopqrstuvwxyz"
		Output: [3,60]
		Explanation: You can write s as follows:
		abcdefghij  // 100 pixels wide
		klmnopqrst  // 100 pixels wide
		uvwxyz      // 60 pixels wide
		There are a total of 3 lines, and the last line is 60 pixels wide.
		Example 2:
		
		Input: widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "bbbcccdddaaa"
		Output: [2,4]
		Explanation: You can write s as follows:
		bbbcccdddaa  // 98 pixels wide
		a            // 4 pixels wide
		There are a total of 2 lines, and the last line is 4 pixels wide.
		 */

	}

}
