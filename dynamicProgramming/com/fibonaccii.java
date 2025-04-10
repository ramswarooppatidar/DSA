package dynamicProgramming.com;

public class fibonaccii {
	public static int fibonaci(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return fibonaci(n - 1) + fibonaci(n - 2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 100;
		for(int i =0; i< n; i++) {
			System.out.print(fibonaci(i)+" ");
		}
	}

}
