package array3.com;

public class NextGraterCharacter {
	public static char nextGraterElement(char []letters, char target) {
		int n = letters.length;
		int minDiffer = 100;
		char ch = letters[0];
		for(int i=0; i<n; i++) {
			int currDiff = letters[i] - target;
			System.out.println("current diff :"+currDiff);
			if(letters[i] - target >=1) {
				if(currDiff <= minDiffer) {
					minDiffer = currDiff;
					ch = letters[i];
					System.out.println("ch :"+ch);
				}
			}
		}
		return ch;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch[]= {'c','f','j'};
		char res= nextGraterElement(ch, 'c');
		System.out.println("ch is :"+res);

	}

}
