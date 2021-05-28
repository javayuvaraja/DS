package com.yuva.leetcode.tree;

/**

Leetcode 988. Smallest String Starting From Leaf

Given the root of a binary tree, each node has a value from 0 to 25 
representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is 
lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

 * @author Yuvaraja Kanagarajan
 *
 */
public class SmallestFromLeaf {

	public String smallestFromLeaf(TreeNode root) {
	    return dfs(root, "");
	}

	public String dfs(TreeNode node, String suffix) {
	    if(null == node) {
	        return suffix;
	    }
	    suffix = "" + (char)('a' + node.val) + suffix;
	    // leaf node
	    if(null == node.left && null == node.right) {
	        return suffix;
	    }
	    // 
	    if(null == node.left || null == node.right) {
	        return (null == node.left)? dfs(node.right, suffix) :dfs(node.left, suffix);
	    }
	    
	    String left = dfs(node.left, suffix);
	    String right = dfs(node.right, suffix);
	    
	    return left.compareTo(right) <= 0? left: right;
	}
}
