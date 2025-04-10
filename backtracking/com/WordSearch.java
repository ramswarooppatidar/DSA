package backtracking.com;

import javax.naming.directory.SearchControls;

public class WordSearch {
	public static boolean isPresentPre(char board[][], String word, int n, int m) {
		int visited[][] = new int[n][m];
		for(int row=0; row<n; row++) {
			for(int col=0; col<m; col++) {
				//find first index of word in board
				if(board[row][col] == word.charAt(0)) {
					boolean wordFound = searchPre(board, visited, word,1, row, col, n, m);
					if(wordFound) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean searchPre(char board[][], int visited[][], String word, int currentIndex, int i, int j, int n, int m) {
		if(currentIndex == word.length()) {
			visited[i][j] = 1;
			for(int p =0; p<n; p++) {
				for(int q =0; q<m; q++) {
					System.out.print(" "+visited[p][q]);
				}
				System.out.println();
			}
			return true;
		}
		visited[i][j] =1;
		//explore all foure direction
		//top
		if(i - 1>=0 && board[i - 1][j] == word.charAt(currentIndex) && visited[i-1][j] == 0) {
			if(searchPre(board, visited, word, currentIndex+1, i - 1, j, n, m)) {
				return true;
			}
		}
		//rigth
				if(j + 1<m && board[i][j + 1] == word.charAt(currentIndex) && visited[i][j + 1] == 0) {
					if(searchPre(board, visited, word, currentIndex+1, i, j + 1, n, m)) {
						return true;
					}
				}
		//bottom
		if(i + 1< n && board[i + 1][j] == word.charAt(currentIndex) && visited[i + 1][j] == 0) {
			if(searchPre(board, visited, word, currentIndex+1, i + 1, j, n, m)) {
				return true;
			}
		}
		
		//left
		if(j - 1>=0 && board[i][j - 1] == word.charAt(currentIndex) && visited[i][j - 1] == 0) {
			if(searchPre(board, visited, word, currentIndex+1, i, j - 1, n, m)) {
				return true;
			}
		}
		visited[i][j] = 0;
		return false;
	}
	
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
		//explore all direction
		//top
		if(i - 1>=0 && visited[i - 1][j] == 0 && board[i - 1][j] == word.charAt(currentIndex)) {
			if(search(board, visited, word, currentIndex + 1, i - 1, j, n, m)) {
				return true;
			}
		}
		
		//right
		if(j +1 < m && visited[i][j+1] == 0 && board[i][j+1] == word.charAt(currentIndex)) {
			if(search(board, visited, word, currentIndex + 1, i, j + 1, n, m)) {
				return true;
			}
		}
		//down
		if(i + 1 <n && visited[i + 1][j] == 0 && board[i + 1][j] == word.charAt(currentIndex)) {
			if(search(board, visited, word, currentIndex + 1, i+1, j , n, m)) {
				return true;
			}
		}
		//left
		if(j -1 >=0 && visited[i][j - 1] == 0 && board[i][j - 1] == word.charAt(currentIndex)) {
			if(search(board, visited, word, currentIndex + 1, i, j - 1, n, m)) {
				return true;
			}
		}
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
		            {'C', 'R', 'A', 'L'},
		            {'A', 'A', 'M', 'S'},
		            {'P', 'O', 'O', 'W'},
		            {'B', 'C', 'R', 'A'}
		        };
		        String word = "RAMSWAROOP";
//		System.out.println(isPresent(board, word, board.length, board[0].length ));
		        
		 System.out.println(isPresentPre(board, word, board.length, board[0].length ));
	}
	

}
