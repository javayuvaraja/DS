package com.yuva.leetcode.tree;

public class MaxSumRootToLeaf {

	static int maxSum = Integer.MIN_VALUE;
	
	public static void findMaxSum (TreeNode node, Integer currVal ) {
		if (node == null) {
			return;
		}
		
		Integer currSum = currVal + node.val;
		if (node.left==null && node.right== null) {
			maxSum = Math.max(maxSum, currSum);
		}
		
		findMaxSum(node.left, currSum);
		findMaxSum(node.right, currSum);
		
	}
	 // Function to print maximum sum root-to-leaf path in a given binary tree
    public static void findMaxSumPath(TreeNode root)
    {
        findMaxSum (root, 0);
        System.out.println("The maximum sum is " + maxSum);   
        PrintPathGivenSum.printPathSum(root, maxSum);
    }
 
    public static void main(String[] args)
    {
        /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            8   4   5   6
               /   / \   \
             10   7   9   5
        */
 
        TreeNode root =  new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(3);
        root.left.left =  new TreeNode(8);
        root.left.right =  new TreeNode(4);
        root.right.left =  new TreeNode(5);
        root.right.right =  new TreeNode(6);
        root.left.right.left =  new TreeNode(10);
        root.right.left.left =  new TreeNode(7);
        root.right.left.right =  new TreeNode(9);
        root.right.right.right =  new TreeNode(5);
 
        findMaxSumPath(root);
    }
}
