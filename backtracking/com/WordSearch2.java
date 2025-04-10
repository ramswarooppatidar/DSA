package backtracking.com;

public class WordSearch2 {
	public static boolean isPresent(char board[][], String word, int n, int m) {
		 int visited[][]= new int[n][m];
		 //for every cell in the board , finsd the first latter
		 for(int i =0; i<n;i++) {
			 for(int j =0; j<m; j++) {
				 if(board[i][j] == word.charAt(0)) {
					 boolean wordFound = search(board, visited, word,1, i, j, n, m);
					 if(wordFound) {
						 return true;
					 }
				 }
			 }
		 }
		 return false;
	 }
	static int row[]= {0, 0, -1, +1};
	static int col[] = {+1, -1, 0, 0};
	
	private static boolean search(char[][] board, int[][] visited, String word, int currentIndex, int i, int j, int n, int m) {
		// TODO Auto-generated method stub
		if(currentIndex == word.length()) {
			visited[i][j] = 1;
			 for(int row =0; row<n;row++) {
				 for(int col =0; col<m; col++) {
					 System.out.print(visited[row][col]+" ");
				 }
				 System.out.println();
				}
			return true;
		}
		visited[i][j] = 1;
		for(int move=0; move<4; move++) {
			int nextRow = i + row[move];
			int nextCol = j + col[move];
			if(nextCol>=0 && nextCol<m && nextRow>=0 && nextRow < n && 
					visited[nextRow][nextCol] == 0 && board[nextRow][nextCol] == word.charAt(currentIndex)) {
				if(search(board, visited, word, currentIndex + 1, nextRow, nextCol, n, m)) {
					return true;
				}
			}
		}
		//explore all direction
		//top
//		if(i - 1>=0 && visited[i - 1][j] == 0 && board[i - 1][j] == word.charAt(currentIndex)) {
//			if(search(board, visited, word, currentIndex + 1, i - 1, j, n, m)) {
//				return true;
//			}
//		}
//		
//		//right
//		if(j +1 < m && visited[i][j+1] == 0 && board[i][j+1] == word.charAt(currentIndex)) {
//			if(search(board, visited, word, currentIndex + 1, i, j + 1, n, m)) {
//				return true;
//			}
//		}
//		//down
//		if(i + 1 <n && visited[i + 1][j] == 0 && board[i + 1][j] == word.charAt(currentIndex)) {
//			if(search(board, visited, word, currentIndex + 1, i+1, j , n, m)) {
//				return true;
//			}
//		}
//		//left
//		if(j -1 >=0 && visited[i][j - 1] == 0 && board[i][j - 1] == word.charAt(currentIndex)) {
//			if(search(board, visited, word, currentIndex + 1, i, j - 1, n, m)) {
//				return true;
//			}
//		}
		visited[i][j] = 0;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char board[][] = {{'h', 'h','d', 'b', 'h'}, 
//							{'d', 'e','l', 'w', 'o'},
//							{'z', 's','l', 'o', 'm'}
//							,{'j', 'i','g', 'm', 'k'}};
//		String word = "hello";
		 char board[][] = {
		            {'C', 'A', 'A'},
		            {'A', 'A', 'A'},
		            {'B', 'C', 'D'}
		        };
		        String word = "AAB";
		System.out.println(isPresent(board, word, board.length, board[0].length ));
	}
	


}
