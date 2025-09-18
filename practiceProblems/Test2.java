package practiceProblems;

import java.nio.channels.NonWritableChannelException;
import java.util.*;

public class Test2 {
	public static List<List<String>> groupOfAnagram(String str[]){
		List<List<String>> ans = new ArrayList<>();
		for(int i =0; i<str.length; i++) {
			List<String> list = new ArrayList<String>();
			if(str[i].equals("")) continue;
			String charCountString = charCountString(str[i]);
			list.add(str[i]);
			for(int j = i + 1; j<str.length; j++) {
				if(charCountString(str[j]).equals(charCountString)) {
					list.add(str[j]);
					str[j]="";
				}
			}
			ans.add(list);
		}
		
		return ans;
	}
	private static String charCountString(String str) {
		int index[] = new int[26];
		for(int i =0; i<str.length(); i++) {
			char ch = str.charAt(i);
			index[ch - 'a']++;
		}
		String charCountString="";
		for(int i:index) {
			charCountString += i;
		}
		return charCountString;
	}
	public static String superReductString(String word) {
		StringBuilder sBuilder = new StringBuilder();
		for(int i =0; i<word.length();i++) {
			char ch = word.charAt(i);
			int len = sBuilder.length();
			if(len > 0 && sBuilder.charAt(len - 1) == ch) {
				sBuilder.deleteCharAt(len -1);
			}else {
				sBuilder.append(ch);
			}
		}
		return sBuilder.length() > 0 ? sBuilder.toString() : "Empty String";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[]= {"eat", "ate", "aet", "don", "ond","sim", "anu", "nua", "aun","una","ram"};
		//output = [ [eat, ate, aet], [don, ond], [sim], [anu, nua, aun, una] ];
		List<List<String>> ansList = groupOfAnagram(str);
		System.out.println("list :"+ansList);
				

	}

}
