package practiceProblems;

public class ManipulateString {
//    static int  index =0;
	public static String manipulateString(String str,int index) {
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		
		while(index < n) {
		
			char ch = str.charAt(index);
			
			if(Character.isDigit(ch)) {
				int k = 0;
				while(Character.isDigit(str.charAt(index))) {
					k = k*10 + str.charAt(index)-'0';
					index++;
				}
				index++;
				String smallString = manipulateString(str, index);
				while(k>0) {
					sb.append(smallString);
					k--;
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
	 static int  index =0;
	public static String manipulateString2(String str) {
		StringBuilder sb = new StringBuilder();
		int n = str.length();
		
		while(index < n) {
		
			char ch = str.charAt(index);
			if(Character.isDigit(ch)) {
				int k = 0;
				while(Character.isDigit(str.charAt(index))) {
					k = k*10 + str.charAt(index)-'0';
					index++;
				}
				index++;
				String smallString = manipulateString2(str);
				while(k>0) {
					sb.append(smallString);
					k--;
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
	public static String longestSubstring(String str) {
		String lonString = "";
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if( sb.indexOf(String.valueOf(ch)) == -1) {
				sb.append(ch);
			}else {
				while(sb.length() > 0 && sb.indexOf(String.valueOf(ch)) != -1){
					if(lonString.length() < sb.length()) {
						lonString = sb.toString();
						System.out.println(lonString);
					}
					sb.deleteCharAt(0);
				}
				sb.append(ch);
			}
			
		}
		return lonString;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(manipulateString("3[Ra]Y2[E]x", 0));
		System.out.println(manipulateString2("3[RaY2[E]x-]"));
		
		String reString = longestSubstring("abcabgdhbvsjkhtos");
		System.out.println("longest substring without reapiting :"+reString);
	}

}
