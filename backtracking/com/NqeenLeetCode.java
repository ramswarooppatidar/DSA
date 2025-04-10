package backtracking.com;
import java.util.*;
public class NqeenLeetCode {
	public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				board[i][j] = '.';
			}
		}
        List<List<String>> result = new ArrayList<>();
        placeQueens(board, n, 0, result);
        return result;

    }
    public void placeQueens(char board[][], int n, int row, List<List<String>> result) {
		if(row == n) {
			// printBoard(n, board);
            List<String> sunAns = new ArrayList<>();
            for(int i =0;i<n; i++){
                // StringBuilder sb = new StringBuilder();
                String sb="";
                for(int j =0; j<n; j++){
                    sb += String.valueOf(board[i][j]);
                }
                sunAns.add(sb);
            }
            result.add(sunAns);
			return;
		}
		for(int i = 0; i<n; i++) {
			if(isQueenSafe(board, n, row, i)) {
				board[row][i] = 'Q';
				placeQueens(board, n, row+1, result);
				board[row][i] = '.';
			}
		}
	}
	private static boolean isQueenSafe(char board[][], int n, int row, int col) {
		//vertical
		for(int i = row -1; i>=0; i--) {
			if(board[i][col] == 'Q') {
				return false;
			}
		}
		//diagonal top left
		for(int i = row - 1,j = col - 1; i>=0 && j>=0; i--,j--) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		//diagonal right top
		for(int i = row - 1,j = col + 1; i>=0 && j<n; i--,j++) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
