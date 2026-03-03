package array.twoD.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MatrixCellInDistanceOrder {
	
	public static int[][] matrixCellInDistanceOrder(int row, int col, int rCenter, int cCentre){
		Map<Integer, List<List<Integer>>> map = new TreeMap<>();
		for(int i =0; i< row; i++) {
			for(int j =0; j<col; j++) {
				int dis = Math.abs(i - rCenter) + Math.abs(j - cCentre);
				if(map.containsKey(dis)) {
				List<Integer> list = new ArrayList<Integer>();
				 list.add(i);
				 list.add(j);
				 map.get(dis).add(list);
				}else {
					List<List<Integer>> l2 = new ArrayList<List<Integer>>();
					List<Integer> l = new ArrayList<Integer>();
					 l.add(i);
					 l.add(j);
					 l2.add(l);
					 map.put(dis, l2);
					
				}
			}
		}
			int index = 0;
			int [][] result = new int[row*col][2];
			for(Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
				List<List<Integer>> llList = entry.getValue();
				System.out.println("llist :"+llList);
				for(List<Integer> list : llList) {
					result[index][0] = list.get(0);
					result[index][1] = list.get(1);
					index++;
				}
				
			}
			for(int i =0; i<result.length; i++) {
				for(int j =0; j<result[0].length; j++) {
					System.out.print(result[i][j]+" ");
				}
				System.out.println();
			}
			return result;
		}
	
	public static int[][] matrixCellInDistanceOrder2(int row, int col, int rCenter, int cCentre){
		Map<Integer, List<List<Integer>>> map = new TreeMap<>();
		for(int i =0; i< row; i++) {
			for(int j =0; j<col; j++) {
				int dis = Math.abs(i - rCenter) + Math.abs(j - cCentre);
				if(map.containsKey(dis)) {
				List<Integer> list = new ArrayList<Integer>();
				 list.add(i);
				 list.add(j);
				 map.get(dis).add(list);
				}else {
					List<List<Integer>> l2 = new ArrayList<List<Integer>>();
					List<Integer> l = new ArrayList<Integer>();
					 l.add(i);
					 l.add(j);
					 l2.add(l);
					 map.put(dis, l2);
					
				}
			}
		}
			int index = 0;
			int [][] result = new int[map.size()][];
			for(Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
				List<List<Integer>> llList = entry.getValue();
				int len = llList.get(0).size();
				result[index] = new int[len];
				System.out.println("llist :"+llList);
				for(List<Integer> list : llList) {
					result[index][0] = list.get(0);
					result[index][1] = list.get(1);
					index++;
				}
				
			}
			for(int i =0; i<result.length; i++) {
				for(int j =0; j<result[0].length; j++) {
					System.out.print(result[i][j]+" ");
				}
				System.out.println();
			}
			return result;
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		matrixCellInDistanceOrder(2,3,1,2);
	}

}
