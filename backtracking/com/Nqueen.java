package backtracking.com;

public class Nqueen {
	public static void placedNQueens(int n) {
		int board[][] = new int[n][n];
		placeQueens(board, n, 0);
	}
	public static void placeQueens(int board[][], int n, int row) {
		if(row == n) {
			printBoard(n, board);
			return;
		}
		for(int i = 0; i<n; i++) {
			if(isQueenSafe(board, n, row, i)) {
				board[row][i] = 1;
				placeQueens(board, n, row+1);
				board[row][i] = 0;
			}
		}
	}
	private static boolean isQueenSafe(int board[][], int n, int row, int col) {
		//vertical
		for(int i = row -1; i>=0; i--) {
			if(board[i][col] == 1) {
				return false;
			}
		}
		//diagonal top left
		for(int i = row - 1,j = col - 1; i>=0 && j>=0; i--,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		//diagonal right top
		for(int i = row - 1,j = col + 1; i>=0 && j<n; i--,j++) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
	public static void main(String arg[]) {
		placedNQueens(6);
		
	}
	private static void printBoard(int n, int [][]board) {
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
