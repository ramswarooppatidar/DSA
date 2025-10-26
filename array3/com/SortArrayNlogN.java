package array3.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayNlogN {

	public static int[] sortArray(int nums[]) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int min = nums[0];
		int max = nums[0];
		for(int i =0; i< nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if(nums[i] > max) {
				max = nums[i];
			}
			if(nums[i] < min) {
				min = nums[i];
			}
			
		}
		int  index = 0;
		for(int i =min; i<= max; i++) {
			while(map.getOrDefault(i, 0) > 0) {
				nums[index++] = i;
				map.put(i, map.get(i) - 1);
			}
		}
		for(int j : nums) {
			System.out.print(j+" ");
		}
		System.out.println(Arrays.toString(nums));
		
		return nums;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,6,3,5,0,0,-1,12,11,23,24,16,67,45};
		sortArray(arr);

	}

}
