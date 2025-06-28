package array3.com;

public class PivotLeftSumEqRightSum {
	public static int pivotIndex(int nums[]) {
		int n = nums.length;
		int leftSum[] = new int[n];
		leftSum[0] = 0;
		int rightSum[] = new int[n];
		rightSum[n-1] = 0;
		
		for(int i =1; i<n; i++) {
			leftSum[i] = leftSum[i - 1] + nums[i - 1];
		}
		for(int i =n -2; i>=0; i--) {
			rightSum[i] = rightSum[i+ 1] + nums[i + 1];
		}
		for(int i =0; i<n; i++) {
			if(leftSum[i] == rightSum[i]) {
				return i;
			}
		}
		return -1;
	}
	 public static int pivotIndexOpt(int[] nums) {
	        int total = 0;
	        for(int i : nums){
	            total += i;
	        }
	        int leftSum =0;
	        for(int i =0; i<nums.length; i++){
	            if(leftSum*2 + nums[i] == total){
	                return i;
	            }
	            leftSum += nums[i];
	        }
	        return -1;
	      }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
