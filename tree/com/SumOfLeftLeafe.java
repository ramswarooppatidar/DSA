package tree.com;

public class SumOfLeftLeafe {

	 static int leftLeaveSum = 0;
	 public static int sumOfLeftLeaves(BinaryTreeNode<Integer> root) {
		 leftLeaveSumHelper(root, false);
		 return leftLeaveSum;
	 }
	 public static void leftLeaveSumHelper(BinaryTreeNode<Integer> root, boolean isLeft) {
		 if(root == null) {
			 return;
		 }
		 if(root.left == null && root.right == null && isLeft) {
			 leftLeaveSum += root.data;
		 }
		 leftLeaveSumHelper(root.left, true);
		 leftLeaveSumHelper(root.right, false);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
