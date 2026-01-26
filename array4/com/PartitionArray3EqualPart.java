package array4.com;

import java.util.Locale.IsoCountryCode;

public class PartitionArray3EqualPart {
	
	public static boolean partitionArrayInThreeEqualPart(int arr[]) {
		int sum = 0;
		for(int n : arr) {
			sum += n;
		}
		if(sum % 3 !=  0) return false;
		
		int t = 0;
		int count = 0;
		for(int s : arr) {
			t += s;
			if(t == sum/3) {
				t = 0;
				count++;
			}
		}
		
		return count >= 3;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,2,3,4,0,4,5,2,1};
		System.out.println(partitionArrayInThreeEqualPart(arr));

	}

}
