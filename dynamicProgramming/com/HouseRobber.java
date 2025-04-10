package dynamicProgramming.com;

import java.util.Arrays;

public class HouseRobber {
	static int []dp;
	public static int rob(int[] nums) {
		dp = new int[nums.length];
		Arrays.fill(dp, -1);
//        return helper(nums, nums.length - 1);
//		 return helper_memo(nums, nums.length - 1);
		 return helper_tab(nums);
    }
	public static int helper(int nums[], int n) {
		if( n<0) {
			return 0;
		}
		if(n == 0) {
			return nums[0];
		}
		int inc = helper(nums, n - 2) + nums[n];
		int exc = helper(nums, n - 1);
		return Math.max(inc, exc);
	}
	//memoization
	public static int helper_memo(int nums[], int n) {
		if( n<0) {
			return 0;
		}
		if(n == 0) {
			return nums[0];
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		int inc = helper(nums, n - 2) + nums[n];
		int exc = helper(nums, n - 1);
		int ans = Math.max(inc, exc);
		dp[n] = ans;
		return Math.max(inc, exc);
	}
	//tabulizaton
	public static int helper_tab(int nums[]) {
		int n = nums.length;
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return nums[0];
		}
		dp[0] = nums[0];
		for(int i =1; i<n; i++) {
			int inc = nums[i];
			if(i > 1) {
				inc += dp[i -2];
			}
			int exc = dp[i -1];
			dp[i] = Math.max(inc, exc);
		}
		
		return dp[n - 1];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {2,7,9,3,1};
		int arr[] = {1, 2, 3, 1};
		int ans = rob(arr);
		System.out.println("max rob :"+ans);

	}

}
