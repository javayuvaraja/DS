package com.yuva.leetcode.tree;

/**
Leetcode : 700. Search in a Binary Search Tree


You are given the root of a binary search tree (BST) and an integer val.
Find the node in the BST that the node's value equals val and return the 
subtree rooted with that node. If such a node does not exist, return null.
 * @author Yuvaraja Kanagarajan
 *
 */
public class BinarySearchTreeSearch {

	public TreeNode searchBST(TreeNode root, int val) {
        if (root== null) {
            return null;
        }
        
        TreeNode currNode = root;
        while (currNode!=null) {
            if (currNode.val == val ) {
                return currNode;
            } 
            if (currNode.val > val) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
        return null;
    }
}
