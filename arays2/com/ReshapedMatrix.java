package arays2.com;

public class ReshapedMatrix {
	public static int[][] reshaped(int grid[][], int r, int c){
		int n = grid.length;
		int m = grid[0].length;
		if(r > n*m) {
			return grid;
		}
		int totalElement = n *m;
		int col = totalElement/r;
		int row = r;
		int res[][] = new int[row][col];
		int p=0;
		int q=0;
		for(int i =0;i<n; i++) {
			for(int j =0; j<m; j++) {
				if(p<row) {
					if(q == col) {
						q = 0;
						p++;
						res[p][q++]=grid[i][j];
						System.out.println("if :"+grid[i][j]);
					}else {
						res[p][q++]=grid[i][j];
						System.out.println("else :"+grid[i][j]);
					}	
				}	
			}
		}
		return res;
	}
	

	    public int[][] matrixReshape(int[][] mat, int r, int c) {
	        int n = mat.length;
	        int m = mat[0].length;
	        if(m*n != r*c) {
	        	return mat;
	        }
	        int res[][] = new int[r][c];
	        for(int i =0; i<n*m; i++) {
	        	res[i/c][i%c] = mat[i/m][i % m];
	        }
	        return res;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,2,3}, {4,5, 6}, {7, 8, 9}, {10,11,12}};
		int res[][] = reshaped(arr,1,4);
		for(int i =0; i<res.length; i++) {
			for(int j =0; j<res[0].length; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		
		int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
		int res1[][] = reshaped(mat,42,5);
		for(int i =0; i<res1.length; i++) {
			for(int j =0; j<res1[0].length; j++) {
				System.out.print(res1[i][j]+" ");
			}
			System.out.println();
		}


	}

}
