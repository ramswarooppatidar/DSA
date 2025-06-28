package tree.com;

public class MaxPathSum {

	static int maxValue;
	static int maxSum = Integer.MIN_VALUE;
	 public static int maxPathSum(BinaryTreeNode<Integer> root) {
		 maxValue = Integer.MIN_VALUE;
		 helperPathSum(root);
		 return maxSum;
	       
	    }
	 public static int helperPathSum(BinaryTreeNode<Integer> root) {
		 if(root == null) {
			 return 0;
		 }
		 
		 int left = helperPathSum(root.left);
		 int right = helperPathSum(root.right);
		 
		 int niche_hi_mil_gaya = left+right + root.data;
		 
		 int koi_ek_achha = root.data + Math.max(left, right);
		 int only_root_achha = root.data;
		 
		 maxSum = Math.max(Math.max(niche_hi_mil_gaya, maxSum), Math.max(koi_ek_achha, only_root_achha));
		 return Math.max(koi_ek_achha, only_root_achha);
		 	 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
