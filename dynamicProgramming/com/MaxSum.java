package dynamicProgramming.com;
import java.util.*;
import java.util.Arrays;
public class MaxSum {
	static ArrayList<Integer> dp;
	static ArrayList<Integer> dpTab;
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		dp = new ArrayList<Integer>(nums.size());
		for(Integer i: nums) {
			dp.add(-1);
		}
//		return helper(nums, nums.size() - 1);
//		return helper_memoization(nums, nums.size() - 1);
//		return helper_tabulization(nums);
//		return helper_tabulization2(nums);
		
		return helper_tab_chat(nums);     //  this is perfect code
	}
	public static int helper(ArrayList<Integer> nums, int n) {
		if(n<0) {
			return 0;
		}
		if(n == 0) {
			return nums.get(0);
		}
		int include = helper(nums, n - 2) + nums.get(n);
		int exclude = helper(nums, n - 1) + 0;
		return Math.max(include, exclude);
	}
	//memoaizatio;
	public static int helper_memoization(ArrayList<Integer> nums, int n) {
		if(n<0) {
			return 0;
		}
		if(n == 0) {
			return nums.get(0);
		}
		if(dp.get(n) != -1) {
			return dp.get(n);
		}
		int include = helper(nums, n - 2) + nums.get(n);
		int exclude = helper(nums, n - 1) + 0;
		int ans = Math.max(include, exclude);
		dp.set(n, ans);
		return dp.get(n);
	}
	//tabulization
	public static int helper_tabulization(ArrayList<Integer> nums) {
		dpTab = new ArrayList<>(nums.size());
		int n =  nums.size();
		for(Integer i: nums) {
			dpTab.add(0);
		}
		dpTab.set(0, nums.get(0));
		
		for(int i =1; i<n; i++) {
			int inc = dpTab.get(i + 2) + nums.get(i);
			int exc = dpTab.get(i + 1) + 0;
			int ans = Math.max(inc, exc);
			dpTab.set(i, ans);
		}
		return dpTab.get(n - 1);
	}
	public static int helper_tabulization2(ArrayList<Integer> nums) {
		dpTab = new ArrayList<>(nums.size());
		int n =  nums.size();
		for(Integer i: nums) {
			dpTab.add(0);
		}
		dpTab.set(0, nums.get(0));
		
		for (int i = 1; i < n; i++) {
            int inc = nums.get(i);
            if (i > 1) {
                inc += dpTab.get(i - 2); // Include the current element and add non-adjacent previous
            }
            int exc = dpTab.get(i - 1); // Exclude the current element
            int ans = Math.max(inc, exc);
            dpTab.set(i, ans);
        }
		return dpTab.get(n - 1);
	}
	
	public static int helper_tab_chat(ArrayList<Integer> nums) {
		dpTab = new ArrayList<>(nums.size());
		int n = nums.size();
		for(Integer integer : nums) {
			dpTab.add(0);
		}
		if(n == 0) {
			return nums.get(0);
		}
		if( n == 1) {
			return Math.max(nums.get(0), nums.get(1));
		}
		dpTab.set(0, nums.get(0));
		for(int i = 2; i<n; i++) {
			
			int inc = dpTab.get(i -2) + nums.get(i);
			int exc = dpTab.get(i - 1);
			int ans = Math.max(inc, exc);
			dpTab.set(i, ans);
		}
		return dpTab.get(n - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Integer arr[] = {9, 19,8,2,3};
		  ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
		  int sum = maximumNonAdjacentSum(list);
		  System.out.println("dum is :"+sum);
		

	}

}
