package com.string;

public class CompressString {

	public static String compressString(String s) {
		String string=new String();
		int n = s.length();
		char c=s.charAt(0);
		for(int i = 0; i<s.length(); i++) {
			c = s.charAt(i);
			int count = 1;
			while(i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
				i++;
				count++;
			}
			string += c;
			string += count;
		}
		return string;
	}
	public static String compress2(String s,String result, int index) {
		if(index == s.length()) {
			return result;
		}
		result += s.charAt(index);
		int count = 1;
		while(index< s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) {
			count++;
			index++;
		}
		result += count;
		return compress2(s, result, index+1);
	}
	public static String compress3(String s, String temp) {
		if(s.length() == 0) {
			return temp;
		}
		int cnt = 1;
		for(int i =1; i<s.length(); i++) {
			if(s.charAt(0) == s.charAt(i)) {
				cnt++;
			}else {
				break;
			}
		}
//		temp += s.charAt(0);
//		temp += cnt;
	    temp += s.charAt(0) + String.valueOf(cnt);
		return compress3(s.substring(cnt), temp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String string = "aaabbccffcccggh";
		String string = "aaabbccccfffffkkkkllllnnnnnccccggh";
		System.out.println(compressString(string));
		System.out.println(compress2(string, "", 0));
		System.out.println(compress3(string, ""));

	}

}
