package com.string2;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupOfAnagram {
	public static List<List<String>> groupAnagram(List<String> list){
		List<List<String>> ans = new ArrayList<>();
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).equals("")) continue;
			String str = create(list.get(i));

			List<String> smallRes = new ArrayList<String>();
			smallRes.add(list.get(i));
			for(int j =i+1; j<list.size(); j++) {
				String str1 = create(list.get(j));
				if(str1.equals(str)) {
					smallRes.add(list.get(j));
					list.set(j, "");
				}	
			}
			ans.add(new ArrayList<String>(smallRes));
		}
		System.out.println(ans);
		return ans;
	}
	public static String create(String s) {
		int index[] = new int[26];
		for(int i =0; i<s.length(); i++) {
			index[s.charAt(i)-'a']++;
		}
		String temp="";
		for(int i =0; i<index.length; i++) {
			temp +=index[i];
		}
		return temp;
	}
	public static List<List<String>> groupAnagram2(List<String> list){
		HashMap<String, List<String>> map = new HashMap<>();
//		for(int i =0; i<list.size(); i++) {
//			String str = create(list.get(i));
//			List<String> l = map.getOrDefault(str, null);
//			if(l == null) {
//				l = new ArrayList<String>();
//				String valString = list.get(i);
//				l.add(valString);
//				
//			}else {
//				String valString = list.get(i);
//				l.add(valString);
//			}
//			map.put(str, l);	
//		}
		
		for(int i = 0; i < list.size(); i++) {
	        String str = create(list.get(i));
	        List<String> l = map.get(str);  // Direct get()
	        if(l == null) {
	            l = new ArrayList<>();
	            map.put(str, l); // Put only when new list is created
	        }
	        l.add(list.get(i)); // Common add
	    }
		List<List<String>> result = new ArrayList<>();
		for(Map.Entry<String, List<String>> entry: map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
		
	}
	 public static String createString(String s){
	        int count [] = new int[26];
	        for(int i=0; i<s.length(); i++){
	            count[s.charAt(i) - 'a']++;
	        }
	        String fre ="";
	        char ch ='a';
	        for(int i =0; i<26; i++){
	            fre += ch;
	            fre += String.valueOf(count[ch-'a']);
	            ch++;
	        }
	        return fre;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat", "cat", "rams", "rasm", "masr", "smra", "msar", "samr");
//		groupAnagram(list);
		System.out.println(groupAnagram2(list));
		

	}

}
