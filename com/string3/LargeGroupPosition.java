package com.string3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPosition {

	 public static List<List<Integer>> largeGroupPositions(String s){
		 List<List<Integer>> resList = new ArrayList<>();
		 
		 for(int i =0; i<s.length(); i++) {
			 int count = 1;
			 int start = i;
			 while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				 count++;
				 i++;
			 }
			 if(count > 2) {
				 List<Integer> list = new ArrayList<Integer>(Arrays.asList(start, start + count - 1));
				 resList.add(list);
				 
			 }
		 }
		return resList;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdddeeeeaabbbcd";
		
		 List<List<Integer>> resList = largeGroupPositions(s);
		 System.out.println(resList);
	}

}
