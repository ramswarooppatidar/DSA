package arays2.com;

public class MaxSumSubArraySizeK {
	public static int maxSumSubArraySizeK(int []nums, int k) {
		int sum =0;
		int left =0;
		int n = nums.length;
		int right = k;
		for(int i =0; i<k; i++) {
			sum += nums[i];
		}
		System.out.println("first sum "+sum);
		int maxSum = sum;
		while(left<=n-k && right<n) {
			sum -= nums[left];
			sum += nums[right];
			if(sum>maxSum) {
				maxSum = sum;
			}
			left++;
			right++;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2, 1, 5, 1, 3, 2};
		int maxSum = maxSumSubArraySizeK(arr, 4);
		System.out.println("max sub Array Sum is :"+maxSum);

	}

}
