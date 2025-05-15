package tree.com;

import java.lang.module.ResolvedModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;
import javax.xml.crypto.Data;

class Pairs<T, U>{
	T first;
	U second;
	public Pairs(T first, U second) {
		this.first = first;
		this.second = second;
	}
}
class Triplate<T, U, V>{
	T first;
	U second;
	V third;
	public Triplate(T first, U second, V third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
}
public class TreeUse_5 {
	static int index = -1;
	public static BinaryTreeNode<Integer> constructTree( int preOrder[]){
		index++;
		if(index > preOrder.length || preOrder[index] == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[index]);
		root.left = constructTree(preOrder);
		root.right = constructTree(preOrder);
		return root;
	}
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
	public static void printPreOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		printPreOrder(root.left);
		printPreOrder(root.right);
				
	}
	static int ans=0;
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		ans = Math.max(leftHeight+rightHeight, ans);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	public static int totalNode(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftCount = totalNode(root.left);
		int rightCount = totalNode(root.right);
		return leftCount + rightCount + 1;
	}
	public static int totalSum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftCount = totalSum(root.left);
		int rightCount = totalSum(root.right);
		return leftCount + rightCount + root.data;
	}
	
	//part-2
	public static boolean isIdentical(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if(root1 == null || root2 == null) {
			return root1 == root2;
		}
		boolean isLeftIdentical = isIdentical(root1.left, root2.left);
		boolean isRightIdentical = isIdentical(root1.right, root2.right);
		
		return isLeftIdentical && isRightIdentical && root1.data == root2.data;
	}
	
	public static boolean subTree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> subRoot) {
		//when initial root is null or not null
		if(root == null || subRoot == null) {
			return false;
		}
		
		if(root.data == subRoot.data && isIdentical(root, subRoot)) {
			return true;
		}
		
		return subTree(root.left, subRoot) || subTree(root.right, subRoot);
	}
	


	
	//part-3
	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		// 1) ya to diamter root se hote hue jaye, tab leftHight + right height
		// 2)  ya diameter of leftTreee 
		// 3) ya diamter of right tree
		// condition en teeno meso jo maximum hai vah root ki diameter hai
		// time complexity (n*n)
		int leftDia = diameter(root.left);
		int rightDia = diameter(root.right);
		int currentDia = height(root.left) + height(root.right);
		
		return Math.max(Math.max(rightDia, leftDia),currentDia);
	}
	public static int diameter2(BinaryTreeNode<Integer> root) {
		height(root);
		return ans;
	}
	
	//part-4
	public static List<Integer> topView(BinaryTreeNode<Integer> root) {
		Queue<Pairs<BinaryTreeNode<Integer>, Integer>> queue = new LinkedList<>();
		queue.add(new Pairs<BinaryTreeNode<Integer>, Integer>(root, 0));
		SortedMap<Integer, Integer> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			Pairs<BinaryTreeNode<Integer>, Integer> pair = queue.poll();
			BinaryTreeNode<Integer> current = pair.first;
			int horDis = pair.second;
			
			if(!map.containsKey(horDis)) {
				map.put(horDis, current.data);
			}
			
			if(current.left != null) {
				queue.add(new Pairs<BinaryTreeNode<Integer>, Integer>(current.left, horDis - 1));
			}
			if(current.right != null) {
				queue.add(new Pairs<BinaryTreeNode<Integer>, Integer>(current.right, horDis + 1));
			}
		}
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
	      
		return list;
	}
	public static List<List<Integer>> verticalOrderTraversal(BinaryTreeNode<Integer> root){
		
		List<List<Integer>> ans = new ArrayList<>();
		Queue<Pairs<BinaryTreeNode<Integer>, Integer>> queue = new LinkedList<>();
		queue.add(new Pairs(root, 0));
		Map<Integer, List<Integer>> map = new TreeMap<>();
		
		while(!queue.isEmpty()) {
			Pairs<BinaryTreeNode<Integer>, Integer> front = queue.poll();
			BinaryTreeNode<Integer> current = front.first;
			Integer horizonatDistance = front.second;
			
			if(!map.containsKey(horizonatDistance)) {
				map.put(horizonatDistance, new ArrayList<Integer>());
				map.get(horizonatDistance).add(current.data);	
			}else {
				map.get(horizonatDistance).add(current.data);
			}
//			map.put(horizonatDistance, map.getOrDefault(horizonatDistance, new ArrayList<Integer>()) , current.data);
			if(current.left != null) {
				queue.add(new Pairs(current.left, horizonatDistance - 1));
			}
			if(current.right != null) {
				queue.add(new Pairs(current.right, horizonatDistance + 1));
			}
		}
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> sortLi = entry.getValue();
			Collections.sort(sortLi);
			ans.add(sortLi);
		}
		return ans;
	}
	
	public static List<List<Integer>> verticalOrderTraversalLeet(BinaryTreeNode<Integer> root){
		Queue<Triplate<BinaryTreeNode<Integer>, Integer, Integer>> queue = new LinkedList<>();
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		List<List<Integer>> ansList = new ArrayList<>();
		queue.add(new Triplate(root, 0, 0));
		while(!queue.isEmpty()) {
			Triplate<BinaryTreeNode<Integer>, Integer, Integer> front = queue.poll();
			BinaryTreeNode<Integer> current = front.first;
			int x = front.second;
			int y = front.third;
			
			if(!map.containsKey(x)) {
				map.put(x, new TreeMap<>());
			}
			if(!map.get(x).containsKey(y)) {
//				map.put(y, new TreeMap<>());
				map.get(x).put(y, new PriorityQueue<>());
			}
			map.get(x).get(y).add(current.data);
			
			if(current.left != null) {
				queue.add(new Triplate(current.left, x - 1, y + 1));
			}
			if(current.right != null) {
				queue.add(new Triplate(current.right, x + 1, y + 1));
			}
		}
		for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
			TreeMap<Integer, PriorityQueue<Integer>> treeMap = entry.getValue();
			List<Integer> list = new ArrayList<>();
			for(Map.Entry<Integer, PriorityQueue<Integer>> entry2 : treeMap.entrySet()) {
				PriorityQueue<Integer> pq = entry2.getValue();
				while(!pq.isEmpty()) {
					list.add(pq.poll());
				}
			}
			ansList.add(list);
		}
		return ansList;
	}
	
	//part-5 kth level
	public static List<Integer> kthLevelNodes(BinaryTreeNode<Integer> root,int k){
		List<Integer> ansIntegers = new ArrayList<Integer>();
		helper(root, k, ansIntegers);
		return ansIntegers;
	}
	private static void helper(BinaryTreeNode<Integer> root, int k, List<Integer> list) {
		if(root == null) {
			return;
		}
		if(k == 1) {
			list.add(root.data);
		}
		helper(root.left, k-1, list);
		helper(root.right, k-1, list);
	}
	
	public static int kthLargestLevelSum(BinaryTreeNode<Integer> root, int k) {
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

	public static List<List<Integer>> levelOrderList(BinaryTreeNode<Integer> root){
		List<List<Integer>> ansList = new ArrayList<>();
		if(root == null) {
			return ansList;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<>();
			for(int i =0; i<size; i++) {
				BinaryTreeNode<Integer> front = queue.poll();
				levelList.add(front.data);
				if(front.left != null) {
					queue.add(front.left);
				}
				if(front.right != null) {
					queue.add(front.right);
				}
			}
			ansList.add(levelList);
		}
		return ansList;
	}
	
//	?part -6 lowestcommon anchestors
	public static BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q){
		if(root == null) {
			return null;
		}
		
		if(root.data == p.data || root.data == q.data) {
			return root;
		}
		BinaryTreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
		BinaryTreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);
		
		if(left != null && right != null) {
			return root;
		}else if(left != null) {
			return left;
		}else if(right != null) {
			return right;
		}else {
			return null;
		}
	}
	
	//part -7
	public static void TransformToSumTree(BinaryTreeNode<Integer> root){
		if(root == null) {
			return ;
		}
		 int leftSum = totalSum(root.left);
		 int rightSum = totalSum(root.right);
		 
		 root.data = leftSum + rightSum;
		 
		 TransformToSumTree(root.left);
		 TransformToSumTree(root.right);
		 
	}
	public static void TransformToSumTree_Smart(BinaryTreeNode<Integer> root) {
		transformHelper(root);
	}
	
	public static int transformHelper(BinaryTreeNode<Integer> root){
		if(root == null) {
			return 0;
		}
		 int leftSum = transformHelper(root.left);
		 int rightSum = transformHelper(root.right);
		 
		 int oldValue = root.data;
		 root.data = leftSum + rightSum;  //this( root.data += leftSum + rightSum) not replace it is add left and right 
		 
		return root.data + oldValue;
		 
	}
	
	//part -8 path sum
	public static List<List<Integer>> pathSumRootLeaf(BinaryTreeNode<Integer> root){
		if(root == null) {
			return null;
		}
		List<List<Integer>> ansList = new ArrayList<>();
		List<Integer> progress = new ArrayList<>();
		pathSumHelper(root, progress, ansList);
		return ansList;
	}
	
	public static void pathSumHelper(BinaryTreeNode<Integer> root, List<Integer> progress, List<List<Integer>> ansList) {
		if(root == null) {
			return;
		}
		 progress.add(root.data);
		if(root.left == null && root.right == null) {
			ansList.add(new ArrayList<Integer>(progress));
			int sum = progress.stream().reduce(0,(a,b)->a+b);
			System.out.println("sum is :"+ sum);
//			progress = new ArrayList<Integer>();
//			return;
		}
		
		 pathSumHelper(root.left, progress, ansList);
		 pathSumHelper(root.right, progress, ansList);
		 progress.remove(progress.size() - 1);
	}
	/*
	    Input: root = [1,2,3,null,5]
         Output: ["1->2->5","1->3"]
	 */
	public static List<String> binaryTreePath(BinaryTreeNode<Integer> root) {
		List<String> ans = new ArrayList<>();
		treePathHelper(root, ans, "");
		return ans;
	}
	public static void treePathHelper(BinaryTreeNode<Integer> root, List<String> ans,String progress) {
		if(root == null) {
			return;
		}
		progress += root.data + "->";
		if(root.left == null && root.right == null) {
			ans.add(new String(progress.substring(0, progress.length() - 2)));
			progress="";
		}
		treePathHelper(root.left, ans, progress);
		treePathHelper(root.right, ans, progress);
	}
	static int maxSum = Integer.MIN_VALUE;
	public static int maxPathSum2(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int left = Math.max(maxPathSum(root.left), 0);
		int right = Math.max(maxPathSum(root.right), 0);
		int currentSum = left + right + root.data;
		maxSum = Math.max(maxSum, currentSum);
		return root.data + left + right;
	}
	
	static int maxValue;
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
	 
	 //part -9 one side traversal
	 static int leftLeaveSum = 0;
	 public static int sumOfLeftLeaves(BinaryTreeNode<Integer> root) {
		 leftLeaveSumHelper(root, false);
		 return leftLeaveSum;
	 }
	 public static void leftLeaveSumHelper(BinaryTreeNode<Integer> root, boolean isLeft) {
		 if(root == null) {
			 return;
		 }
		 if(root.left == null && root.right == null && isLeft) {
			 leftLeaveSum += root.data;
		 }
		 leftLeaveSumHelper(root.left, true);
		 leftLeaveSumHelper(root.right, false);
	 }
	 
	 

	   
	
	public static void main(String[] args) {
		int[] preOrder = {1, 2, 4, 8, -1, -1, 9, -1, -1, 5, 10, -1, -1, 11,
				-1, -1, 3, 6, -1, 12, 13, 17, 19, -1, -1, -1, 18, -1, -1, -1, 7, 14, -1, -1, 15, -1, 16, -1, -1};
		int preOrder2[] = {13,17,19,-1,-1,-1,18,-1,-1};
		BinaryTreeNode<Integer> root1 =	constructTree(preOrder);
		printPreOrder(root1);
    	index = -1;
		System.out.println();
		BinaryTreeNode<Integer> root2 =	constructTree(preOrder2);
	  
		printPreOrder(root2);
		
		System.err.println();
		levelWiseTraversal(root1);
		
		System.out.println();
		System.out.println("hight is : "+height(root1));
		
		System.out.println();
		System.out.println("total node is : "+ totalNode(root1));
		
		System.out.println();
		System.out.println("total sum is : "+ totalSum(root1));
		
		
		System.out.println();
		System.out.println("is Identical : "+ isIdentical(root1, root2));
		
		System.out.println();
		System.out.println("has subTree : "+ subTree(root1, root2));
		
		System.out.println();
		System.out.println("Diameter is  : "+ diameter(root1));
		
		System.out.println();
		System.out.println("Diameter is  : "+ diameter2(root1));
		
		System.out.println();
		System.out.println("top view :"+topView(root1));
		
		System.out.println();
		System.out.println("vertical order traversal :"+ verticalOrderTraversal(root1));
		
		System.out.println();
		index = -1;
		int preOrderV[]= {1,2,4,-1,-1,6,-1,-1,3,5,-1,-1,7,-1,-1};
		BinaryTreeNode<Integer> rootV =	constructTree(preOrderV);
		System.out.println("vertical order traversal :"+ verticalOrderTraversalLeet(rootV));
		
		System.out.println();
		List<Integer> ansIntegers = kthLevelNodes(root1,7);
		System.out.println("kTH Level nodes : "+ansIntegers);
		
		System.out.println();
		int ans = kthLargestLevelSum(root1, 3);
		System.out.println("max level sum : "+ans);
		
		System.out.println();
		int Level = MaxSumLevel(root1);
		System.out.println("maximum sum level is :"+Level);
		
		System.out.println();
		System.out.println("level wise list : "+levelOrderList(root1));
		
		System.out.println();
		lowestCommonAncestor(root1, root2, root2);
		
		System.out.println();
//		TransformToSumTree(root1);
//		System.out.println("level wise list after transform : "+levelOrderList(root1));
		
		
		System.out.println();
		System.out.println("root to leaf sum : "+pathSumRootLeaf(root1));
		
		
		System.out.println();
		System.out.println("maximum sum path is :"+maxPathSum(root1));
		
		System.out.println();
		System.out.println("tree path sum :"+binaryTreePath(root1));
		
		System.out.println(); //****** imp
		System.out.println("left leave sum :"+sumOfLeftLeaves(root1));
		
//		****** imp
		System.out.println();
		System.out.println("total path sum count :"+ pathSumLeetCodeMedium(root1, 15));
		


		
		
		


	}

}
