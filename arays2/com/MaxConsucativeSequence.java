package arays2.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxConsucativeSequence {

	public static int sequence(int arr[]) {
		Set<Integer> set = new HashSet<>();
		int n = arr.length;
		for(int i =0; i<n; i++) {
			set.add(arr[i]);
		}
		int maxLength = 0;
		List<Integer> list = new ArrayList<>();
		for(int i =0; i<n; i++) {
			if(set.contains(arr[i] )) {
				int curentNum = arr[i];
				int currentLength = 0;
				
				while(set.contains(curentNum)){
					currentLength += 1;
					curentNum += 1;
				}
				set.remove(arr[i]);
//				System.out.println("current length :"+currentLength);
				list.add(currentLength);
				maxLength=	Math.max(maxLength, currentLength);
			}	
		}
		System.out.println(list);
		return maxLength;
	}
	public static int sequenceOptimized(int arr[]) {
		Set<Integer> set = new HashSet<>();
		for(int i : arr) {
			set.add(i);
		}
		int maxLength = 0;
		for(int i =1; i<arr.length; i++) {
			if(!set.contains(arr[i] - 1)) {
				int currentNum = arr[i];
				int currentLength = 1;
				
				while(set.contains(currentNum + 1)) {
					currentLength += 1;
					currentNum++;
				}
				maxLength = Math.max(maxLength, currentLength);
			}
		}
		return maxLength;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(sequence(new int[] {100, 201,3,4,5,10,11,12,13,14}));
        System.out.println(sequenceOptimized(new int[] {100, 201,3,4,5,10,11,123,13,14,15,16}));
	}

}
