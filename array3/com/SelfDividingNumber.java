package array3.com;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> ansIntegers = new ArrayList<Integer>();
		for(int i = left; i<=right; i++) {
			if(i % 10 == 0) continue;
			int num = i;
			while(num > 0) {
				int last = num % 10;
				if(i % last != 0) {
					break;
				}
				num = num / 10;
				if(num % 10 == 0) break;
			}
			if(num < 1) ansIntegers.add(i);
		}
		return ansIntegers;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 Input: left = 1, right = 22
         Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
		 */

	}

}
