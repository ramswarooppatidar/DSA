package arays2.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SeprateEvenOdd {

	public static int[] seprateEvenOdd(int []nums) {
		int left =0;
		int right = nums.length - 1;
		while(left<right) {
			if(nums[left]%2 != 0 && nums[right] %2 == 0) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}else if(nums[left]%2 == 0) {
				left++;
			}else {
				right--;
			}
		}
		return nums;
		
	} 
	public static List<List<Integer>> evenOdd(List<Integer> list){
	Map<Boolean, List<Integer>> map=list.stream().collect(Collectors.partitioningBy(Number -> Number%2 == 0));
	List<List<Integer>> ansList = new ArrayList<List<Integer>>();
	ansList.add(map.get(false));
	ansList.add(map.get(true));
	return ansList;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {12,1,4,5,6,6000,7,2,5,3,80};
		seprateEvenOdd(arr);
		for(int i : arr) {
			System.out.print(i+" ");
		}
		
	
		

	}

}
