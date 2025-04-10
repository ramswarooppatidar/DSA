package backtracking.com;

import java.util.ArrayList;
import java.util.List;

public class Subset_I {
	public static List<List<Integer>> subset(int []nums){
		List<List<Integer>> ansList = new ArrayList<>();
		backtracking(ansList, new ArrayList<>(), nums, 0);
		return ansList;
	}
	
	private static void backtracking(List<List<Integer>> ansList, ArrayList arrayList, int[] nums, int start) {
		// TODO Auto-generated method stub
		ansList.add(new ArrayList<Integer>(arrayList));
		System.out.println("added successfully in ansList :"+ansList);
		
		for(int i= start;i<nums.length; i++) {
			System.out.println("i value "+nums[i]);
			
			arrayList.add(nums[i]);
			System.out.println("after add"+arrayList);
			
			backtracking(ansList, arrayList, nums, i+1);
			System.out.println("after bactrack"+arrayList);
			
			arrayList.remove(arrayList.size() -1);
			System.out.println("after remove"+arrayList);
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= {1, 2, 3};
		List<List<Integer>> resultList = subset(nums);
		System.out.println(resultList);

	}

}
