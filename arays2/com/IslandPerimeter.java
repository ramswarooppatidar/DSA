package arays2.com;

public class IslandPerimeter {
	public static int islandPerimeter(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int perimeter=0;
		for(int i =0; i<n; i++) {
			for(int j =0; j<m; j++) {
				if(grid[i][j] == 1) {
					perimeter += 4;
					
					//top
					if(i>0 && grid[i-1][j] == 1) perimeter -= 1;
					
					//bottom
					if(i<n -1 && grid[i+1][j] == 1) perimeter -= 1;
					
					//left
					if(j>0 && grid[i][j-1] == 1) perimeter -= 1;
					
					//right
					if(j<m -1 && grid[i][j+1] == 1) perimeter -= 1;
				}
			}
		}
		return perimeter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
