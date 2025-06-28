package array.com;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CountCoverdBuilding {
	 public int countCoveredBuildings(int n, int[][] buildings) {
	        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
	        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();

	        // Build the maps
	        for (int[] b : buildings) {
	            int x = b[0], y = b[1];
	            rowMap.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
	            colMap.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
	        }

	        int count = 0;

	        for (int[] b : buildings) {
	            int x = b[0], y = b[1];
	            TreeSet<Integer> row = rowMap.get(y); // same horizontal line
	            TreeSet<Integer> col = colMap.get(x); // same vertical line

	            boolean hasLeft = row.lower(x) != null;
	            boolean hasRight = row.higher(x) != null;
	            boolean hasDown = col.lower(y) != null;
	            boolean hasUp = col.higher(y) != null;

	            if (hasLeft && hasRight && hasUp && hasDown) {
	                count++;
	            }
	        }

	        return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
