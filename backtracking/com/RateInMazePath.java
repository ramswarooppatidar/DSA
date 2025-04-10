package backtracking.com;

public class RateInMazePath {
	public static void rateInMaze(int maze[][]) {
		int n = maze.length;
		int path[][] = new int[n][n];
//		return solveMaze(maze, 0, 0, path);
		printAllPath(maze, 0, 0, path);
		
		
	}
	public static void printAllPath(int maze[][], int i, int j, int path[][]) {
		int n = path.length;
		if(i < 0 || i>=n || j<0 || j>=n || maze[i][j] == 0 || path[i][j] == 1) {
			return ;
		}
		path[i][j] = 1;
		//destination
		if(i == n-1 && j == n - 1) {
			for(int r =0;r<n;r++) {
				for(int c =0; c<n; c++) {
					System.out.print(path[r][c]+" ");
				}
				System.out.println();
			}
			path[i][j] = 0;
			System.out.println("\n");
			return;
		}	
		//exploring path
		//top
		printAllPath(maze, i - 1, j, path) ;
		
		//right
		printAllPath(maze, i, j + 1, path);
	
		
		//down
		printAllPath(maze, i + 1, j, path);
		
		//left
		printAllPath(maze, i , j - 1, path);
		path[i][j] = 0;
		
	}
	public static boolean solveMaze(int maze[][], int i, int j, int path[][]) {
		int n = path.length;
		if(i < 0 || i>=n || j<0 || j>=n || maze[i][j] == 0 || path[i][j] == 1) {
			return false;
		}
		path[i][j] = 1;
		//destination
		if(i == n-1 && j == n - 1) {
			for(int r =0;r<n;r++) {
				for(int c =0; c<n; c++) {
					System.out.print(path[r][c]+" ");
				}
				System.out.println();
			}
			
			return true;
		}	
		//exploring path
		//top
		if(solveMaze(maze, i - 1, j, path)) {
			return true;
		}
		//right
		if(solveMaze(maze, i, j + 1, path)) {
			return true;
		}
		//down
		if(solveMaze(maze, i + 1, j, path)) {
			return true;
		}
		//left
		if(solveMaze(maze, i , j - 1, path)) {
			return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maze[][] = {{1, 1, 0}, {1, 1, 0},{1, 1, 1}};
		rateInMaze(maze);
	
		
	}

}
