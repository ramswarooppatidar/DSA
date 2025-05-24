package arays2.com;

public class ProductArray {
	public static int[] productArray(int arr[]) {
		int res[] = new int[arr.length];
		int leftSum[] = new int[arr.length];
		leftSum[0] = 1;
		int rightSum[] = new int[arr.length];
		rightSum[arr.length - 1]=1;
		for(int i =1; i<arr.length; i++) {
			leftSum[i] = arr[i-1]*leftSum[i-1];
			System.out.println(leftSum[i]);
		}
		for(int i = arr.length - 2; i>=0; i--) {
			rightSum[i] = arr[i+1]*rightSum[i+1];
			System.out.println(rightSum[i]);
		}
		int k =0;
		while(k<arr.length) {
		    res[k] = leftSum[k] * rightSum[k];
			k++;
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1, 2,3,4,5,9,7,5};
		int res[]= productArray(arr);
		for(int i : res) {
			System.out.print(i+" ");
		}

	}

}
