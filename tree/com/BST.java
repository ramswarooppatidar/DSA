package tree.com;

import java.lang.classfile.instruction.ReturnInstruction;
import java.security.PublicKey;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;import javax.swing.RootPaneContainer;
class IsBSTReturn{
	int max;
	int min;
	boolean isBST;
	public IsBSTReturn(int max, int min, boolean isBST){
		this.max = max;
		this.min = min;
		this.isBST = isBST;
	}
	
}
class maxSumBSTReturn{
	int maxSum;
	int max;
	int min;
	boolean isBST;
	public maxSumBSTReturn(int maxSum,int max, int min, boolean isBst) {
		this.maxSum = maxSum;
		this.max = max;
		this.min = min;
		this.isBST = true;
	}
}
class LinkedListNode<T> { 
	T data;
	LinkedListNode<T> next;
	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class BST {
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
	 public static BinaryTreeNode<Integer> takeUserInputBatter(boolean isRoot,int  parent, boolean isLeft ){
	        Scanner sc = new Scanner(System.in);
	        if(isRoot){
	            System.out.println("enter root data");
	        }else{
	            if(isLeft){
	                System.out.println("enter the left child data of : "+parent);
	            }else{
	                System.out.println("enter the right child data of : "+parent);
	            }
	        }
	        int rootData = sc.nextInt();
	        if(rootData == -1){
	            return null;
	        }
	        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
	        BinaryTreeNode<Integer> leftChild = takeUserInputBatter(false, rootData, true);
	        BinaryTreeNode<Integer> rightChild = takeUserInputBatter(false, rootData, false);
	        root.left = leftChild;
	        root.right = rightChild;
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
	public static boolean searchDataIn_BST(BinaryTreeNode<Integer> root, int data) {
		if(root == null) {
			return false;
		}
		if(root.data == data) {
			return true;
		}
		if(data > root.data) {
			return searchDataIn_BST(root.right, data);
		}
		return searchDataIn_BST(root.left, data);
	}
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		if(root == null){
			return ;
		}
		 if (k1 < root.data) {
		        elementsInRangeK1K2(root.left, k1, k2);
		    }

		    if (k1 <= root.data && k2 >= root.data) {
		        System.out.print(root.data + " ");
		    }

		    if (k2 > root.data) {
		        elementsInRangeK1K2(root.right, k1, k2);
		    }
	}
	public static BinaryTreeNode<Integer> convertSortArrayToBST(int arr []){
		
		return convertSortArrayToBSTHelper(arr, 0, arr.length - 1);
	}
	private static BinaryTreeNode<Integer> convertSortArrayToBSTHelper(int arr [], int startIndex, int endIndex){
		if(startIndex > endIndex) {
			return null;
		}
		int midIndex = (startIndex + endIndex) / 2;
		int rootData = arr[midIndex];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		
		int siLeft = startIndex;
		int eiLeft = midIndex - 1;
		int siRight = midIndex + 1;
		int eiRight = endIndex;
		
		BinaryTreeNode<Integer> left = convertSortArrayToBSTHelper(arr, siLeft, eiLeft);
		BinaryTreeNode<Integer> right = convertSortArrayToBSTHelper(arr, siRight, eiRight);
		root.left = left;
		root.right = right;
		return root;
		
	}
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int maxLeft = maximum(root.left);
		if(maxLeft >= root.data) {
			return false;
		}
		int minRight = minimum(root.right);
		
		if(minRight < root.data) {
			return false;
		}
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		return isLeftBST && isRightBST;
	}
	private static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		
		int minLeft = minimum(root.left);
		int minRight = minimum(root.right);
		return Math.min(root.data, Math.min(minLeft, minRight));
		
	}
	private static int maximum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		int maxLeft = maximum(root.left);
		int maxRight = maximum(root.right);
		return Math.max(root.data, Math.max(maxLeft, maxRight));
		
	}
	public static IsBSTReturn isBSTbATTER(BinaryTreeNode<Integer> root) {
		if(root == null) {
		IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		return ans;
		}
		IsBSTReturn leftAns = isBSTbATTER(root.left);
		IsBSTReturn rightAns = isBSTbATTER(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		
		if(leftAns.max >= root.data) {
			isBST = false;
		}
		if(rightAns.min < root.data) {
			isBST = false;
		}
		if(!leftAns.isBST) {
			isBST = false;
		}
		if(!rightAns.isBST) {
			isBST = false;
		}
	  IsBSTReturn res = new IsBSTReturn(max, min, isBST);
	  return res;
		 
	}
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return null;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		inOrderTraversal(root, queue);
		LinkedListNode<Integer> head = new LinkedListNode<>(queue.poll());
		LinkedListNode<Integer> current = head;
		while(!queue.isEmpty()) {
			LinkedListNode<Integer> newNode = new LinkedListNode<>(queue.poll());
			current.next = newNode;
			current = current.next;
		}
		return head;
		
	}
	private static void inOrderTraversal(BinaryTreeNode<Integer> root, Queue<Integer> queue) {
		if(root == null) {
			return ;
		}
		inOrderTraversal(root.left, queue);
		queue.add(root.data);
		inOrderTraversal(root.right, queue);
	}
	public static BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p,
			BinaryTreeNode<Integer> q){
		if(root == null || root == p || root == q) {
			return root;
		}
		 BinaryTreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
		 BinaryTreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);
		 if(left == null) {
			 return right;
		 }else if(right == null) {
			 return left;
		 }else {
			 return root;
		 }	
		
	}
	public static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int x){
		if(root == null || root.data == x) {
			return root;
		}
		if(root.data > x) {
			return findNode(root.left, x);
		}else {
			return findNode(root.right, x);
		}
	}
	public static maxSumBSTReturn maxSumBST(BinaryTreeNode<Integer> root ) {
		if(root == null) {
			maxSumBSTReturn ans = new maxSumBSTReturn(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
			return ans;
		}
		maxSumBSTReturn leftAns = maxSumBST(root.left);
		maxSumBSTReturn rightAns = maxSumBST(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));
 
		boolean isBST = true;
		if(leftAns.max >= root.data) {
			isBST = false;
		}
		if(rightAns.min <= root.data) {
			isBST = false;
		}
		if(!leftAns.isBST) {
			isBST = false;
		}
		if(!rightAns.isBST) {
			isBST = false;
		}
//		int maxS = Integer.MIN_VALUE;
//		if(leftAns.isBST  && rightAns.isBST) {
//			int maxCal = calculateSum(root, 0);
//			if(leftAns.maxSum < maxCal) {
//				maxS = maxCal;
//			}
//			if(rightAns.maxSum < maxCal) {
//				maxS = maxCal;
//			}		
//		}
		int maxS = root.data; // Initialize with current node's data (potential BST)
		if (leftAns.isBST && leftAns.max <= root.data) {
		  maxS += leftAns.maxSum;
		}
		if (rightAns.isBST && rightAns.min >= root.data) {
		  maxS += rightAns.maxSum;
		}
		maxSumBSTReturn ans = new maxSumBSTReturn(maxS, max, min, true);
		return ans;
		
	}
	public static int maxSumBST_(BinaryTreeNode<Integer> root) {
		  if (root == null) {
		    return 0;
		  }

		  maxSumBSTReturn leftAns = maxSumBST(root.left);
		  maxSumBSTReturn rightAns = maxSumBST(root.right);

		  int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		  int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));

		  boolean isBST = true;
		  if (leftAns.max >= root.data) {
		    isBST = false;
		  }
		  if (rightAns.min <= root.data) {
		    isBST = false;
		  }
		  if (!leftAns.isBST) {
		    isBST = false;
		  }
		  if (!rightAns.isBST) {
		    isBST = false;
		  }

		  int maxS = root.data; // Initialize with current node's data
		  if (leftAns.isBST && leftAns.max <= root.data) {
		    maxS += leftAns.maxSum;
		  }
		  if (rightAns.isBST && rightAns.min >= root.data) {
		    maxS += rightAns.maxSum;
		  }

		  return Math.max(maxS, Math.max(leftAns.maxSum, rightAns.maxSum));
		}

		private static int calculateSum(BinaryTreeNode<Integer> node) {
		  if (node == null) {
		    return 0;
		  }
		  return node.data + calculateSum(node.left) + calculateSum(node.right);
		}
		
	public static int calculateSum(BinaryTreeNode<Integer> root,int max) {
		if(root == null) {
			return max;
		}
		max = max + root.data;
		calculateSum(root.left, max);
		calculateSum(root.right, max);
		
		return max;
		
	}
	public static void main(String srg[]) {
//		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		boolean flag = searchDataIn_BST(root, 7);
//		System.out.println("isValue is present: "+ flag);
		
//		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		elementsInRangeK1K2(root,3, 20);
		
//		int arr [] = {1,2,3,4,5,6,7,8};
//		BinaryTreeNode<Integer> root =  convertSortArrayToBST(arr);
		
//		printLevelWise(root);
		
//		boolean flag = isBST(root);
//		System.out.println("isBST :"+flag);
		
//		LinkedListNode<Integer> head = constructLinkedList(root);
//		while(head != null) {
//			System.out.print(head.data+" ");
//			head = head.next;
//			
//		}
		
//		LCA
//		int arr [] = {1,2,3,4,5,6,7,8};
//		BinaryTreeNode<Integer> root =  convertSortArrayToBST(arr);
//		
//		BinaryTreeNode<Integer> p = findNode(root, 6);
//		BinaryTreeNode<Integer> q = findNode(root, 8);
//		
//		BinaryTreeNode<Integer> lca = lowestCommonAncestor(root, p, q);
//		if(lca != null) {
//			System.out.println("lca is :"+lca.data);
//		}else {
//			System.out.println("lca is :"+lca);
//		}
		
		  BinaryTreeNode<Integer> rt = takeInputLevelWise();
		  maxSumBSTReturn ans = maxSumBST(rt);
		  
		  System.out.println("max sum bst is :"+ ans.maxSum);
		  System.out.print("ans is :"+maxSumBST_(rt));
	
		
		
		
		
	}
}
