package com.yuva.leetcode.tree;

/**
 * 1038. Binary Search Tree to Greater Sum Tree

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that 
every key of the original BST is changed to the original key plus sum of all keys greater 
than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ConvertGreaterBstII {

	public TreeNode bstToGst(TreeNode root) {
        convertBST1(root);
        return root;
    }
    
    int sum = 0;
    public void convertBST1(TreeNode root) {
        if (root == null ){
            return ;
        }
        
        convertBST1(root.right);
        sum = sum+root.val;
        root.val = sum;
        convertBST1(root.left);
    }
}
