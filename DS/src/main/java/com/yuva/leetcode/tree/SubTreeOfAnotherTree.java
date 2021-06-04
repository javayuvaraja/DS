package com.yuva.leetcode.tree;

/**
572. Subtree of Another Tree

Given two binary trees, check if the first tree is subtree of the second one. 
A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T. 
The subtree corresponding to the root node is the entire tree; the subtree corresponding to 
any other node is called a proper subtree.

For example, in the following case, tree S is a subtree of tree T.

        Tree 2
          10  
        /    \ 
      4       6
       \
        30


        Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30
 * @author Yuvaraja Kanagarajan
 *
 */
public class SubTreeOfAnotherTree {
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		if (isSameTree(s, t)) {
			return true;
		}
		return isSubtree(s.left, t) || 
				isSubtree(s.right, t);

	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		if (s.val != t.val) {
			return false;
		}

		return isSameTree(s.left, t.left) && 
			   isSameTree(s.right, t.right);
	}
}
