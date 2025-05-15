package array.com.set_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

	public static int threeSumClosest(int nums[], int target) {
		Arrays.sort(nums);
		int resultSum = nums[0] + nums[1] + nums[2];
		int minDifference = Integer.MAX_VALUE;
		
		for(int i =0; i<nums.length-2; i++) {
			int left = i+1;
			int right = nums.length - 1;
			while(left<right) {
				int sum = nums[i]+nums[left]+nums[right];
				if(sum == target) {
					return sum;  //Exit from the method and therefore also exit from both the while and for loops.
				}
				
				if(sum < target) {
					left++;
				}else {
					right--;
				}
				
				int diffToTarget = Math.abs( target- sum);
				if(diffToTarget < minDifference) {
					resultSum = sum;
					minDifference = diffToTarget;
				}
			}	
		}
		
		return resultSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {-1,0,1,2,-1,-4};
		int ansList = threeSumClosest(arr, 4);
		System.out.println(ansList);

	}

}
