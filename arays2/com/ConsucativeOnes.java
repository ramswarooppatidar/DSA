package arays2.com;

public class ConsucativeOnes {

	public static int consucativeZero(int arr[]) {
		int count=0;
		int maxCount=0;
		for(int i =0; i<arr.length; i++) {
			if(arr[i] == 1) {
				count++;
			}else {
				maxCount = Math.max(maxCount, count);
				count = 0;
			}
		}
		return Math.max(maxCount, count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
