package tree.com;

public class TransformToSumTree {

	public static int totalSum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftCount = totalSum(root.left);
		int rightCount = totalSum(root.right);
		return leftCount + rightCount + root.data;
	}
	public static void TransformToSumTree(BinaryTreeNode<Integer> root){
		if(root == null) {
			return ;
		}
		 int leftSum = totalSum(root.left);
		 int rightSum = totalSum(root.right);
		 
		 root.data = leftSum + rightSum;
		 
		 TransformToSumTree(root.left);
		 TransformToSumTree(root.right);
		 
	}
	public static void TransformToSumTree_Smart(BinaryTreeNode<Integer> root) {
		transformHelper(root);
	}
	
	public static int transformHelper(BinaryTreeNode<Integer> root){
		if(root == null) {
			return 0;
		}
		 int leftSum = transformHelper(root.left);
		 int rightSum = transformHelper(root.right);
		 
		 int oldValue = root.data;
		 root.data = leftSum + rightSum;  //this( root.data += leftSum + rightSum) not replace it is add left and right 
		 
		return root.data + oldValue;
		 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
