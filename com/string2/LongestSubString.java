package com.string2;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class LongestSubString {
	
	public static String longestSubstring(String s) {
		String longestSubString = "";
		StringBuilder sBuilder = new StringBuilder();
		for(int i =0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(sBuilder.indexOf(String.valueOf(ch)) == -1) {
				sBuilder.append(ch);
			}else {
				int length = sBuilder.length();
				if(sBuilder.length()>longestSubString.length()) {
					longestSubString = sBuilder.toString();
//					sBuilder = new StringBuilder();
				}
				while(sBuilder.length()>0 && sBuilder.indexOf(String.valueOf(ch)) != -1) {
					sBuilder.deleteCharAt(0);
				}
				sBuilder.append(ch);
			}
		}
		return sBuilder.length()>longestSubString.length() ? sBuilder.toString() : longestSubString;
	}
	//sliding window
	//time complexity O(n^2) in worst case remove at indexo(n) due to shifting all elements
	public static String longestSubString(String s) {
		List<Character> list = new ArrayList<>();
		int left =0;
//		int right = 0;
		int maxLen = 0;
		String resuString="";
		for(int right = 0; right<s.length(); right++) {
			while(list.contains(s.charAt(right))) {
				list.remove(0);
				left++;
			}
			list.add(s.charAt(right));
			if(right - left + 1>maxLen) {
				maxLen = right - left + 1;
				resuString = s.substring(left, right+1);
			}
		}
		return resuString;
	}
	
	public static String longestSubStringOptimized(String s) {
		Set<Character> set = new HashSet();
		int left =0;
//		int right = 0;
		int maxLen = 0;
		String resuString="";
		for(int right = 0; right<s.length(); right++) {
			while(set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			if(right - left + 1>maxLen) {
				maxLen = right - left + 1;
				resuString = s.substring(left, right+1);
			}
		}
		return resuString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string ="aab";
	String reString=	longestSubString(string);
	System.out.println(reString);
	
	String string1 ="aab";
	String reString1 =	longestSubStringOptimized(string1);
	System.out.println(reString1);
	
	String reString2 = longestSubstring("aab");
	System.out.println(reString2);

	}

}
