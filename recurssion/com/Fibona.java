package recurssion.com;

import java.awt.image.BufferStrategy;

import javax.swing.text.FieldView;

public class Fibona {
	public static void fib(int num, int first, int second) {
		if(num == 0) {
//			System.out.println(first);
			return;
		}
		int nextNum = first + second;
		System.out.print(first+" ");
		second = first;
		first = nextNum;
		fib(num-1, first, second);
	}
	 public static int fibonacci(int n) {
	        if (n <= 1) {
	            return n;
	        } else {
	            return fibonacci(n - 1) + fibonacci(n - 2);
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	fib(10, 0, 1);
	
	 long start = System.currentTimeMillis();
	 System.out.println(fibonacci(52));
	 long end = System.currentTimeMillis();
	 double timeInSeconds = (end - start) / 1000.0;
     System.out.println("Total time: " + timeInSeconds + " seconds");

	}
}
