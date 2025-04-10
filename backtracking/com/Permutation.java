package backtracking.com;

import java.util.*;

public class Permutation {
	public static List<List<Integer>> permute(int []nums){
		List<List<Integer>> ansList = new ArrayList<>();
		backtracking(ansList, new ArrayList<>(), nums);
		return ansList;
	}

	private static void backtracking(List<List<Integer>> ansList, ArrayList arrayList, int[] nums) {
		// TODO Auto-generated method stub
		if(nums.length == arrayList.size()) {
			ansList.add(new ArrayList<Integer>(arrayList));
			return;
		}
		for(int numInteger : nums) {
			System.out.println("numInteger :"+numInteger);
			if(arrayList.contains(numInteger)) {
				continue;
			}
			arrayList.add(numInteger);
			System.out.println("after add :"+arrayList);
			backtracking(ansList, arrayList, nums);
			System.out.println("after backtracking :"+arrayList);
			
			arrayList.remove(arrayList.size() -1);
			System.out.println("after remove :"+arrayList);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {1,2,3};
		 List<List<Integer>> reList = permute(nums);
		 System.out.println(reList);

	}

}
