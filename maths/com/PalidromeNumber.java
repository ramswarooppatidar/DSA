package maths.com;

public class PalidromeNumber {
	public static boolean isPalindrome(int x) {
		if(x<0) {
			return false;
		}
		int reverseDigit=0;
		int original = x;
		while(x>0) {
			int rem =x % 10;
			reverseDigit = reverseDigit*10 + rem;
			x /= 10;
		}
		if(original == reverseDigit) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1));

	}

}
