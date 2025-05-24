package arays2.com;

import array.com.ArrayPushLeftRight;
/*
 	Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
	Output: [3, 3, 4, 5, 5, 5, 6] 
	Explanation: 
	1st contiguous subarray = [1 2 3] max = 3
	2nd contiguous subarray = [2 3 1] max = 3
	3rd contiguous subarray = [3 1 4] max = 4
	4th contiguous subarray = [1 4 5] max = 5
	5th contiguous subarray = [4 5 2] max = 5
	6th contiguous subarray = [5 2 3] max = 5
	7th contiguous subarray = [2 3 6] max = 6
 */
public class MaxElementInEachSubArray {
	public static int[] maxElementInSubArray(int arr[], int k) {
		int n = arr.length;
		
		int result[] = new int[n - k+1];
		int left=0;
		int right = k-1;

		int count=0;
//		int max= Integer.MIN_VALUE;   // this is max tracking only
		while(right<n) {
			int max= Integer.MIN_VALUE;  //this is per window tracking
			
			for(int i =left; i<=right; i++) {
				if(arr[i]>max) {
					max = arr[i];
				}
			}
			
			result[count++]= max;
			left++;
			right++;
		}
		return result;
		
	}
	
	public static int[] sumElementInSubArray(int arr[], int k) {
		int n = arr.length;
		
		int result[] = new int[n - k+1];
		int left=0;
		int right = k-1;

		int count=0;
//		int max= Integer.MIN_VALUE;   // this is max tracking only
		while(right<n) {
			int max= 0;  //this is per window tracking
			
			for(int i =left; i<=right; i++) {
					max += arr[i];
			}
			
			result[count++]= max;
			left++;
			right++;
		}
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1, 6, 3, 1, 4, 5, 2, 3, 6};
		int res[] = maxElementInSubArray(arr, 3);
		for(int i : res) {
			System.out.print(i+" ");
		}
		System.out.println();
		int sum[] = sumElementInSubArray(arr, 3);
		for(int i : sum) {
			System.out.print(i+" ");
		}

	}

}
