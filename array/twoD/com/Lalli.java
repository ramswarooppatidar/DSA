package array.twoD.com;

public class Lalli {
	
	public static int sumLalli(int a, int b) {
		int sum = a + b;
		return sum;
	}
	
	public static void table(int a) {
		for(int i=1; i<= 10000; i++) {
			System.out.println(a+"*"+i+"  :  "+a*i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lalli gova");
		
		int a = 10;
		int b = 20;
		int sum = a + b;
		System.out.println("sum :"+sum);
		
		int result =  sumLalli(2,5);
		System.out.println("result :"+result);
		
		
		System.out.println(sumLalli(6,7));
		table(17);

	}

}
