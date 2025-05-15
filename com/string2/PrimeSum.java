package com.string2;

import java.util.IntSummaryStatistics;

public class PrimeSum {

	public static int primeSumBetweenN1n2(int n1, int n2) {
		int sum =0;
		for(int i =n1; i<=n2; i++) {
			if(isPrime(i)) {
				System.out.print(i+" ");
				sum += i; 
			}
		}
		return sum;
	}
	public static boolean isPrime(int n) {
		for(int i = 2; i<=Math.sqrt(n);i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void firstNfibonacii(int num) {
		float first = 0;
		float second = 0.3f;
//		if(num == 1) {
//			System.out.println(first);
//			return;
//		}
//		if(num == 2) {
//			System.out.println(second);
//			return;
//		}
		
      System.out.print(first+" ");
      int sum =0;
		for(int i=1; i<num; i++) {
			float nextDigit = first + second;
			second = first;
			first = nextDigit;
			System.out.print(nextDigit+" ");
			sum +=nextDigit; 	
		}
		System.out.println();
		System.err.println("total sum :"+sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(primeSumBetweenN1n2(10, 127));
		firstNfibonacii(18);

	}

}
