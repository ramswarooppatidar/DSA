package tree.com;
import java.util.*;

import javax.swing.tree.TreeNode;


//class BinaryTreeNode<T>{
//    T data;
//    BinaryTreeNode<T> left;
//    BinaryTreeNode<T> right;
//    public BinaryTreeNode(T data){
//        this.data = data;
//    }
//}
class BlancedTreeReturn{
    int height;
    boolean isBalanced;
}

class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}
public class treeUse_2 {
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
    public static int numberOfNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }   
            int leftNode = numberOfNodes(root.left);
            int right = numberOfNodes(root.right);      
        return 1 + leftNode+right;
          
    }
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
    public static void printPreOrderTraversal(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
    }
    public static BinaryTreeNode<Integer> removeLeafNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            root.data = null;
            return null;
        }
        removeLeafNode(root.left);
        removeLeafNode(root.right);
        return root;
    }
    public static boolean isTreeBalance(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        boolean isLeftBalanced = isTreeBalance(root.left);
        boolean isRightBalanced = isTreeBalance(root.right);
        return isLeftBalanced && isRightBalanced;
    }
    public static int height(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static BlancedTreeReturn isTreeBalancedBatter(BinaryTreeNode<Integer> root){
        if(root == null){
            int height =0;
            boolean isBal = true;
            BlancedTreeReturn ans = new BlancedTreeReturn();
            ans.height = height;
            ans.isBalanced =isBal;
            return ans;
        }
        BlancedTreeReturn isLeftBalance = isTreeBalancedBatter(root.left);
        BlancedTreeReturn isRightBalance =  isTreeBalancedBatter(root.right);

        boolean isBal = true;
        int height = 1 + Math.max(isLeftBalance.height, isRightBalance.height);

        if(Math.abs(isLeftBalance.height - isRightBalance.height)>1){
            isBal = false;
        }
        if(!isLeftBalance.isBalanced || !isRightBalance.isBalanced){
            isBal = false;
        }
        BlancedTreeReturn ans = new BlancedTreeReturn();
        ans.isBalanced = isBal;
        ans.height = height;
        return ans;
    }
    public static int diameterOfTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int dia = leftHeight + rightHeight;

        int left = diameterOfTree(root.left);
        int right = diameterOfTree(root.right);

        int height = Math.max(left, right);
        return 1 + Math.max(dia, height);
    }
    public static BinaryTreeNode<Integer> constructTreeFromPreInorder(int [] pre, int [] in){
        int preLength = pre.length;
        int InLength = in.length;
        return constructTreeFromPreInorderHelper(pre, in, 0,preLength-1, 0, InLength - 1);
    }
    public static BinaryTreeNode<Integer> constructTreeFromPreInorderHelper(int[] pre, int[] in, int siPre, int eiPre, int siIn, int eiIn) {
        if (siPre > eiPre || siIn > eiIn) {
            return null;
        }
        
        int rootData = pre[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        int rootIndex = -1;

        for (int i = siIn; i <= eiIn; i++) { // Fixing the loop to include eiIn
            if (in[i] == rootData) {
                rootIndex = i;
                break;
            }
        }
        
        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;
        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;
        
        int lengthOfLeft = eiInLeft - siInLeft + 1;
        
        int eiPreLeft = siPreLeft + lengthOfLeft - 1;
        int siPreRight = eiPreLeft + 1;
        int eiPreRight = eiPre; // Correct assignment of eiPreRight
        
        BinaryTreeNode<Integer> left = constructTreeFromPreInorderHelper(pre, in, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        BinaryTreeNode<Integer> right = constructTreeFromPreInorderHelper(pre, in, siPreRight, eiPreRight, siInRight, eiInRight);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    public static BinaryTreeNode<Integer> constrFromPostInorder(int [] inorder, int [] postorder){
        int inLength = inorder.length;
        int postLength = postorder.length;
        return constrFromPostInorder(inorder, postorder, 0,inLength-1, 0, postLength - 1);
    }
    private static  BinaryTreeNode<Integer> constrFromPostInorder(int [] in, int [] po, int siIn, int eiIn, int siPo, int eiPo){
        if(siIn>eiIn || siPo>eiPo){
            return null;
        }
        // Inorder left root right
        // postorder left right root;
        int rootData = po[eiPo];
        System.out.println("rootData is : "+rootData);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

        //search index of root in Inorder
        int rootIndex = -1;
        for(int i = siIn; i <= eiIn; i++ ){
            if(in[i] == rootData){
                rootIndex = i;
                break;
            }
        }

        // Inorder left root right
        // postorder left right root;
        int siInLeft = siIn;
        int eiInLeft = rootIndex -1;
        int siPoLeft = siPo;
        int eiPoLeft;

        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;
        int siPoRight;
        int eiPoRight = eiPo - 1;

        int lengthOfLeft = eiInLeft - siInLeft + 1;

        eiPoLeft =  siPoLeft + lengthOfLeft - 1;
        siPoRight = eiPoLeft + 1;

        //recurssive call
        BinaryTreeNode<Integer> left = constrFromPostInorder(in, po, siInLeft, eiInLeft, siPoLeft, eiPoLeft);
        BinaryTreeNode<Integer> right = constrFromPostInorder(in, po, siInRight, eiInRight, siPoRight, eiPoRight);
        root.left = left;
        root.right = right;
        return root;
    }
    public static BinaryTreeNode<Integer> insertDublicateNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }

            BinaryTreeNode<Integer> newRoot = new  BinaryTreeNode(root.data);
            BinaryTreeNode<Integer>  temp = root.left;
            root.left = newRoot;
            newRoot.left = temp;
       

        insertDublicateNode(temp);
        insertDublicateNode(root.right);
        return root;
    }

    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root){
       return  getMinAndMaxHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public static Pair<Integer, Integer> getMinAndMaxHelper(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null){         
            Pair<Integer, Integer> pair = new Pair<>(min, max);
            return pair;
        }
        if(root.data <= min){
            min = root.data;
        }
        if(root.data >= max){
            max = root.data;
        }
        // Pair<Integer, Integer> ans = new Pair<>(min, max);

        Pair<Integer, Integer> leftResult = getMinAndMaxHelper(root.left, min, max);
        Pair<Integer, Integer> rightResult = getMinAndMaxHelper(root.right, min, max);
        int finalMin = Math.min(leftResult.minimum, rightResult.minimum);
        int finalMax = Math.max(rightResult.maximum, rightResult.maximum);

        return new Pair<>(finalMin, finalMax);

    }
    
        public static List<List<Integer>> pathSumRootToLeaf(BinaryTreeNode<Integer> root, int sum){
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
         pathSumRootToLeafHelper(root, result , list, sum);
         return result;

    }
    // public static void pathSumRootToLeafHelper(BinaryTreeNode<Integer> root,List<List<Integer>> ans, List<Integer> list, int sum){
    //     if(root == null){
    //         return ;
    //     }
    //     int data = root.data;
    //     list.add(data); 
    //     if(sum == 0){
    //         ans.add(list);
    //         list = new ArrayList<>();
    //     }
        
    //      pathSumRootToLeafHelper(root.left, ans, list, sum - root.data);
    //      pathSumRootToLeafHelper(root.right, ans, list, sum - root.data);
        
    // }
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
    public static void main(String arg[]){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(3);
        root.left = leftChild;
        root.right = rightChild;

        BinaryTreeNode<Integer> leftChild_l1 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> rightChild_l1 = new BinaryTreeNode<Integer>(5);
        leftChild.left = leftChild_l1;
        leftChild.right = rightChild_l1;

        BinaryTreeNode<Integer> leftChild_r1 = new BinaryTreeNode<Integer>(6);
        rightChild.left = leftChild_r1;

        // printTree(root);

        // printDetails(root);

        // BinaryTreeNode<Integer> root_ = takeUserInput();
        // printDetails(root_);

        // BinaryTreeNode<Integer> root_ = takeUserInputBatter(true, 0, true);
        // printDetails(root_);

        // int totalNode = numberOfNodes(root);
        // System.out.println("total nodes : "+ totalNode);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // printLevelWise(rt);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // removeLeafNode(rt);
        // printLevelWise(rt);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // System.out.println("is tree balanced :"+ isTreeBalance(rt));
        // printLevelWise(rt);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // System.out.println("is tree balanced :"+ isTreeBalancedBatter(rt).isBalanced);

        // int preorder [] = {8, 5, 9, 7, 1, 12, 2, 4, 11, 3};
        // int [] inorder = {9, 5, 1, 7, 2, 12, 8, 4, 3, 11};
        // BinaryTreeNode<Integer> rt = constructTreeFromPreInorder(preorder, inorder);
        // printLevelWise(rt);


        // int [] postorder = {9, 1, 2, 12, 7, 5, 3, 11, 4, 8};
        // int [] inorder = {9, 5, 1, 7, 2, 12, 8, 4, 3, 11};
        // int [] inorder = {9, 3, 15, 20, 7};
        // int [] postorder = {9, 15, 7, 20, 3};
        // BinaryTreeNode<Integer> rt = constrFromPostInorder(inorder, postorder);
        // printLevelWise(rt);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // insertDublicateNode(rt);
        // printLevelWise(rt);

         BinaryTreeNode<Integer> rt = takeInputLevelWise();
         Pair<Integer, Integer> ans = getMinAndMax(rt);
         System.out.println("MIN_VALUE IS :"+ans.minimum);
         System.out.println("MAX_VALUE IS :"+ans.maximum);

//        BinaryTreeNode<Integer> rt = takeInputLevelWise();
//       List<List<Integer>> lists =  pathSumRootToLeaf(rt, 13);
//       for(List<Integer>  list : lists){
//            for(Integer li : list){
//                System.out.print(li+" ");
//            }
//            System.out.println();
//       }



    }
}
