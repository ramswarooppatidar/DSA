package leetCode;

import java.util.Stack;


 class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        Stack<Integer> pathSum = new Stack();
        Stack<TreeNode> path = new Stack<>();
        pathSum.push(root.val);
        path.push(root);

        while(!path.isEmpty()){
            TreeNode temp = path.pop();
            int tempVal = pathSum.pop();

            if(temp.left == null && temp.right == null && tempVal == targetSum){
                return true;
            }
            if(temp.left != null){
                path.push(temp.left);
                pathSum.push(temp.left.val + tempVal);
            }
            if(temp.right != null){
                path.push(temp.right);
                pathSum.push(temp.right.val + tempVal);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
