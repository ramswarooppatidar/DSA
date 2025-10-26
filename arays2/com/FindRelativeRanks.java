package arays2.com;

import java.util.Arrays;

public class FindRelativeRanks {

	public static String[] findRelativeRan(int nums[]) {
		int n = nums.length;
		String result[] = new String[nums.length];
		Integer index[] = new Integer[nums.length];
		
		for(int i =0; i<n; i++) {
			index[i]=i;
		} 
	   Arrays.sort(index, (a, b)-> nums[b] - nums[a]);
	   System.out.print("sort arr elements based on index :");
	   for(Integer i : index) {
			System.out.print(i + " ");
		}
	   System.out.println();
		
		for(int i =0; i<n; i++) {
			if(i == 0) {
				result[index[i]] = "Gold medliest";
			}else if( i == 1) {
				result[index[i]] = "Silver Medliest";
			}else if(i == 2) {
				result[index[i]] = "Bronze Medliest";
			}else {
				result[index[i]] = String.valueOf(i + 1);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {24,6,4,9,31,0,11,23,67};
		String res[] = findRelativeRan(arr);
		for(String string : res) {
			System.out.print(string + ", ");
		}

	}

}
