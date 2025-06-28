package arays2.com;

import java.util.HashMap;

public class SetMismatched {
	public static int[] findErrNumber(int nums[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int dublicate = -1;
		int missing = -1;
		for(int i : nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		for(int i =0; i<=nums.length; i++) {
			if(!map.containsKey(i)) {
				missing = i;
			}else if(map.get(i) == 2) {
				dublicate = i;		
			}
		}
		return new int[] {dublicate, missing};
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res[] = findErrNumber(new int[]{1,1,2,3});
		for(int i : res) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		int res1[] = findErrNumber(new int[]{1,2,2,3});
		for(int i : res1) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		int res2[] = findErrNumber(new int[]{1,2,3,3});
		for(int i : res2) {
			System.out.print(i+" ");
		}

	}

}
