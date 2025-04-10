package dynamicProgramming.com;

import java.util.ArrayList;

public class Fib_dp {
	static ArrayList<Integer> dp;
	//memoization;
	public static int fib(int n) {
		if(n <= 1) {
			return n;
		}
		if(dp.get(n) != -1) {
			return dp.get(n);
		}
		int temp = fib(n - 1) + fib(n - 2);
		dp.set(n, temp);
		return temp;
	}
	//tabularization bottom up approch
	public static int fib2(int n) {
		dp.set(0, 0);
		dp.set(1, 1);
		for(int i =2; i<=n; i++) {
			dp.set(i, dp.get(i - 1) + dp.get(i - 2));
		}
		return dp.get(n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp = new ArrayList<>();
		int num = 5;
		for(int i=0; i<=num; i++) {
			dp.add(-1);
		}
		
//		int nth = fib(num);
		int nth = fib2(num);
		
		System.out.println(nth);
	}

}
