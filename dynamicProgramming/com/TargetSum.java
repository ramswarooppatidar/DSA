package dynamicProgramming.com;

import java.util.HashMap;

public class TargetSum {
	public static int findTargetSumWay(int nums[], int target) {
		HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
		dp.put(0, 1);
		for(int num : nums) {
			HashMap<Integer, Integer> nextDp = new HashMap<Integer, Integer>();
			
			for(int sum : dp.keySet()) {
				int count = dp.get(sum);
				
				nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0) + count);
				nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
			}
			dp =nextDp;
		}
		return dp.getOrDefault(target, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {1,1,1,1,1};
		int way = findTargetSumWay(nums, 3);
		System.out.println("total way is "+ way);

	}

}
