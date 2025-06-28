package tree.com;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

	public static List<String> binaryTreePath(BinaryTreeNode<Integer> root) {
		List<String> ans = new ArrayList<>();
		treePathHelper(root, ans, "");
		return ans;
	}
	public static void treePathHelper(BinaryTreeNode<Integer> root, List<String> ans,String progress) {
		if(root == null) {
			return;
		}
		progress += root.data + "->";
		if(root.left == null && root.right == null) {
			ans.add(new String(progress.substring(0, progress.length() - 2)));
			progress="";
		}
		treePathHelper(root.left, ans, progress);
		treePathHelper(root.right, ans, progress);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
