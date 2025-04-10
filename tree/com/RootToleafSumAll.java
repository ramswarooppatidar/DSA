package tree.com;

import java.awt.geom.AffineTransform;
import java.lang.foreign.AddressLayout;
import java.util.LinkedList;
import java.util.*;
import java.util.Queue;
import java.util.Scanner;

public class RootToleafSumAll {
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter root data");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        Queue<BinaryTreeNode<Integer>> pendingRoot = new LinkedList<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode(rootData);
        pendingRoot.add(root);
        while(!pendingRoot.isEmpty()){
            BinaryTreeNode<Integer> front = pendingRoot.poll();
            System.out.println("please enter left node of "+front.data);
            int left = sc.nextInt();
            if(left != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode(left);
                front.left = leftChild;
                pendingRoot.add(leftChild);
            }
            System.out.println("please enter right node of "+front.data);
            int right = sc.nextInt();
            if(right != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode(right);
                front.right = rightChild;
                pendingRoot.add(rightChild);
            }
        }
        return root;
    }
	public static List<Integer> sumAllRootToLeaf(BinaryTreeNode<Integer> root, int sum, List<Integer> ans){
		
		if(root == null) {
//			ans.add(sum);
			return ans;
		}
		 sum += root.data;
		 
		if(root.left == null && root.right == null) {
			ans.add(sum);
		}
	  
	   sumAllRootToLeaf(root.left, sum, ans);
	   sumAllRootToLeaf(root.right, sum , ans);
	   
		
		return ans;
	}
	public static boolean hasPathSum(BinaryTreeNode<Integer> root, int target) {
		if(root == null) {
			return false;
		}
		Stack<BinaryTreeNode<Integer>> path = new Stack<BinaryTreeNode<Integer>>();
		Stack<Integer> pathSum = new Stack<Integer>();
		
		path.add(root);
		pathSum.add(root.data);
		while(!path.isEmpty()) {
			BinaryTreeNode<Integer> node = path.pop();
			int val = pathSum.pop();
			
			if(node.left == null && root.right == null && val == target) {
				return true;
			}
			
			if(node.right != null) {
				path.add(node.right);
				pathSum.add(val + root.right.data);
			}
			if(node.left != null) {
				path.add(node.left);
				pathSum.add(val + root.left.data);
			}
			
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root =	takeInputLevelWise();
		List<Integer> ansIntegers = new ArrayList<>();
		List<Integer> resIntegers =  sumAllRootToLeaf(root,0,  ansIntegers);
		for(Integer integer : resIntegers) {
			System.out.println(integer);
		}

	}

}
