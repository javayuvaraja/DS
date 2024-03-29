package com.yuva.leetcode.tree;

public class TruncatePathLessThanK {

	   // Function to check if a given node is a leaf node or not
    public static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }
 
    // The main function to truncate a given binary tree to remove nodes
    // that lie on a path having a sum less than `k`
    public static TreeNode truncate(TreeNode curr, int k, int sum)
    {
        // base case: empty tree
        if (curr == null) {
            return null;
        }
 
        // update sum of nodes in the path from the root node to the current node
        sum = sum + (curr.val);
 
        // Recursively truncate left and right subtrees
        curr.left = truncate(curr.left, k, sum);
        curr.right = truncate(curr.right, k, sum);
 
        // Since we are doing postorder traversal, the subtree rooted at the current
        // node may be already truncated, and the current node is a leaf
 
        // if the current node is a leaf node and its path from the root node has a sum
        // less than the required sum, remove it
        if (sum < k && isLeaf(curr))
        {
            // set the current node as null
            return null;
        }
 
        return curr;
    }
 
    // Function to truncate a given binary tree to remove nodes which lie on
    // a path having sum less than `k`
    public static TreeNode truncate(TreeNode root, int k)
    {
        int sum = 0;
        return truncate(root, k, sum);
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                  6
                /   \
               /     \
              3       8
                    /   \
                   /     \
                  4       2
                /   \      \
               /     \      \
              1       7      3
        */
 
    	TreeNode root =  new TreeNode(6);
        root.left =  new TreeNode(3);
        root.right =  new TreeNode(8);
        root.right.left =  new TreeNode(4);
        root.right.right =  new TreeNode(2);
        root.right.left.left =  new TreeNode(1);
        root.right.left.right =  new TreeNode(7);
        root.right.right.right =  new TreeNode(3);
 
        int k = 20;
        root = truncate(root, k);
        TreeUtils.printInorder(root);
    }
}
