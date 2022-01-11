package com.yuva.leetcode.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 1650. Lowest Common Ancestor of a Binary Tree III

Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

Each node will have a reference to its parent node. The definition for Node is below:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in 
a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."
 * Given a binary tree where each node also stores parent pointer in addition to left and right node. 
 * Given 2 nodes, find their LCA.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class LowestCommonAncestorWithParent {
	
	/**
	 * Solution 1 :  With hash, store the path of the one node to root.
	 *    Iterate the second node path, if already the node exists in the hash set then that is the lca.
	 * @param node1
	 * @param node2
	 * @return
	 */
	public ParentTreeNode lowestCommonAncestor( ParentTreeNode node1, ParentTreeNode node2) {
		 Set<ParentTreeNode> path = findPathToRoot(node1);
		 
		 //Finding the second nodes path
		 ParentTreeNode temp = node2; 
		 while (temp!=null) {
			 if (path.contains(temp)) {
				 return temp;
			 }
			 temp = temp.parent;
		 }
		 return null;
	}
	
	private Set<ParentTreeNode> findPathToRoot(ParentTreeNode node) {
		Set<ParentTreeNode> path = new HashSet<>();
		while (node!=null) {
			path.add(node);
			node = node.parent;
		}
		return path;
	}
	
	// Solution 2 : Find the depth of the two nodes from the root. 
	// Then move the higher depth node to the same level of another node. 
	// Then find the parent of the both the nodes, when both the parents are same then that is the lca
	
	private int depth(ParentTreeNode node) {
		int d = -1;
		while (node != null) {
			++d;
			node = node.parent;
		}
		return d;
	}

	// To find LCA of nodes n1 and n2 in Binary Tree
	ParentTreeNode LCA(ParentTreeNode node1, ParentTreeNode node2) {
		// Find depths of two nodes and differences
		int d1 = depth(node1);
		int d2 = depth(node2);
		int diff = d1 - d2;

		// If n2 is deeper, swap n1 and n2
		if (diff < 0) {
			ParentTreeNode temp = node1;
			node1 = node2;
			node2 = temp;
			diff = -diff;
		}

		// Move n1 up until it reaches the same level as n2
		while (diff-- != 0) {
			node1 = node1.parent;
		}
		// Now n1 and n2 are at same levels
		while (node1 != null && node2 != null) {
			if (node1 == node2)
				return node1;
			node1 = node1.parent;
			node2 = node2.parent;
		}

		return null;
	} 
	
}

class ParentTreeNode {
	ParentTreeNode parent;
	ParentTreeNode left;
	ParentTreeNode right;
	int val;
}


