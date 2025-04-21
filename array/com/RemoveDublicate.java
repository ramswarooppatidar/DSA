package array.com;

import recurssion.com.ConvertNumStringToInteger;

public class RemoveDublicate {

	public static int removeDublicateFromSortedArray(int arr[]) {
		int i =0;
		for(int j =1; j<arr.length; j++) {
			if(arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}
		for(int h : arr) {
			System.out.print(h+" ");
		}
		return i+1;
	}
	 public static int removeElement(int[] nums, int val) {
	        int k =0;
	        for(int i =0; i<nums.length; i++){
	            if(nums[i] != val){
	                nums[k] = nums[i];
	                k++;
	            }
	        }
	        for(int h : nums) {
				System.out.print(h+" ");
			}
	        return k;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		RemoveDublicate.removeDublicateFromSortedArray(new int[]{0,0,1,1,1,2,2,3,3,4});
		RemoveDublicate.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
	}

}
