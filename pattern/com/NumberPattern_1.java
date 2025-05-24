package pattern.com;

public class NumberPattern_1 {
	public static void pattern(int n) {
		int k =0;
		while(k<n) {
			int val = k*n;
			//space
			for(int i =0; i<n - 1-k; i++) {
					System.out.print("  ");
				}
			for(int i =1; i<=n; i++) {
				if(k%2 == 0) {
					System.out.print(val + i+" ");	
				}else {
					System.out.print(val + n +1- i+" ");	
				}	
			}
			System.out.println();
			k++;
		}
	}
	public static void patternAligment(int n) {
		int k =0;
		while(k<n) {
			int val = k*n;
			//space
			for(int i =0; i<n - 1-k; i++) {
					System.out.print("   ");  //7 " "
				}
			for(int i =1; i<=n; i++) {
				if(k%2 == 0) {
					System.out.printf("%-3d",val + i);	
				}else {
					System.out.printf("%-3d" , (val + n +1- i));	
				}	
			}
			System.out.println();
			k++;
		}
	}
	
	public static void pattern2(int n) {
        for (int row = 0; row < n; row++) {
            // Print leading spaces (each space block is "  ")
            for (int space = 0; space < n - row - 1; space++) {
                System.out.print("  ");  // 2 spaces for each missing number
            }

            // Print numbers 1 to n
            for (int num = 1; num <= n; num++) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pattern(4);
		patternAligment(6);
		pattern2(4);

	}

}
