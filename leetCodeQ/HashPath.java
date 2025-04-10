package leetCodeQ;
import java.util.*;
public class HashPath {
	public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        Stack<Integer> pathSum = new Stack();
        Stack<TreeNode> path = new Stack<>();
        pathSum.push(root.data);
        path.push(root);

        while(!path.isEmpty()){
            TreeNode temp = path.pop();
            int tempVal = pathSum.pop();

            if(temp.left == null && temp.right == null && tempVal == targetSum){
                return true;
            }
            if(temp.left != null){
                path.push(temp.left);
                pathSum.push(temp.left.data + tempVal);
            }
            if(temp.right != null){
                path.push(temp.right);
                pathSum.push(temp.right.data + tempVal);
            }
        }
        return false;
    }
}
