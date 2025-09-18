package com.string2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagram {
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pCount[] = new int[26];
        int sCount[] = new int[26];
        for(char c : p.toCharArray()){
            pCount[c - 'a']++;
        }
        for(int i =0; i<s.length();i++){
            sCount[s.charAt(i) - 'a']++;

            if(i >= p.length()){
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if(Arrays.equals(pCount, sCount)){
                res.add(i-p.length() + 1);
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="cbaebabacd";
		String p="abc";
		findAnagrams(s, p);
		
		String s1 ="abab";
		String p1="ab";
	  List<Integer> res = 	 findAnagrams(s1, p1);
	 
		
		

	}

}
