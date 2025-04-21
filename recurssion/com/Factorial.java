package recurssion.com;

public class Factorial {

	public static int fact(int n) {
		if(n==0) {
			return 1;
		}
		return n*fact(n-1);
	}
	public static int sun(int n) {
		if(n == 1) {
			return 1;
		}
		return n + sun(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fact = Factorial.fact(3);
		System.out.println("fact is :"+fact);
		int sum = Factorial.sun(7);
		System.out.println("sum is "+sum);
	}

}
