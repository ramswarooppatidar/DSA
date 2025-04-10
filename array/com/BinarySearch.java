package array.com;

public class BinarySearch {
	public static int  binarySearch(int arr[], int target) {
		int mid = arr.length/2;
		int high = arr.length-1;
		int low = 0;
		while(low<=high) {
			mid = low + (high-low)/2;
			if(target< arr[mid]) {
				high = mid -1;
				System.out.println("target< arr[mid] "+arr[mid]);
			}else if(target > arr[mid]) {
				low = mid+1;
				System.out.println("target>arr[mid]"+arr[mid]);
			}else {
				System.out.println("else ");
				return mid;
				
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("this is ");
		int arr[]= {2,3,5,7,9,10,15,16,18,20,24,34,36,45};
		int index =	BinarySearch.binarySearch(arr, 45);
		System.out.println("index :"+index);
	}

}
