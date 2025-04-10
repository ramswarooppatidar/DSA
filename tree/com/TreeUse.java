package tree.com;

import java.util.*;

class BinaryTreeNode<T>{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    public BinaryTreeNode(T data){
        this.data = data;
    }
}
public class TreeUse {
    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public static void printDetails(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" : ");
        if(root.left != null){
            System.out.print("L  "+root.left.data);
        }
        if(root.right != null){
            System.out.print(" ,R  "+root.right.data);
        }
        System.out.println();
        printDetails(root.left);
        printDetails(root.right);

    }
    public static BinaryTreeNode<Integer> takeUserInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter root data");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeUserInput();
        BinaryTreeNode<Integer> rightChild = takeUserInput();
        root.left = leftChild;
        root.right = rightChild;
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
    public static void printPostOrderTraversal(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static void printInOrderTraversal(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        
        printPreOrderTraversal(root.left);
        System.out.print(root.data+" ");
        printPreOrderTraversal(root.right);  
    }
    public static int LargestNodeValue(BinaryTreeNode<Integer> root){
        if(root == null){
            return -1;
        }
        int left = LargestNodeValue(root.left);
        int right = LargestNodeValue(root.right);
        return Math.max(root.data, Math.max(left, right));
    }
    public static int heightOfTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int numberOfLeafNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return numberOfLeafNode(root.left) + numberOfLeafNode(root.right);
    }
    public static void printAtDepthK(BinaryTreeNode<Integer> root, int depth){
        if(root == null){
            return;
        }
        if(depth == 0){
            System.err.print(root.data + " ");
        }
        printAtDepthK(root.left, depth - 1);
        printAtDepthK(root.right, depth - 1);
    }
    public static BinaryTreeNode<Integer> replaceNodeWithDepth(BinaryTreeNode<Integer> root, int count){
        if(root == null){
            return null;
        }
        root.data = count;
        replaceNodeWithDepth(root.left, count + 1);
        replaceNodeWithDepth(root.right, count+1);
        return root;
    }
    public static BinaryTreeNode<Integer> removeLeafNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            // root.data = null;
            return null;
        }
        root.left  = removeLeafNode(root.left);
        root.right = removeLeafNode(root.right);
        return root;
    }
    public static void main(String[] args) {
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
        // printPreOrderTraversal(rt);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // printPostOrderTraversal(rt);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // printInOrderTraversal(rt);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // int val = LargestNodeValue(rt);
        // System.out.println("max node value is : "+val);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // int height = heightOfTree(rt);
        // System.out.println("height is :"+ height);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        // int leafNode = numberOfLeafNode(rt);
        // System.out.println("total leafNode is :"+ leafNode);

        // BinaryTreeNode<Integer> rt = takeInputLevelWise();
        //  printAtDepthK(rt, 2);

        //  BinaryTreeNode<Integer> rt = takeInputLevelWise();
        //  replaceNodeWithDepth(rt, 0);
        //  printLevelWise(rt);

         BinaryTreeNode<Integer> rt = takeInputLevelWise();
         removeLeafNode(rt);
         printLevelWise(rt);

    

    }
}
