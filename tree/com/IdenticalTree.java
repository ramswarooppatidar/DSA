package tree.com;

public class IdenticalTree {
	public static boolean isIdentical(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if(root1 == null || root2 == null) {
			return root1 == root2;
		}
		boolean isLeftIdentical = isIdentical(root1.left, root2.left);
		boolean isRightIdentical = isIdentical(root1.right, root2.right);
		
		return isLeftIdentical && isRightIdentical && root1.data == root2.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = {1, 2, 4, 8, -1, -1, 9, -1, -1, 5, 10, -1, -1, 11,
				-1, -1, 3, 6, -1, 12, 13, 17, 19, -1, -1, -1, 18, -1, -1, -1, 7, 14, -1, -1, 15, -1, 16, -1, -1};
		int preOrder2[] = {13,17,19,-1,-1,-1,18,-1,-1};
		TreeUse_5 obj = new TreeUse_5();
		
		BinaryTreeNode<Integer> root = obj.constructTree(preOrder);
		BinaryTreeNode<Integer> root1 = obj.constructTree(preOrder2);
		isIdentical(root, root1);
		
		
		

	}

}
