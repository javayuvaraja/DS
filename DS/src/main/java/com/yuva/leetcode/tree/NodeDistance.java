package com.yuva.leetcode.tree;
/**
 * 
 Find distance between given pairs of nodes in a binary tree

Find the distance between two keys in a binary tree, no parent pointers are given. 
The distance between two nodes is the minimum number of edges to be traversed to reach one node from another.

  
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
              
 Distance between 7 and 6 is 3
  
 * @author Yuvaraja Kanagarajan
 *
 */
public class NodeDistance {
	
	//check if a given node is present in a binary tree or not
    public static boolean isNodePresent(TreeNode root, TreeNode node)
    {  
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return isNodePresent(root.left, node) ||
               isNodePresent(root.right, node);
    }
 
    //find the level of a given node present in a binary tree
    public static int findLevel(TreeNode root, TreeNode node, int level)
    {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
 
        if (root == node) {
            return level;
        }
 
        // search node in the left subtree
        int left = findLevel(root.left, node, level + 1);
        if (left != Integer.MIN_VALUE) {
            return left;
        }
        return findLevel(root.right, node, level + 1);
    }
 
    // Function to find the lowest common ancestor of given nodes `x` and `y`,
    // where both `x` and `y` are present in the binary tree.
    public static TreeNode findLCA(TreeNode root, TreeNode x, TreeNode y)
    {
        if (root == null) {
            return null;
        }
        if (root == x || root == y) {
            return root;
        }
        TreeNode left = findLCA(root.left, x, y);
        TreeNode right = findLCA(root.right, x, y);
       
        if (left != null && right != null) {
            return root;
        }
        return left!=null ? left:right;
    }
 
    // Function to find the distance between node `x` and node `y` in a
    // given binary tree rooted at `root` node
    public static int findDistance(TreeNode root, TreeNode x, TreeNode y)
    {
       
    	TreeNode lca = null;
        if (isNodePresent(root, y) && isNodePresent(root, x)) {
            lca = findLCA(root, x, y);
        }
        else {
            return Integer.MIN_VALUE;
        }
 
        // return distance of `x` from lca + distance of `y` from lca
        return findLevel(lca, x, 0) + findLevel(lca, y, 0);
 
        /*
            The above statement is equivalent to the following:
 
            return findLevel(root, x, 0) + findLevel(root, y, 0) -
                    2*findLevel(root, lca, 0);
 
            We can avoid calling the `isNodePresent()` function by using
            return values of the `findLevel()` function to check if
            `x` and `y` are present in the tree or not.
        */
    }
    
    
    public static void main(String[] args)
    {
        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     / \
            4   5   6
               / \
              7   8
        */
 
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
 
        // find the distance between node 7 and node 6
        System.out.print(findDistance(root, root.right.left.left, root.right.right));
    }
}
