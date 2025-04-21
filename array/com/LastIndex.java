package array.com;

public class LastIndex {

	public static int lastIndex(int arr[], int x) {
		int index = -1;
		for(int i =0; i<arr.length; i++) {
			if(arr[i] == x) {
				index = i;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,4,6,7,3,2,4,5,2,3,5,6,7};
		int index = LastIndex.lastIndex(arr, 7);
		System.out.println("last index :"+index);

	}

}
