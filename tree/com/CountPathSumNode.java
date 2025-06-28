package tree.com;

public class CountPathSumNode {

	public static int pathSumLeetCodeMedium(BinaryTreeNode<Integer> root, int target) {
		 if(root == null) {
			 return 0;
		 }
		 int fromRoot = countPathFormNode(root, target);
		 int left = pathSumLeetCodeMedium(root.left, target);
		 int right = pathSumLeetCodeMedium(root.right, target);
		 return fromRoot + left + right;
	 }
	 
	 public static int countPathFormNode(BinaryTreeNode<Integer> root,long target) {
		 if(root ==null) {
			 return 0;
		 }
		 int count = 0;
		 if(target - root.data == 0) {
			 count++;
		 }
		 count += countPathFormNode(root.left, target  - root.data);
		 count += countPathFormNode(root.right, target - root.data);
		 return count;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
