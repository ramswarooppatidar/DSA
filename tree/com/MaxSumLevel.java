package tree.com;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumLevel {
	public static int MaxSumLevel(BinaryTreeNode<Integer> root) {
		if(root ==  null) {
			return 0;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		int maxLevel = 0;
		int maxLevelSum = Integer.MIN_VALUE;
		queue.add(root);
		int level =0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			int levelSum = 0;
			level++;
			for(int i=0;i<size; i++) {
				BinaryTreeNode<Integer> front = queue.poll();
				levelSum += front.data;
				
				//add next level
				if(front.left != null) {
					queue.add(front.left);
				}
				if(front.right != null) {
					queue.add(front.right);
				}
			}
			if(levelSum > maxLevelSum) {
				maxLevelSum = levelSum;
				maxLevel = level;	
			}
		}
		return maxLevel;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
