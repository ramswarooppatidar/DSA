package com.string2;

public class RegxMatcher {

	/*
	 * 1. The username is between 4 and 25 characters.
		2. It must start with a letter.
		3. It can only contain letters, numbers, and the underscore character.
		4. It cannot end with an underscore character.
	 */
	public static String matcher(String username){
		boolean result = username.matches("^[a-zA-Z][a-zA-Z0-9_*]{2,23}[a-zA-Z]");
		return result ? "true" : "false";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(matcher("ram673_"));
		System.out.println(matcher("ram*673_ffgshu"));

	}

}
