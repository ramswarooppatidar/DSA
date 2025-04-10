package array.com;

public class SelectionSort {
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		for(int i =0; i<n-1; i++) {
			int min = arr[i];
			int minIndex=i;
			
			int k =i;
			int j = i + 1;
			for( ; j< n; j++) {
				if(arr[j]<min) {
					min = arr[j];
					k = j;
				}
			}
			if(k != i) {
				swap(arr, k, minIndex);
			}
		}
	}
	public static void selectionSort_2(int arr[]) {
		for(int i =0; i<arr.length-1; i++) {
			int min = arr[i];
			int minIndex =i;
			int k =i;
			for(int j = i+1; j<arr.length; j++) {
				if(arr[j]<min) {
					min = arr[j];
					k=j;
				}
			}
			swap(arr, minIndex, k);
		}
	}
	public static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,14,14,14,6,9,23,15,67,0,0,-1,33,40,11,19,29,44,56,78,23,5,7,8,99,123};
//		selectionSort(arr);
		selectionSort_2(arr);
		System.out.println("insertion sort  ");
		for(Integer i : arr) {
			System.out.print(i+" ");
		}
	}
}
