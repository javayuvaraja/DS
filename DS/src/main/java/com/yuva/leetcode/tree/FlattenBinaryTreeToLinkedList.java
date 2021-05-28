package com.yuva.leetcode.tree;

/**
 * 114. Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points 
to the next node in the list and the left child pointer is always null.

The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

 * @author Yuvaraja Kanagarajan
 *
 */
public class FlattenBinaryTreeToLinkedList {

	TreeNode prev= null;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev=root;
    }
    
    
    public void flatten1(TreeNode root) {
    	TreeNode curr = root;
    	while (curr!=null) {
    		if (curr.left != null) {
    			TreeNode last = curr.left;
    			while (last.right!=null) {
    				last = last.right;
    			}
    			last.right = curr.right;
    			curr.right = curr.left;
    			curr.left = null;
    		}
    		curr = curr.right;
    	}    	
    }
}
