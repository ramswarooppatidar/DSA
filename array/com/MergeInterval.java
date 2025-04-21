package array.com;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {

	 public static int[][] insert(int[][] intervals, int[] newInterval) {
	        List<int[]> result = new ArrayList<>();
	        int start = newInterval[0];
	        int end = newInterval[1];
	        boolean isInserted = false;
	        
	        for(int[] current : intervals){
	            if(current[1] < start){
	                result.add(current);
	            }
	            else if(current[0] > end){
	                if(!isInserted){
	                    result.add(new int[]{start, end});
	                    isInserted = true;
	                }
	                result.add(current);
	            }else{
	                start = Math.min(start, current[0]);
	                end = Math.max(end, current[1]);
	            }
	        }
	        //if intervals is null or not merge present then directly add this intervals
	        if (!isInserted) {
	            result.add(new int[]{start, end});
	        }
	       

	        return result.toArray(new int[result.size()][]);
	      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = new int[][] {
		    {1, 3},
		    {6, 9}
		};
		int [][] intervals2 = new int[][] {
	  		{1,2},{3,5},{6,7},{8,10},{12,16}
	    };   //insert 4,8
//		int result[][]=  insert(intervals, new int[] {2,5});
	    int result[][]=  insert(intervals2, new int[] {4,8});
		for(int[] arr: result) {
			for(int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
		}


	}

}
