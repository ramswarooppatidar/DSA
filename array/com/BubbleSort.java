package array.com;

import java.lang.classfile.instruction.NewMultiArrayInstruction;

public class BubbleSort {

	//improved time compexity
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for(int i =0; i<n-1;i++) {
			int flag = 0;
			for(int j =0; j<n - 1 -i; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					flag = 1;
				}
			}
			if(flag == 0) {
				break;
			}
		}
	}
	public static void bubbleSort_2(int arr[]) {
		for(int i =0; i<arr.length-1; i++) {
			for(int j =i+1; j<arr.length-i; j++) {
				if(arr[j]<arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,14,6,9,23,15,67,0,-1,33,40,11,19,29,44,56,78,23,5,7,8,99,123};
//		bubbleSort(arr);
		bubbleSort_2(arr);
		for(Integer i : arr) {
			System.out.print(i+" ");
		}
	}

}
