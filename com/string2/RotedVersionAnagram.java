package com.string2;

public class RotedVersionAnagram {

	public static boolean isRotedAnagram(String s1, String rotedAnagram) {
		int n = rotedAnagram.length();
		char ch[] = rotedAnagram.toCharArray();
		int k=0;
		while(k<n) {
			System.out.println("rotetaion is :"+k);
			char temp = ch[n-1];
			for(int i =n-1; i>0; i--) {
				ch[i]=ch[i-1];
			}
			ch[0] = temp;
			String check = new String(ch);
			if(s1.equals(check)) {
				return true;
			}
			k++;	
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ramswaroop";
		String s2 = "oopramswar";
		System.out.println(isRotedAnagram(s2, s1));

	}

}
