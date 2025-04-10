package dynamicProgramming.com;

import java.util.ArrayList;
import java.util.Arrays;

public class FrogJump {
	static int[] dp;
	public static int helper(int height[], int n) {
		//base
		if(n == 1) {
			return 0;
		}
		if(dp[n] != -1) return dp[n];
		//choice
		int op1 = 0; int op2 = Integer.MAX_VALUE;
		op1 = Math.abs(height[n - 1] - height[n - 2]) + helper(height, n - 1);
		if(n-2>0) {
			op2 = Math.abs(height[n - 1] - height[n - 3]) + helper(height, n - 2);
		}
		
		//optimal
		return dp[n] = Math.min(op1, op2);
	}
	//tabularization
	public static int helper2(int height[], int n) {
		dp[0] = 0;
		dp[1] = 0;
		int op1 = 0; int op2 = Integer.MAX_VALUE;
		for(int i =2; i<=n; i++) {
			op1 = Math.abs(height[i - 1] - height[i - 2]) + dp[i - 1];
			if(i-2>0) {
				op2 = Math.abs(height[i - 1] - height[i - 3]) + dp[i - 2];
			}
			dp[i] = Math.min(op1, op2);
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height[] = {10, 20, 30, 10};
		dp = new int[5];
		Arrays.fill(dp, -1);
//		int ans = helper(height, height.length);
		int ans = helper2(height, height.length);
		System.out.println(" min energy :"+ans);

	}

}
