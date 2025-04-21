package array.com;

public class NextPermutation {

	 public static int[] nextPermutation(int[] nums) {
	        int i = nums.length -2;
	        while(i >= 0 && nums[i] >= nums[i+1]){
	            i--;
	        }
	        if(i>=0){
	             int j = nums.length - 1;
	            while(j >= 0 && nums[j] <= nums[i]){
	                j--;
	            }
	            swap(nums, i, j);
	        }
	        
	       return reverse(nums, i+1);
	       
	    }
	    private static void swap(int nums[], int strat, int end){
	        int temp = nums[strat];
	        nums[strat] = nums[end];
	        nums[end] = temp;
	    }
	    private static int[] reverse(int nums[], int strat){
	        int end = nums.length -1;
	        while(strat < end){
	            int temp = nums[strat];
	            nums[strat] = nums[end];
	            nums[end] = temp;
	            end--;
	            strat++;
	        }
	        return nums;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,1,1,2,1,0};
		for(int i : arr) {
			System.out.print(i+" ");
		}
		int result[] = NextPermutation.nextPermutation(arr);
		System.out.println();
		for(int i : result) {
			System.out.print(i+" ");
		}

	}

}
