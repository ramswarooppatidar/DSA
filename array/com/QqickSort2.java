package array.com;

public class QqickSort2 {
	public static void quickSort(int arr[], int start, int end) {
		if(start<end) {
			int pivotIndex = partition(arr,start, end);
			quickSort(arr, start, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int idx = start - 1;
		int pivot = arr[end];
		for(int j = start; j<end; j++) {
			if(arr[j] <= pivot) {  //ascending descending
				idx++;
				swap(arr,j,idx);
			}
		}
		idx++;
		swap(arr, idx,end);
		return idx;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,14,6,9,23,15,67,0,-1,33,40,11,1111,19,29,44,56,78,23,5,7,8,99,123};
		quickSort(arr, 0, arr.length - 1);
		System.out.println("quick sort  ");
		for(Integer i : arr) {
			System.out.print(i+" ");
		}

	}
	/*
	 worst cas time complexity is n^2 if we pick larget element or smallest element if we picked
	 an average tiem complexity is nlogn
	 
	 space complexity o(1);
	 if data is large , and for space complexity we used quick sort at the place of merge sort
	 */

}
