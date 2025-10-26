package arays2.com;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
	public static int[] iintersection(int []nums1, int[]nums2) {
		List<Integer> list = new ArrayList<>();
		boolean visited[] = new boolean[nums2.length];
		for(int i =0; i<nums1.length; i++) {
			for(int j =0; j<nums2.length;j++) {
				if(nums1[i] == nums2[j] && !visited[j]) {
					list.add(nums2[j]);
					visited[j] = true;
					break;
				}
			}
		}
		System.out.println(list);
		int[] array = list.stream().mapToInt(Integer::intValue).toArray();
		return array;
	}
	public static int[] intersectionUniqe(int arr1[], int arr2[]) {
		List<Integer> intersection = new ArrayList<>();
		for(int i : arr1) {
			for(int j : arr2) {
				if(i == j && !intersection.contains(i)) {
					intersection.add(i);
				}
			}
		}
		System.out.println(intersection);
		int[]array = intersection.stream().mapToInt(Integer::intValue).toArray();
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {1,2,3,2,7}, arr2[]= {1,2,4,2,3,3, 5};
		iintersection(arr1, arr2);
		intersectionUniqe(arr1, arr2);
		
		System.out.println();
		int[]nums1= {4,9,5,4,7}, nums2 ={9,4,9,8,4,4,7};
		iintersection(nums1, nums2);
		intersectionUniqe(nums1,nums2);

	}

}
