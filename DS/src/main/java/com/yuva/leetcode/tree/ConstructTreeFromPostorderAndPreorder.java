package com.yuva.leetcode.tree;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal


Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
 * @author Yuvaraja Kanagarajan
 *
 */
public class ConstructTreeFromPostorderAndPreorder {
	int preIndex = 0, posIndex = 0;

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		TreeNode root = new TreeNode(pre[preIndex++]);
		if (root.val != post[posIndex])
			root.left = constructFromPrePost(pre, post);
		if (root.val != post[posIndex])
			root.right = constructFromPrePost(pre, post);
		posIndex++;
		return root;
	}

	public static void main(String[] args) {
		ConstructTreeFromPostorderAndPreorder obj = new ConstructTreeFromPostorderAndPreorder(); 
		int []pre = {1,2,4,5,3,6,7};
		int post[] = {4,5,2,6,7,3,1};
		obj.constructFromPrePost(pre, post);
		
	}
}
