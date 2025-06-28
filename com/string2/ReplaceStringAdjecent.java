package com.string2;

public class ReplaceStringAdjecent {
	public static String removeAdjacent(String s) {
		boolean change = true;
		while(change) {
			change = false;
			StringBuilder sb = new StringBuilder();
			int i =0;
			while(i < s.length()) {
				if(i < s.length() - 1 && removeAdjacent(s.charAt(i), s.charAt(i+1))) {
					i += 2;
					change = true;
			    }else {
			    	sb.append(s.charAt(i));
			    	i++;
			    }	
			}
			s = sb.toString();
		}
		return s;
	}
	private static boolean removeAdjacent(char a, char z) {
		return Math.abs(a - z) == 1 || (a == 'a' && z == 'z') || (a == 'z' && z == 'a');
	}
	public static String manipulate(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<s.length(); i++) {
			int len = sb.length();
			char ch = s.charAt(i);
			if(len>0 && check(sb.charAt(len - 1), ch)) {
				sb.deleteCharAt(len - 1);
			}else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	public static boolean check(char a, char b) {
		return Math.abs(a - b) == 1 || (a == 'z' && b == 'a') || (a == 'a' && b == 'z');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = removeAdjacent("abc");
		System.out.println(string);
		
		String string1 = removeAdjacent("zadb");
		System.out.println(string1);
		
		String string2 = removeAdjacent("llgjfilkhgiil");  //llgil
		System.out.println(string2);
		
		String string3 = manipulate("llgjfilkhgiil");  //llgil
		System.out.println(string3);
		
		

	}

}
//class Solution {
//    public String resultingString(String s) {
//        StringBuilder sb = new StringBuilder();
//
//        for (char ch : s.toCharArray()) {
//            int len = sb.length();
//            if (len > 0 && areAdjacent(sb.charAt(len - 1), ch)) {
//                sb.deleteCharAt(len - 1); // remove previous character
//            } else {
//                sb.append(ch); // keep current character
//            }
//        }
//
//        return sb.toString();
//    }
//
//    private boolean areAdjacent(char a, char b) {
//        return Math.abs(a - b) == 1 || (a == 'a' && b == 'z') || (a == 'z' && b == 'a');
//    }
//}
//




// class Solution {
//     public String resultingString(String s) {
//         boolean changed = true;
        
//         while (changed) {
//             changed = false;
//             StringBuilder sb = new StringBuilder();
//             int i = 0;
//             while (i < s.length()) {
//                 if (i < s.length() - 1 && areAdjacent(s.charAt(i), s.charAt(i + 1))) {
//                     // Skip both adjacent characters
//                     i += 2;
//                     changed = true;
//                 } else {
//                     sb.append(s.charAt(i));
//                     i++;
//                 }
//             }
//             // If last character wasn't compared
//             s = sb.toString();
//         }
//         return s;
//     }

//     private boolean areAdjacent(char a, char b) {
//         return Math.abs(a - b) == 1 || (a == 'a' && b == 'z') || (a == 'z' && b == 'a');
//     }
// }



// class Solution {
//     public String resultingString(String s) {
//         boolean changed = true;
//         while (changed) {
//             changed = false;
//             StringBuilder sb = new StringBuilder();
//             int i = 0;
//             while (i < s.length()) {
//                 if (
//                     i < s.length() - 1 &&
//                     (
//                         Math.abs(s.charAt(i) - s.charAt(i + 1)) == 1 ||
//                         (s.charAt(i) == 'a' && s.charAt(i + 1) == 'z') ||
//                         (s.charAt(i) == 'z' && s.charAt(i + 1) == 'a')
//                     )
//                 ) {
//                     i += 2;
//                     changed = true;
//                 } else {
//                     sb.append(s.charAt(i));
//                     i++;
//                 }
//             }
//             s = sb.toString();
//         }
//         return s;
//     }
// }

//©leetcode
