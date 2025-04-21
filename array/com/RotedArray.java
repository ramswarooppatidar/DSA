package array.com;

public class RotedArray {

	public static void rottedRight(int arr[], int n) {
		if(n >arr.length) {
			n = n% arr.length;
		}
		for(int i=0; i<n; i++) {
			int temp = arr[arr.length-1];
			for(int j =arr.length -1; j>0; j--) {
			    arr[j] = arr[j-1];
		
			}
			arr[0] = temp;
			
		}
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void RotedLeft(int arr[], int n) {
		if(n > arr.length) {
			n = n % arr.length;
		}
		for(int i =0; i<n; i++) {
			int temp = arr[0];
			for(int j =0; j<arr.length-1; j++) {
				arr[j] = arr[j+1];
			}
			arr[arr.length -1]=temp;
			for(int k : arr) {
				System.out.print(k+" ");
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6};
//		rottedRight(arr, 8);
		RotedLeft(arr,5);

	}

}
