package array3.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
	public static int[] topKFrequesnt(int nums[], int k) {
		int res[] = new int[k];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+ 1);
		}
		List<List<Integer>> list = new ArrayList<>(nums.length + 1);
		for(int i =0; i<=nums.length; i++) {
			list.add(new ArrayList<>());
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int val = entry.getValue();
			list.get(val).add(entry.getKey());
		}
		
		int index = 0;
		for(int i = nums.length; i>=0 && index<k; i--) {
			for(int num : list.get(i)) {
				res[index++] = num;
				if(index == k)break;
			}
		}
		
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,1,1,2,2,3,4,3};
		int arr1[] = {1};
		int arr2[] = {1,2,3,1,1,2,2,3,1,3,2,3,3,3};
		
		int res[] = topKFrequesnt(arr,2);
		for(int num : res) {
			System.out.print(num+" ");
		}
		System.out.println();
		int res1[] = topKFrequesnt(arr1,2);
		for(int num : res1) {
			System.out.print(num+" ");
		}
		
		System.out.println();
		int res2[] = topKFrequesnt(arr2,3);
		for(int num : res2) {
			System.out.print(num+" ");
		}
		

	}

}
