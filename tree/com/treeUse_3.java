
package tree.com;
import java.util.*;
public class treeUse_3{
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
	    public static void printLevelWise(BinaryTreeNode<Integer> root){
	        if(root == null){
	            return;
	        }
	        Queue<BinaryTreeNode<Integer>> pending = new LinkedList<>();
	        pending.add(root);
	        while(!pending.isEmpty()){
	            BinaryTreeNode<Integer> front = pending.poll();
	            System.out.print(front.data+" :");
	            if(front.left != null){
	                System.out.print(" L"+front.left.data);
	                pending.add(front.left);
	            }else {
	                System.out.print(" L" + (-1));
	            }
	            if(front.right != null){
	                System.out.print(" R"+front.right.data);
	                pending.add(front.right);
	            }else {
	                System.out.print(" R" + (-1));
	            }
	            System.out.println("");
	        }
	    }
	     public static List<List<Integer>> pathSumRootToLeaf(BinaryTreeNode<Integer> root, int sum){
	         List<Integer> list = new ArrayList<>();
	         List<List<Integer>> result = new ArrayList<>();
	          pathSumRootToLeafHelper(root, result , list, sum);
	          return result;

	     }
	    
	     public static void pathSumRootToLeafHelper(BinaryTreeNode<Integer> root,List<List<Integer>> result,List<Integer> currentPath, int sum) {
	         if (root == null) {
	             return;
	         }
	     
	         currentPath.add(root.data);
	     
	         // Check if it's a leaf node and the path sum equals the given sum
	         if (root.left == null && root.right == null && sum == root.data) {
	             result.add(new ArrayList<>(currentPath)); 
	             // Add a copy of the current path to the result
	         } else {
	             // Continue to traverse the left and right subtrees
	             pathSumRootToLeafHelper(root.left, result, currentPath, sum - root.data);
	             pathSumRootToLeafHelper(root.right, result, currentPath, sum - root.data);
	         }
	     
	         // Remove the current node from the path to backtrack
	         currentPath.remove(currentPath.size() - 1);
	     }
	     public static List<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int x) {
	     	List<Integer> list = new ArrayList<>();
	     	getRootToNodePathHelper(root, list, x);
	     	return list;
	     }
	     public static boolean getRootToNodePathHelper(BinaryTreeNode<Integer> root,List<Integer> list, int x) {
	     	if(root == null) {
	     		return false;
	     	}
	     	list.add(root.data);
	     	if(root.data == x) {
	     		return true;
	     	}
	     	if(getRootToNodePathHelper(root.left, list, x) || 
	     			getRootToNodePathHelper(root.right, list, x)) {
	     		return true;
	     	}
	     	list.remove(list.size() - 1);
	     	return false;
	     	
	     }
	     public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
	    	 if(root == null) {
	    		 return true;
	    	 }
	    	 Queue<BinaryTreeNode<Integer>> leftQueue = new LinkedList<>();
	    	 Queue<BinaryTreeNode<Integer>> rightQueue = new LinkedList<>();
	    	 
	    	 leftQueue.add(root.left);
	    	 rightQueue.add(root.right);
	    	 while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
	    		 BinaryTreeNode<Integer> leftTreeNode = leftQueue.poll();
	    		 BinaryTreeNode<Integer> rightTreeNode = rightQueue.poll();
//	    		 if(!left.equals(right)) {
//	    			 return false;
//	    		 }
	    		 if(leftTreeNode == null && rightTreeNode == null) {
	    			 continue;
	    		 }
	    		 if(leftTreeNode == null || rightTreeNode == null) {
	    			 return false;
	    		 }
	    		 if(leftTreeNode.data != rightTreeNode.data) {
	    			 return false;
	    		 }
	    		 
	    		 leftQueue.add(leftTreeNode.left);
	    		 leftQueue.add(leftTreeNode.right);
	    		 rightQueue.add(rightTreeNode.right);
	    		 rightQueue.add(rightTreeNode.left);	    		 
	    	 }
	    	 return true;
	    	 
	     }
	     
	     public List<Double> averageOfLevels(BinaryTreeNode root) {
	         Queue<BinaryTreeNode> level = new LinkedList();
	         List<Double> avgList = new ArrayList();
	         level.add(root);
	         level.add(null);
	         while(level.peek() != null){
	             double sum =0;
	             int count =0;
	             while(level.peek() != null){
	            	 BinaryTreeNode node =  level.poll();
	                 sum += (double)node.data;
	                 count++;

	                 if(node.left != null){
	                     level.add(node.left);
	                 }
	                 if(node.right != null){
	                     level.add(node.right);
	                 }
	             }
	             level.add(level.poll());
	             avgList.add(sum/count);
	         }
	         return avgList;
	     }
	     
	public static void main(String str[]) {
		BinaryTreeNode<Integer> root =	takeInputLevelWise();
		System.out.println(isSymmetric(root));
	}
}