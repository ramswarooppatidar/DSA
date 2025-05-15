package arays2.com;

public class SecondMax {
	public static int secondMax(int nums[]) {
		int firstMax = Integer.MIN_VALUE;
		int secondMax = firstMax - 1;
		for(int i =0; i<nums.length; i++) {
			if(firstMax == nums[i] || secondMax == nums[i]) continue;
			if(nums[i]>firstMax) {
				secondMax = firstMax;
				firstMax = nums[i];
			}else if(nums[i]>secondMax) {
				secondMax = nums[i];
			}
		}
		return secondMax;
	}
	
	public static int thirdMax(int nums[]) {
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;
		for(int i =0; i<nums.length; i++) {
			if(firstMax == nums[i] || secondMax == nums[i] || thirdMax == nums[i]) continue;
			if(nums[i]>firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = nums[i];
			}else if(nums[i]>secondMax) {
				thirdMax = secondMax;
				secondMax = nums[i];
			}else if(nums[i]>thirdMax) {
				thirdMax = nums[i];
			}
		}
		return thirdMax == Integer.MIN_VALUE ? firstMax : thirdMax ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,2,5,6,6};
		System.out.println(secondMax(arr));
		
		int arr1[]= {1,2,2,3,3};
		System.out.println(thirdMax(arr1));
		

	}

}
