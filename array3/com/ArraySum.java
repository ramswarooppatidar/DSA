package array3.com;

import javax.sql.rowset.JoinRowSet;
public class ArraySum {
	public  static int[] arrySum(int arr[]) {
		int res[] = new int[arr.length];
		res[0] = arr[0];
		int sum = 0;
		for(int i =1; i< arr.length; i++) {
			sum = sum + arr[i-1];
			res[i] = arr[i] + sum;	
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int res[]= arrySum(arr);
		for(int i : res) {
			System.out.print(i+" ");
		}

	}

}
