package arays2.com;

public class ThirdMax {
	public static  int thirdMax(int nums[]) {
		Long firstMax = null;
		Long secondMax = null;
		Long thirdMax = null;
		for(int i =0; i<nums.length; i++) {
			long n = nums[i];
			if((firstMax != null && n == firstMax) 
				|| (secondMax != null && n == secondMax)
				|| (thirdMax != null && n == thirdMax)) continue;
			
			if(firstMax == null || n > firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = n;
			}else if(secondMax == null || n>secondMax) {
				thirdMax = secondMax;
				secondMax = n;
			}else if( thirdMax == null || n>thirdMax) {
				thirdMax = n;
			}
		}
		return thirdMax != null ? thirdMax.intValue() : firstMax.intValue();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,2,6,3,4,4,5};
		System.out.println(thirdMax(arr));

	}

}
