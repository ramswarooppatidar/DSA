package maths.com;

public class ConvertToBase7 {
	public static String base7(int num, int base) {
		StringBuilder sb = new StringBuilder();
		boolean isNegative = false;
		if( num == 0) {
			sb.append(0);
			return sb.toString();
		}
		if(num<0) {
			isNegative = true;
			num = Math.abs(num);
		}
		while(num>0) {
			sb.append(num % base);
			num /= base;
		}
		if(isNegative) {
			sb.append("-");
		}
		return sb.reverse().toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String reString = base7(100, 2);
		System.out.println(reString);

	}

}
