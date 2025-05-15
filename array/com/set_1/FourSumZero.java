package array.com.set_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

public class FourSumZero {
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
		 Arrays.sort(nums);
		 Set<List<Integer>> resultLists = new HashSet<List<Integer>>();
		 for(int i =0; i<nums.length - 3; i++) {
			 for(int j = i+i; j<nums.length - 2; j++) {
				 int left = j+1;
				 int right = nums.length - 1;
				 while(left < right) {
					 long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					 if(sum == target) {
						 resultLists.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));
						 left++;
						 right--;
					 }else if(sum < target) {
						 left++;
					 }else {
						 right--;
					 }
				 }
			 }
		 }
		 return new ArrayList<>(resultLists);
	 }
		   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,0,-1,0,-2,2,3,4,-5,-3,6,-8,7,-10,8,-8,9,-9,10,12,-6};
		List<List<Integer>> Result = FourSumZero.fourSum(nums, 0);
		System.out.println(Result);

	}

}
