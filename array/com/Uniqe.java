package array.com;

public class Uniqe {

	public static int findUnique(int arr[]) {
		int sign = arr[0];
		for(int i =1; i<arr.length; i++) {
			sign = sign^arr[i];
			System.out.println("sign :"+ sign);
		}
		return sign;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,5,6,3,2,5,6,7,1};
		int result = Uniqe.findUnique(arr);
		System.out.println("answaer :"+result);

	}

}
