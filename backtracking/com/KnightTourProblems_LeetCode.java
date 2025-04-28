package backtracking.com;

public class KnightTourProblems_LeetCode {

	 public static boolean checkValidGrid(int[][] grid) {
		
		 return helper(grid,0,0,grid.length,0); 
	  }
	 private static boolean helper(int[][]grid, int row, int col, int n, int expValue) {
		 
		 System.out.println("row :"+row+" col :"+col+" expected :"+expValue);
		 if(row<0 || col<0 || row>=n || col>=n || grid[row][col] != expValue) {
			 return false;
		 }
		 if(expValue == (n*n - 1)) {
			 return true;
		 }
		 /*
		  concept of the question is,  vah true return nahi kar raha hi, jeses use 0-->1  milta hai tab,
		  matlb vah next helper function par nahi jayega, vah yahi se next recurrsive call krega,
		  
		  or ese hi chlta jayega,   final true use tab milega jab vah n^2 -1 tak pochega
		  
		  agar ans3  call par use expValue === grid milti hai to vah true retun kaha kar raha hai,  
		  eska matlb ye hua ki, yaha se vah next expValue check krne ke liye jayega,
		  or jab use milega to fir usi jgh se , fir next recussive call krega,
		  ese chlte chlte finall vah reach krega n^2 - 1 tak,  
		  */
		boolean ans1 = helper(grid,row - 2, col + 1,n,expValue + 1);
		boolean ans2 = helper(grid,row + 1, col + 2,n,expValue + 1);
		boolean ans3 = helper(grid,row + 1, col + 2,n,expValue + 1);
		boolean ans4 = helper(grid,row + 2, col + 1,n,expValue + 1);
		boolean ans5 = helper(grid,row + 2, col - 1,n,expValue + 1);
		boolean ans6 = helper(grid,row - 1, col - 2,n,expValue + 1);
		boolean ans7 = helper(grid,row + 1, col - 2,n,expValue + 1);
		boolean ans8 = helper(grid,row + 2, col - 1,n,expValue + 1);
		
		return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int grid[][]= {
//				{0,11,16,5,20},
//				{17,4,19,10,15},
//				{12,1,8,21,6},
//				{3,18,23,14,9},
//				{24,13,2,7,22}
//				};
//		checkValidGrid(grid);
//		
		int grid2[][] = {
				{0,3,6},
				{5,8,1},
				{2,7,4}};
		checkValidGrid(grid2);
		

	}

}
