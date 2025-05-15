package array.com;

public class SearchInRotedSortedArray {
   public static int serach(int arr[], int target) {
	   int left = 0;
	   int right = arr.length - 1;
	   while(left <= right) {
		   int mid = (left + right )/2;
		   
		   if(arr[mid] == target) {
			   return mid;
		   } 
		   
		   if(arr[left] <= arr[mid] ) {
			   //check left sorted
			   if(arr[left]<=target && target < arr[mid]) {
				   right = mid -1;
			   }else {
				   left = mid + 1;
			   }
		     }else {
			   if(arr[mid] < target && target <= arr[right] ) {
				   left = mid + 1;
			   }else {
				   right = mid - 1;
			   }
		   }   
	   }
	   return -1;
	   
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,6,7,8,9,10,0,1,2,3,4};
		int index = serach(arr, 11);
		System.out.println("index is :"+index);

	}

}
