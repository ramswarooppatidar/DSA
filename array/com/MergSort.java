package array.com;

public class MergSort {
	public static void mergeSort(int arr[]) {
		if(arr.length <2) {
			return;
		}
		int mid = arr.length/2;
		int left[] = new int[mid];
		int right[] = new int[arr.length - mid];
		
		for(int i =0;i<mid; i++) {
			left[i] = arr[i];
		}
		int k=0;
		for(int j =mid;j<arr.length; j++) {
			right[k] = arr[j];
			k++;
		}
		
		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
		
	}
	public static void merge(int arr[], int left[], int right []) {
		int i =0;
		int j =0;
		int k =0;
		while(i < left.length && j < right.length) {
			if(left[i]<right[j]) {
				arr[k++] = left[i++];
//				i++;
//				k++;
			}else {
				arr[k++]=right[j++];
//				j++;
//				k++;
			}
		}
		while(i<left.length) {
			arr[k++] = left[i++];
//			i++;
//			k++;
		}
		while(j < right.length) {
			arr[k++]=right[j++];
//			j++;
//			k++;
		}
	
	}
	public static void mergSort_2(int arr[]) {
		if(arr.length<2) {
			return;
		}
		int mid = arr.length/2;
		int left[] = new int[mid];
		int right[] = new int[arr.length - mid];
		for(int i =0; i<mid; i++) {
			left[i]=arr[i];
		}
		for(int i =mid; i<arr.length; i++) {
			right[i-mid]=arr[i];
		}
		mergSort_2(left);
		mergSort_2(right);
		sort_2(arr, left, right);
	}
	public static void sort_2(int arr[], int left[], int right[]) {
		int i=0;
		int j=0;
		int k=0;
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				arr[k++]=left[i++];
			}else {
				arr[k++]=right[j++];
			}
		}
		while(i<left.length) {
			arr[k++]=left[i++];
		}
		while(j<right.length) {
			arr[k++]=right[j++];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,14,6,9,23,15,67,0,-1,33,40,11,19,29,44,56,78,23,5,7,8,99,123};
//		int arr[]= {2,14,6,9,23,15};
//		mergeSort(arr);
		mergSort_2(arr);
		System.out.println("merge sort  ");
		for(Integer i : arr) {
			System.out.print(i+" ");
		}
	}

}
