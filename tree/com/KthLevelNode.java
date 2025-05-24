package tree.com;

import java.util.ArrayList;
import java.util.List;

public class KthLevelNode {
	public static List<Integer> kthLevelNodes(BinaryTreeNode<Integer> root,int k){
		List<Integer> ansIntegers = new ArrayList<Integer>();
		helper(root, k, ansIntegers);
		return ansIntegers;
	}
	private static void helper(BinaryTreeNode<Integer> root, int k, List<Integer> list) {
		if(root == null) {
			return;
		}
		if(k == 1) {
			list.add(root.data);
		}
		helper(root.left, k-1, list);
		helper(root.right, k-1, list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
