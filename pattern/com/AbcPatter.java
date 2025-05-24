package pattern.com;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class AbcPatter {
	public static void pattern(int n) {
		int k =1;
		int j= 'A'-0;
		while(k<=n) {
			for(int i =0; i<k;i++) {
			
//				char ch = (char) ('A'+i+k-1);
//				System.out.print(ch+" ");
				
				char ch = (char) (j++);
				System.out.print(ch+" ");
			}
			System.out.println();
			k++;
		}
	}
	public static void patter2(int n) {
		int k =1;
		int j=1;
		while(k<n) {
			for(int i=0; i<k;i++) {
				System.out.print(j+" ");
				j++;
			}
			System.out.println();
			k++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pattern(7);
		patter2(15);

	}

}
