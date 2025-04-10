package array.com;

import java.awt.image.BufferStrategy;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class QuickSort {
	public static void quick(int arr[], int low, int hi) {
		if(low >= hi) {
			return;
		}
		boolean isNibbi= true;
		int e = hi;
		int s = low;
		int mid = e -(e - s)/2 ;
		int pivot = arr[mid];
		while(s<= e) {
			if(arr[s]<pivot) {
				s++;
			}else if(arr[e]>pivot) {
				e--;
			}else {
				int temp = arr[e];
				arr[e] = arr[s];
				arr[s] = temp;
				s++;
				e--;
			}
		}
		quick(arr, low, e);
		quick(arr, s , hi);
	}
	public static int partition(int arr[], int lb, int ub) {
		//7 6 10 5 9 2 1 15 7
		//7 6 7 5 9 2 1 15 10
		//7 6 7 5 1 2 9 15 10
		int pivot = arr[lb];
		int start = lb;
		int end = ub;
		while(start<end) {
			//start < ub   this condition must for
			//int arr[]= {2,14,6,9,23,15,67,0,-1,33,40,11,1111, 19,29,44,56,78,23,5,7,8,99,123}  if
			while(arr[start] <= pivot && start < ub) {
				start++;
			}
			while(arr[end]> pivot) {
				end--;
			}
			if(start<end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
//		swap(arr[lb], arr[end]);
		int temp = arr[lb];
		arr[lb] = arr[end];
		arr[end] = temp;
		return end;
		
	}
	public static void quickSortJenny(int arr[], int lb, int ub) {
		if(lb < ub) {
			int pivotIndex = partition(arr, lb, ub);
			quickSortJenny(arr, lb, pivotIndex - 1);
			quickSortJenny(arr, pivotIndex + 1, ub);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[]= {2,14,6,9,23,15,67,0,-1,33,40,11,19,29,44,56,78,23,5,7,8,99,123};
//		quick(arr, 0, arr.length - 1);
//		System.out.println("quick sort  ");
//		for(Integer i : arr) {
//			System.out.print(i+" ");
//		}
		
		int arr[]= {2,14,6,9,23,15,67,0,-1,33,40,11,1111,19,29,44,56,78,23,5,7,8,99,123};
		quickSortJenny(arr, 0, arr.length - 1);
		System.out.println("quick sort  ");
		for(Integer i : arr) {
			System.out.print(i+" ");
		}
	}
}
