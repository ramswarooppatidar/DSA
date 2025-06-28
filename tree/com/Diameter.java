package tree.com;

public class Diameter {
	static int ans=0;
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		ans = Math.max(leftHeight+rightHeight, ans);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	public static int diameter(BinaryTreeNode<Integer> root) {
		height(root);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = {1, 2, 4, 8, -1, -1, 9, -1, -1, 5, 10, -1, -1, 11,
				-1, -1, 3, 6, -1, 12, 13, 17, 19, -1, -1, -1, 18, -1, -1, -1, 7, 14, -1, -1, 15, -1, 16, -1, -1};
		int preOrder2[] = {13,17,19,-1,-1,-1,18,-1,-1};
		TreeUse_5 obj = new TreeUse_5();
		
		BinaryTreeNode<Integer> root = obj.constructTree(preOrder);
		BinaryTreeNode<Integer> root1 = obj.constructTree(preOrder2);
		diameter(root);

	}

}
