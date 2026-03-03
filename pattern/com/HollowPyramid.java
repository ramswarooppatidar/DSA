package pattern.com;

import javax.crypto.KEM;

public class HollowPyramid {
	public static void hollowPyramid(int n) {
		int k =1;
		while(k<n) {
			//space
			for(int i =0;i<n-k;i++) {
				System.out.printf("   ");
			}
			for(int i =0; i<k; i++) {
				if(i ==0 || i==k-1) {
					System.out.printf("%-3d", "*");
					System.out.printf("%-3d",k + i);	
				}else {
					System.out.printf("%-3d");
				}
			}
			System.out.println();
			k++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hollowPyramid(4);
	}

}
