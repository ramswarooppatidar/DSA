package arays2.com;

import java.util.HashMap;

public class FindFrequency {
	public static int[] findFrequecny(int nums[]) {
		int fre[] = new int[nums.length];
		for(int i =0; i<nums.length-1; i++) {
			int count=1;
			if(nums[i] == -1) continue;
			for(int j =i+1; j<nums.length; j++) {
				if(nums[j] != -1 && nums[i] == nums[j]) {
					count++;
					nums[j] = -1;
				}
			}
			fre[i] = count;
		}
		return fre;
	}
	public static void findFrequecny2(int nums[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i =0;i<nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		System.out.println(map);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,2,3,4,5,7,4,3,2,4,5,3,2};
//		int res[]	= findFrequecny(arr);
//		for(int i : res) {
//			System.out.print(i+" ");
//		}
		findFrequecny2(arr);

	}

}
