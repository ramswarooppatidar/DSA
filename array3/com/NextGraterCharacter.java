package array3.com;

import javax.print.attribute.standard.Chromaticity;

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
	public static char nextGratherCh(char []arr, char target) {
		int minDiffer = Integer.MAX_VALUE;
		char ch = arr[0];
		int index = -1;
		for(int i =0; i<arr.length;i++) {
			char curr = arr[i];
			int currDiff = curr - target;
			if(currDiff >= 1) {
				if(currDiff < minDiffer) {
					minDiffer = currDiff;
					ch = curr;
				}
			}
		}
		return ch;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch[]= {'c','f','j','k','x','z','l'};
		char res= nextGraterElement(ch, 'k');
		System.out.println("ch is :"+res);
		
		char result = nextGratherCh(ch, 'x');
		System.out.println("ch is :"+result);
		

	}

}
