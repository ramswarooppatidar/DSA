package pattern.com;

public class StringPyramid {
	public static void pyramidString(String s, int space) {
		if(s.length() == 0) {
			return;
		}
		String str = s.toUpperCase();
		int k=0;
		while(k<space) {
			System.out.print(".");
			k++;
		}
		for(int i=0;i<str.length(); i++) {
			
			System.out.print(str.charAt(i)+" ");
		}
		System.out.println(" ");
		pyramidString(s.substring(1), space + 1);
	}
	
	public static void rotatedPyramid(String s, int index) {
		if(index == -1) {
			return;
		}
		String str = s.substring(index);
		
		for(int i=0; i<str.length(); i++) {
			System.out.print(str.charAt(i)+" ");
		}
		
		System.out.println();
				rotatedPyramid(s,index - 1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "ramswaroopanuradha";
		pyramidString("ramswaroopanuradha", 0);
		rotatedPyramid(string, string.length()-1);

	}

}
