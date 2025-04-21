package recurssion.com;

public class ConvertNumStringToInteger {

	public static int convertNumStringToInteger(String str, int val) {
		if(str.length() == 0) {
			return val;
		}
		val = val*10 + Character.getNumericValue(str.charAt(0));
		return convertNumStringToInteger(str.substring(1), val);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = ConvertNumStringToInteger.convertNumStringToInteger("2345151", 0);
		System.out.println("int value is :"+value);

	}

}
