package recurssion.com;

public class ArraySum {

	public static int arraySum(int arr[], int index) {
		if(index == arr.length - 1) {
			return arr[index];
		}
		return arr[index] + arraySum(arr, index+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,4,5,12,13,5,67,89};
		int sum = ArraySum.arraySum(arr, 0);
		System.out.println("sum is : "+sum);

	}

}
