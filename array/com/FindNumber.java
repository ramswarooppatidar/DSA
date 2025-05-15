package array.com;

public class FindNumber {

	public static int findNumber(int []nums) {
		int ans = 0;
		for(int i =0; i<nums.length; i++) {
			int num = nums[i];
			int count=0;
			while(num > 0) {
				count++;
				num /= 10;
			}
			ans = count % 2 == 0 ? ans + 1 : ans;
//			 if(count % 2 == 0){
//	                ans++;
//	            }
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,234,45,67,12,23455,90,9,678,5678,567890};
		System.out.println(findNumber(arr));
	}

}
