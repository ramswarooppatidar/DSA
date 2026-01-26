package dsa.bitwise.com;

public class ComplementOfBase10Integer {
	
	public static int bitwiseComplements(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			sb.append(n % 2);
			n /= 2;
		}
		sb.reverse();
		
		StringBuilder temp = new StringBuilder();
		for(int i = sb.length() - 1; i >= 0; i--) {
			if(sb.charAt(i) == '1') {
				temp.append(0);
			}else {
				temp.append(1);
			}
		}
		
		int decimal = 0;
		int power = 0;
		for(int i = temp.length() - 1; i >= 0; i--) {
			if(temp.charAt(i) == 1) {
				decimal += Math.pow(2, power);
			}
			power++;
		}
		
		return decimal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
