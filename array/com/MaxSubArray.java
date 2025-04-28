package array.com;

public class MaxSubArray {

	public static void maxSubArraySum(int arr[]) {
		for(int str=0; str<arr.length; str++) {
			for(int end = str; end<arr.length; end++) {
				for(int i = str; i<=end; i++) {
					System.out.print(arr[i]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	//this is also correct
	public static void maxSubArraySum2(int arr[]) {
		int maxSum =0;
		for(int str=0; str<arr.length; str++) {
			int cs =0;
			for(int end = str; end<arr.length; end++) {
				 cs += arr[end];
				 maxSum = Math.max(maxSum, cs);	 
			}
//			System.out.println();
		}
		System.out.println("maxSum :"+maxSum);
	}
	
	public static void maxSubArraySum3(int arr[]) {
		int maxSum = Integer.MIN_VALUE;
		int current =0;
		for(int str=0; str<arr.length; str++) {
			current += arr[str];
			maxSum = Math.max(maxSum, current);
			if(current < 0) {
				current = 0;
			}
		}
		System.out.println("maxSum :"+maxSum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(0.1*2 == 0.2);
		int arr[]= {1,2,-3,4,-5};
		maxSubArraySum2(arr);

	}

}
