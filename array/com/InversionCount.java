package array.com;

public class InversionCount {

	public static int inversionCount(int arr[]) {
		int invCount=0;
		for(int i =0; i<arr.length-1; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					invCount++;
				}
			}
		}
		System.out.println(invCount);
		return invCount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {6,3,5,2,7};
		inversionCount(arr);

	}

}
