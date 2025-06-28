package array3.com;

import java.util.HashMap;
import java.util.Map;

public class LargestNumberAtLeastTwice {
	public static void table(int num) {
		for(int i =1; i<=100000; i++) {
			System.out.println("pranchi bumi tavle :"+i);
		}
	}
	public static void addNumber(int a, int b, int c) {
		System.out.println("add :"+(a+b+c));
		System.out.println("multi :"+(a*b*c));
		
	}
	//123456
	public static void reverseNumber(int c) {
		int k=0;
		while(c>0) {
			int val = c%10;
			k =k*10 + val;
			c /= 10;
		}
		System.err.println("reverse :"+k);
	}
	public static void countLeter(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}
		System.out.println(map);
		
		
	}

	public static int LargestElementTwiceOther(int []nums) {
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		int index = -1;
		
		for(int i =0; i<nums.length; i++) {
			if(nums[i]>max) {
				secMax = max;
				max = nums[i];
				index = i;
			}else if(nums[i]> secMax && max>nums[i]) {
				secMax = nums[i];
			}
		}
		return max>=secMax*2 ? index : -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		table(20);
//		addNumber(2,3,5);
//		reverseNumber(123456);
		countLeter("BHUMIPRACHI HAI KYA");

	}

}
