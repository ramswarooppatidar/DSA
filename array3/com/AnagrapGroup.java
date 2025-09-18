package array3.com;

import java.util.ArrayList;
import java.util.List;

public class AnagrapGroup {
	
	public static List<List<String>> groupAnagram(String []str){
		List<List<String>> resultList = new ArrayList<>();
		
		for(int i =0; i<str.length; i++) {
			String s = str[i];
			if(s.equals("")) continue;
			String anaString = angramString(s);
			List<String> list = new ArrayList<String>();
			list.add(s);
			for(int j = i+1;j<str.length;j++) {
				String s1 = angramString(str[j]);
				if(anaString.equals(s1)) {
					list.add(str[j]);
					str[j]="";
				}
			}
			resultList.add(list);
		}
		return resultList;
		
	}
	private static String angramString(String str) {
		int index[] = new int[26];
		for(int i = 0; i < str.length();i++) {
			char ch = str.charAt(i);
			index[ch - 'a']++;
		}
		String tempString = "";
		for(int i: index) {
			tempString += i;
		}
		return tempString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] ={"cat", "act", "tac","atc","cta", "eat","bat","tab", "lalli", "allil"};
		
		List<List<String>> resultList = groupAnagram(str);
		System.out.println("result :"+resultList);
	}

}
