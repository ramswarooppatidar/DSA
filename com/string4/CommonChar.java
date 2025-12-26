package com.string4;

import java.util.ArrayList;
import java.util.List;

public class CommonChar {
	
	public static List<String> commonChar(String words[]){
		int minFrq[] = new int[26];
		List<String> results = new ArrayList<>();
		for(int i =0; i<words[0].length(); i++) {
			char ch = words[0].charAt(i);
			minFrq[ch - 'a']++;
		}
		
		for(String word : words) {
			int n = word.length();
			int currFrq[] = new int[26];
			for(int j =0; j<n; j++) {
			 currFrq[word.charAt(j) - 'a']++;
			}
			
			for(int i =0; i<26; i++) {
				minFrq[i] = Math.min(minFrq[i], currFrq[i]);
			}
		}
		
		for(int i =0; i<26; i++) {
			while(minFrq[i] > 0) {
				results.add(String.valueOf((char)('a'+ i)));
				minFrq[i]--;
			}
		}
		return results;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> results = commonChar(new String[] {"bella", "label", "roller"});
		System.out.println(results);
		
		List<String> result2s = commonChar(new String[] {"eat", "ate", "tea"});
		System.out.println(result2s);

	}

}
