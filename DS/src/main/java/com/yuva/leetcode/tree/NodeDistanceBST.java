package com.yuva.leetcode.tree;

/**
 * 
 * 
Write a function that given a BST, it will return the distance (number of edges) between 2 nodes.

For example, given this tree

         5
        / \
       3   6
      / \   \
     2   4   7
    /         \
   1           8
The distance between 1 and 4 is 3: [1 -> 2 -> 3 -> 4]

The distance between 1 and 8 is 6: [1 -> 2 -> 3 -> 5 -> 6 -> 7 -> 8]
 * @author Yuvaraja Kanagarajan
 *
 */
public class NodeDistanceBST {

	public int bstDistance(TreeNode root, int node1, int node2) {
	    if (root == null) return -1;
	    TreeNode lca = lca(root, node1, node2);
	    return getDistance(lca, node1) + getDistance(lca, node2);
	}

	private int getDistance(TreeNode src, int dest) {
	    if (src.val == dest) return 0;
	    TreeNode node = src.left;
	    if (src.val < dest) {
	        node = src.right;
	    }
	    return 1 + getDistance(node, dest);
	}

	private TreeNode lca(TreeNode root, int node1, int node2) {
		while (true) {
	        if (Math.max(node1, node2) < root.val ) {
	            root = root.left;
	        } else if (Math.min(node1, node2) > root.val) {
	            root = root.right;
	        } else {
	            return root;
	        }
	    }
	}	
	
}
