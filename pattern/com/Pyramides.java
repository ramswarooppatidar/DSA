package pattern.com;

public class Pyramides {

	public static void pascleTraingle(int n) {
		int k=1;
		while(k<=n) {
			for(int j = 0; j < n-k; j++) {
				System.out.print(" ");
			}
			for(int i=0; i<k; i++) {
				if(i== 0 || i+1 == k) {
					System.out.print(1+" ");
				}else {
					System.out.print(1+" ");
				}	
			}
		    System.out.println();
			
			k++;
		}
		int l = 0;
		while(l<n) {
			for(int i =0; i<l+1; i++) {
				System.out.print(" ");
			}
			for(int j =0; j<n-l-1; j++) {
				if(j == 0 || j  == n - l-2) {
					System.out.print(1+" ");
				}else {
					System.out.print(1+" ");
				}
			}
			System.out.println();
		 l++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pascleTraingle(6);

	}

}
