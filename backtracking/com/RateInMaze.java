package backtracking.com;

public class RateInMaze {
	public static boolean rateInMaze(int maze[][]) {
		int n = maze.length;
		int path[][] = new int[n][n];
		return solveMaze(maze, 0, 0, path);
		
	}
	public static boolean solveMaze(int maze[][], int i, int j, int path[][]) {
		int n = path.length;
		if(i < 0 || i>=n || j<0 || j>=n || maze[i][j] == 0 || path[i][j] == 1) {
			return false;
		}
		path[i][j] = 1;
		//destination
		if(i == n-1 && j == n - 1) {
//			path[i][j] = 1;
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
		boolean res = rateInMaze(maze);
		System.out.println("isSolution possible :"+res);
		
	}

}
