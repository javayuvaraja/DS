package com.yuva.leetcode.tree;

/**
 *

Leetcode 129. Sum Root to Leaf Numbers
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers.

A leaf node is a node with no children.


Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026

Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 * @author Yuvaraja Kanagarajan
 *
 */
public class RootToLeafSum {

	int sum = 0;
	
	public int sumNumbers(TreeNode root) {
		sum = 0;
		sumNumbers(root, 0);
		return sum;
    }
	public void sumNumbers(TreeNode root, int currVal) {
		if (root == null) {
			return;
		}
		
		currVal = currVal*10+root.val;
		if (root.left==null && root.right==null) {
			sum = sum + currVal;
		}
		
		sumNumbers(root.left, currVal);
		sumNumbers(root.right, currVal);
    }
	
	public static void main(String[] args) {
		/**
		    4
		   / \
		  9   0
		 / \
		5   1
		
       */
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(0);
		
		RootToLeafSum obj =  new RootToLeafSum();
		System.out.println(obj.sumNumbers(root));
	}
}
