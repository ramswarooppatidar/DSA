package com.string3;

public class RotedString {
	public static boolean rotateString(String s, String goal) {
        char s1[] = s.toCharArray();
        int k = s.length();
        while(k>0){
            char ch = s1[0];
            for(int i=0; i<s.length() - 1; i++){
                 s1[i] = s1[i + 1];
            }
            s1[s.length() - 1] = ch;

            String check = new String(s1);
            if(check.equals(goal)){
                return true;
            }
            k--;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
