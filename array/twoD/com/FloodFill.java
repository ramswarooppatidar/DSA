package array.twoD.com;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.Box.Filler;

public class FloodFill {

	public static int[][] floodFill(int image[][], int r, int c, int color){
		int oldColor = image[r][c];
		if(oldColor == color) return image;
		
		fill(image, r,c,oldColor, color);
		return image;
	}
	private static void fill(int[][] image, int r, int c, int oldColor, int newcolor) {
		if(r < 0 || r > image.length || c < 0 || c >= image[0].length) {
			return;
		}
		
		if(oldColor != newcolor) return;
		
		image[r][c] = newcolor;
		
		fill(image, r - 1, c, oldColor, newcolor);
		fill(image, r + 1, c, oldColor, newcolor);
		fill(image, r, c - 1, oldColor, newcolor);
		fill(image, r, c + 1, oldColor, newcolor);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
