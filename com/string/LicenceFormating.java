package com.string;

public class LicenceFormating {
	public static String licenseKeyFormatting(String s, int k) {
        String clean = s.replace("-", "").toUpperCase();
        int count =0;
        StringBuilder sb = new StringBuilder();
        for(int i = clean.length() - 1; i>=0; i--){
            sb.append(clean.charAt(i));
            count++;
            if(k == count && i != 0){
                sb.append("-");
                count=0;
            }
        }
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 Input: s = "5F3Z-2e-9-w", k = 4
		Output: "5F3Z-2E9W"
		Explanation: The string s has been split into two parts, each part has 4 characters.
		Note that the two extra dashes are not needed and can be removed.
		Example 2:
		
		Input: s = "2-5g-3-J", k = 2
		Output: "2-5G-3J"
		Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 
		 */

	}

}
