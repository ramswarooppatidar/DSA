package backtracking.com;
public class Shudoku {
    public boolean isValidSudoku(char[][] board) {
        return helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int row, int col) {
        // Reached end of board
        if (row == 9) return true;

        // Move to next cell
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // Skip filled cells
        if (board[row][col] != '.') {
            return helper(board, nextRow, nextCol);
        }

        for (int dig = 1; dig <= 9; dig++) {
            if (isSafe(board, row, col, dig)) {
                board[row][col] = (char)(dig + '0');
                if (helper(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = '.'; // backtrack
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, int dig) {
        char digit = (char)(dig + '0');

        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
}
