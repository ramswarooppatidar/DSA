package array.com;
import java.io.InterruptedIOException;
import java.util.Arrays;

public class TwoSum {
	    public static int[] twoSum(int[] nums, int target) {
	         int index[] = new int[2];
	         for(int i =0; i<nums.length - 1; i++){
	             for(int j =i+1; j<nums.length; j++){
	                 if(nums[i] + nums[j] == target){
	                     index[0]=i;
	                     index[1] =j;
	                 }
	             }  
	         }
	         return index;
	    }
	    
	    public static int[] twoSumOptimized(int []nums,int target) {
	    	 int index[] = new int[2];
	    	 int preserveIndex[][] = new int[nums.length][2];
	    	 for(int i =0; i<nums.length; i++ ) {
	    		 preserveIndex[i][0] = nums[i];
	    		 preserveIndex[i][1] = i;
	    	 }
//	    	 Arrays.sort(nums);
	    	 
	    	 System.out.println("Before Sorting:");
	         for (int i = 0; i < preserveIndex.length; i++) {
	             System.out.println("Value: " + preserveIndex[i][0] + ", Index: " + preserveIndex[i][1]);
	         }

	         
	    	// Sort based on the value (first column)
	         Arrays.sort(preserveIndex, (a, b) -> Integer.compare(a[0], b[0]));
	         
	         
	         System.out.println("After Sorting:");
	         for (int i = 0; i < preserveIndex.length; i++) {
	             System.out.println("Value: " + preserveIndex[i][0] + ", Index: " + preserveIndex[i][1]);
	         }


	    	 int start = 0;
	    	 int end = nums.length - 1;
	    	 while(start< end) {
	    		 int sum = preserveIndex[start][0] + preserveIndex[end][0];
	    		 if(sum == target) {
	    			 return new int[]{preserveIndex[start][1],preserveIndex[end][1]};
	    		 }else if(sum > target) {
	    			 end--;
	    		 }else {
	    			 start++;
	    		 }
	    	 }
	    	 return index;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,4};
		int res[] = TwoSum.twoSum(arr, 6);
		
		System.out.print("[ ");
		for(int i : res) {
			System.out.print(i+" ");
		}
		System.out.print("] ");
		
		int res2[] = TwoSum.twoSumOptimized(arr, 6);
		System.out.print("[ ");
		for(int i : res2) {
			System.out.print(i+" ");
		}
		System.out.print("] ");

	}

}
