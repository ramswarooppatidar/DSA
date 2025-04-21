package recurssion.com;

import java.awt.image.BufferStrategy;

public class BinarySearch {

	public static int binarySearch(int arr[], int x) {
		return helper(arr, x, 0, arr.length - 1);
	}
	public static int helper(int arr[], int x, int start, int end) {
		if(start<=end) {
			int mid = start + (end-start)/2;
			if(x < arr[mid]) {
				return helper(arr, x, start, mid);
			}else if(x > arr[mid]) {
				return helper(arr, x, mid + 1, end);
			}else {
				return x;
			}
		}
		return -1;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,6,3,12,34,55,6,98};
		int result =  binarySearch(arr, 121);
		System.out.println(result);
	}

}
