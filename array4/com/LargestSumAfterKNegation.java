package array4.com;

import java.util.Arrays;

public class LargestSumAfterKNegation {
	public static int largestSumAfterKNegation(int arr[], int k) {
		Arrays.sort(arr);
		int i =0;
		while(i < arr.length && k > 0 && arr[0] < 0) {
			arr[i] = -arr[i];
			i++;
			k--;
		}
		
		Arrays.sort(arr);
		if(k % 2 == 1) {
			arr[0] = -arr[0];
		}
		
		int sum =0;
		for(int n : arr) {
			sum += n;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
