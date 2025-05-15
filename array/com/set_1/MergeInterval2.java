package array.com.set_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class MergeInterval2 {
	//this is not passed contiuos overlapping interval more than 2
    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
       for(int i =1; i<intervals.length; i++){
            int current[] = intervals[i];
            int previous[] = intervals[i - 1];
            int start = current[0];
            int end = current[1];
            if(previous[1]< start){
                result.add(previous);
                result.add(current);
            }
            else if(previous[1]>=start){
                result.add(new int[]{previous[0], end});
                i++;
            }else{
                result.add(current);
            }
       }
        return result.toArray(new int[result.size()][]);
    }
    
    //this is pass all test case; 
    public static int[][] merge2(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        
       int []current = intervals[0];
       for(int i =1; i<intervals.length; i++){
           int next[] = intervals[i];
           if(current[1]>= next[0]) {
        	   current[1] = Math.max(current[1], next[1]);
           }else {
        	   result.add(current);
        	   current = next;
           }
       }
       //add last intervals
       result.add(current);
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
    	int arr[][] = {{1,3}, {2, 6}, {8, 10}, {15, 18}};
    	int arr2[][] = {{1,4}, {0, 4}};
    	int arr3[][] = {{1,4}, {0, 0}};
    	int arr4[][] = {{1,4}, {0,2},{3,5}};
    	
    	int [][]Result = merge(arr);
    	System.out.print("[");
    	for(int[] a1 : Result) {
    		System.out.print("[");
    		for(int i : a1) {
    			System.out.print(i+" ");
    		}
    		System.out.print("] , ");
    	}
    	System.out.print("]");
    	System.out.println();
    	
    	int [][]Resul = merge2(arr);
    	System.out.print("[");
    	for(int[] a1 : Resul) {
    		System.out.print("[");
    		for(int i : a1) {
    			System.out.print(i+" ");
    		}
    		System.out.print("] , ");
    	}
    	System.out.print("]");
    	System.out.println("\n");
    	
    	
    	
    	
    	int [][]Result1 = merge(arr2);
    	System.out.print("[");
    	for(int[] a1 : Result1) {
    		System.out.print("[");
    		for(int i : a1) {
    			System.out.print(i+" ");
    		}
    		System.out.print("] , ");
    	}
    	System.out.print("]");
    	System.out.println();
    	
    	int [][]Resul1 = merge2(arr2);
    	System.out.print("[");
    	for(int[] a1 : Resul1) {
    		System.out.print("[");
    		for(int i : a1) {
    			System.out.print(i+" ");
    		}
    		System.out.print("] , ");
    	}
    	System.out.print("]");
    	System.out.println("\n");
    	
    	
    	
    	
    	int [][]Result3 = merge(arr3);
    	System.out.print("[");
    	for(int[] a1 : Result3) {
    		System.out.print("[");
    		for(int i : a1) {
    			System.out.print(i+" ");
    		}
    		System.out.print("] , ");
    	}
    	System.out.print("]");
    	System.out.println();
    	
    	int [][]Resul3 = merge2(arr3);
    	System.out.print("[");
    	for(int[] a1 : Resul3) {
    		System.out.print("[");
    		for(int i : a1) {
    			System.out.print(i+" ");
    		}
    		System.out.print("] , ");
    	}
    	System.out.print("]");
    	System.out.println("\n");
    	
    	
    	
    	
    	int [][]Result4 = merge(arr4);
    	System.out.print("[");
    	for(int[] a1 : Result4) {
    		System.out.print("[");
    		for(int i : a1) {
    			System.out.print(i+" ");
    		}
    		System.out.print("] , ");
    	}
    	System.out.print("]");
    	System.out.println();
    	
    	int [][]Resul4 = merge2(arr4);
    	System.out.print("[");
    	for(int[] a1 : Resul4) {
    		System.out.print("[");
    		for(int i : a1) {
    			System.out.print(i+" ");
    		}
    		System.out.print("] , ");
    	}
    	System.out.print("]");
    	System.out.println();
	}
}
