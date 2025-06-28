package arays2.com;

public class LongestConsucitiveIncresSequence {

	 public static int findLengthOfLCIS(int[] nums) {
	        int count =0;
	        int maxLength = 0;
	        for(int i =0; i<nums.length-1; i++){
	            if(nums[i]<nums[i+1]){
	                count++;
	            }else{
	                maxLength = Math.max(count, maxLength);
	                count=0;
	            }
	        }
	         maxLength = Math.max(count, maxLength);
	        return maxLength + 1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLengthOfLCIS(new int[] {1,2,3,4}));
		System.out.println(findLengthOfLCIS(new int[] {1,2,0,4}));
		System.out.println(findLengthOfLCIS(new int[] {1,2,3,5,7,8,1}));

	}

}
