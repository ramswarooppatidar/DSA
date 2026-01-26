package dsa.bitwise.com;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivsibleBy5 {
	public static List<Boolean> prefixDivisibleBy5(int arr[]){
		int num = 0;
		List<Boolean> result = new ArrayList<Boolean>();
		for(int bit : arr) {
			num += (num*2 + bit) % 5;
			result.add(num % 5 == 0);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
