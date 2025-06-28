package tree.com;

import java.util.ArrayList;
import java.util.List;

public class PathSumRootToLeafe {

	public static List<List<Integer>> pathSumRootLeaf(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		List<List<Integer>> ansList = new ArrayList<>();
		List<Integer> progress = new ArrayList<>();
		pathSumHelper(root, progress, ansList);
		return ansList;
	}
	
	public static void pathSumHelper(BinaryTreeNode<Integer> root, List<Integer> progress, List<List<Integer>> ansList) {
		if(root == null) {
			return;
		}
		 progress.add(root.data);
		if(root.left == null && root.right == null) {
			ansList.add(new ArrayList<Integer>(progress));
			int sum = progress.stream().reduce(0,(a,b)->a+b);
			System.out.println("sum is :"+ sum);
//			progress = new ArrayList<Integer>();
//			return;
		}
		
		 pathSumHelper(root.left, progress, ansList);
		 pathSumHelper(root.right, progress, ansList);
		 progress.remove(progress.size() - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
