package array.com;

public class InsertHeap {
	public static void insertHeap(int arr[], int n, int val) {
		n = n+1;
		int  i = n;
		int parentIndex = i/2;
		while(i<=0) {
			
			if(arr[parentIndex]<arr[i]) {
//				swap()
				i = parentIndex;
			}else {
				return;
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
