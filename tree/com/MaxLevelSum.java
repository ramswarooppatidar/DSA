package tree.com;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxLevelSum {
	public static int LargestLevelSum(BinaryTreeNode<Integer> root, int k) {
		if(root == null) {
			return 0;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		Queue<Integer> sum = new PriorityQueue<Integer>();
		queue.add(root);
		int maxLevelSum =root.data;
		int kthLargest = root.data;
		while(!queue.isEmpty()) {
			int size = queue.size();
			int levelSum = 0;
			for(int i =0; i<size; i++) {
				
				BinaryTreeNode<Integer> front = queue.poll();
				levelSum += front.data;
				if(front.left != null) {
					queue.add(front.left);
				}
				if(front.right != null) {
					queue.add(front.right);
				}
				
			}
			sum.add(levelSum);
			maxLevelSum = Math.max(maxLevelSum, levelSum);
		}
		int size = sum.size();
		int i =0;
		while(!sum.isEmpty()) {
			kthLargest = sum.poll();
			if(size - i == k) {
			  break;
			}
			i++;
		}
		System.out.println("kth largest is :"+kthLargest);
		return maxLevelSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
