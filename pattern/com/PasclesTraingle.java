package pattern.com;

import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasclesTraingle {
	public static List<List<Integer>> pascleTraingle(int n){
		 List<List<Integer>> pascleList = new ArrayList<>();
		int k=1;
		while(k<=n) {
			  List<Integer> small = new ArrayList<Integer>();
			  if(k == 1) {
				  small.add(1);
				  pascleList.add(small);
			  }
			  else if(k == 2) {
				  small.add(1);
				  small.add(1);
				  pascleList.add(small);
			  }else {
				  for(int i =0; i<k; i++) {
					  if(i ==0 || i == k - 1) {
						  small.add(1);
					  }else {
						  List<Integer> prev = pascleList.get(k-2);
						  int sum = prev.get(i-1)+prev.get(i);
						  small.add(sum);
					 }	 
				  }
				  pascleList.add(small);	  
			  }	  
			k++;
		}
		return pascleList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> ansList = pascleTraingle(6);
		int count = ansList.size();
		for(List<Integer> list : ansList) {
			for(int i =1; i<count; i++) {
				System.out.print(" ");
			}
			for(int i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
			count--;
		}

	}

}
