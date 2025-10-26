package arays2.com;

public class MiniSumSubArray {
	public static int minisumSubArray(int arr[], int target) {
		int minLength = Integer.MAX_VALUE;
		for(int i = 0; i<arr.length - 1; i++) {
			int sum = arr[i];
			int count=1;
			for(int j=i+1; j<arr.length;j++) {
				sum += arr[j];
				count++;
			    if(sum == target) {
			    	minLength = Math.min(minLength, count);
			    }
			}
		}
		System.out.println(minLength);
		return minLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,2,1,5,3,8,1,21,1,1,1,1,1,1,1};
		minisumSubArray(arr,7);

	}

}
