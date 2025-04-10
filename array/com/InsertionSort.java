package array.com;

public class InsertionSort {
	// index =0, sorted sublist
	// index 1 to length, unsorted
	public static void insertionSort(int arr[]) {
		int n = arr.length;
		for(int i = 1; i<n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while(j>=0 && arr[j]>temp) {
				arr[j +1] = arr[j];
				j--;
			}
			arr[j + 1]=temp;
		}
		
	}
	public static void insertionSory_2(int arr[]) {
		for(int i =1; i<arr.length;i++) {
			int temp = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>temp) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,14,6,9,23,15,67,0,-1,33,40,11,19,29,44,56,78,23,5,7,8,99,123};
//		insertionSort(arr);
		insertionSory_2(arr);
		System.out.println("insertion sort  ");
		for(Integer i : arr) {
			System.out.print(i+" ");
		}
	}

}
