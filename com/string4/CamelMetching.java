package com.string4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class CamelMetching {
    public static List<Boolean> matchCamle(String []quires, String pattern){
    	List<Boolean> result = new ArrayList<Boolean>();
    	for(String word : quires) {
    		int p =0;
    		boolean isMatch = true;
    		for(char c : word.toCharArray()) {
    			if(p < pattern.length() && c == pattern.charAt(p)) {
    				p++;
    			}else if(Character.isUpperCase(c)) {
    				isMatch = false;
    				break;
    			}
    		}
    	
    		result.add(p == pattern.length() && isMatch);
    		
    	 }
    	return result;
    	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//leetcode 1023  description

	}

}
