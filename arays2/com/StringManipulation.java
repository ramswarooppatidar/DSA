package arays2.com;

import java.util.Stack;

public class StringManipulation {
	int index =0;
	public  String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		while(index < n) {
			
			char ch = s.charAt(index);
			
			if(Character.isDigit(ch)) {
				int k =0;
				
				while(Character.isDigit(s.charAt(index))) {
					k = k*10 + (s.charAt(index) - '0');
					index++;
				}
				index++;
				
				String smallString = decodeString(s);
				
				while(k-->0) {
					sb.append(smallString);
				}
			}else if(ch == ']') {
				index++;
				return sb.toString();
			}else {
				sb.append(ch);
				index++;
			}
		}
		return sb.toString();
	}
	
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        String string = "abc2[a3[bc]]klm0[DF]";
//       String res= decodeString(string);
//       System.out.println(res);
        //output   abc2[abcbcbc]
        //output    abc abcbcbcabcbcbc
		StringManipulation obj1 = new StringManipulation();
       System.out.println(obj1.decodeString("3[a2[c]]"));
	}

}
