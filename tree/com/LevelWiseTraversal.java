package tree.com;

import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseTraversal {
	public static void levelWiseTraversal(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
		 BinaryTreeNode<Integer> current = queue.poll();
		 System.out.print(current.data);
		 if(current.left != null) {
			 System.out.print(" L "+current.left.data);
			 queue.add(current.left);
		 }else {
			 System.out.print(" L "+ -1); 
		 }
		 
		 if(current.right != null) {
			 System.out.print(" L "+current.right.data);
			 queue.add(current.right);
		 }else {
			 System.out.print(" R "+ -1); 
		 }
		 System.out.println("");
		
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = {1, 2, 4, 8, -1, -1, 9, -1, -1, 5, 10, -1, -1, 11,
				-1, -1, 3, 6, -1, 12, 13, 17, 19, -1, -1, -1, 18, -1, -1, -1, 7, 14, -1, -1, 15, -1, 16, -1, -1};
		int preOrder2[] = {13,17,19,-1,-1,-1,18,-1,-1};
		TreeUse_5 obj = new TreeUse_5();
		BinaryTreeNode<Integer> root = obj.constructTree(preOrder);
		levelWiseTraversal(root);
		

	}

}
