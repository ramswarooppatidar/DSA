package array3.com;

public class SingleElementInSortedArray {
	public static int singleElements(int nums[]) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left)/2;
			if(nums[mid] == nums[mid + 1]) {
				mid = mid - 1;
			}
			int leftPart = (mid - left) + 1;
			if(leftPart % 2 == 1) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		System.out.println("single :"+nums[left]);
		return nums[left];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		singleElements(new int [] {1,1,3,3,4,5,5,6,6});

	}

}
