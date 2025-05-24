package tree.com;

public class LavelOrderAnchestors {
	public static BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q){
		if(root == null) {
			return null;
		}
		
		if(root.data == p.data || root.data == q.data) {
			return root;
		}
		BinaryTreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
		BinaryTreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);
		
		if(left != null && right != null) {
			return root;
		}else if(left != null) {
			return left;
		}else if(right != null) {
			return right;
		}else {
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
