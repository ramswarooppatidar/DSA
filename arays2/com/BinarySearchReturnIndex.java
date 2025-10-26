package arays2.com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinarySearchReturnIndex {

	public static int search(int[] nums, int target) {
        Integer index[] = new Integer[nums.length];
        for(int i =0; i<nums.length; i++){
            index[i] = i;
        }
        // Arrays.sort(index, (a, b) -> nums[b] - nums[a]);
        Arrays.sort(index, (a, b) -> Integer.compare(nums[a], nums[b]));
        for(int i =0; i<nums.length; i++){
            System.out.print(index[i]+" ");
        }
        Arrays.sort(nums);
        int left =0; 
        int right = nums.length - 1;
        while(left<=right){
           int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return index[mid];
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
	public static int binSearchIndexMap(int arr[], int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i =0; i<arr.length; i++) {
			map.put(arr[i], i);
		}
		int left =0; 
        int right = arr.length - 1;
        while(left<=right){
           int mid = left + (right - left)/2;
            if(arr[mid] == target){
                return map.get(mid);
            }else if(arr[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,4,5,6,7,2,9};
		System.out.println("index is :"+search(arr, 7));

	}

}
