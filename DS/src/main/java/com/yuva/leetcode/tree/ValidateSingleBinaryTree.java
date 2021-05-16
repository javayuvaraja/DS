package com.yuva.leetcode.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given a list of TreeNodes. TreeNode is standard LC class:

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
}
Find out if all these nodes belong to the same valid binary tree.

public boolean isBinaryTree(List<TreeNode> nodes) {
}
Example 1:

Let's say we have the following binary tree

		1
       ↙ ↘
      2   3
         ↙
        4

We can create it like this
TreeNode n1 = new TreeNode(1);
TreeNode n2 = new TreeNode(2);
TreeNode n3 = new TreeNode(3);
TreeNode n4 = new TreeNode(4);

n1.left = n2;
n1.right = n3;
n3.left = n4;

Input: [n4, n2, n3, n1]
Output: true
Example 2:

		 1
       ↙  ↘
      2    3
       ↘  ↙
        4

TreeNode n1 = new TreeNode(1);
TreeNode n2 = new TreeNode(2);
TreeNode n3 = new TreeNode(3);
TreeNode n4 = new TreeNode(4);

n1.left = n2;
n1.right = n3;
n2.right = n4;
n3.left = n4;

Input: [n2, n3, n4, n1]
Output: false
Example 3:

	 1
	⤤ ⤦
	 2 

TreeNode n1 = new TreeNode(1);
TreeNode n2 = new TreeNode(2);

n1.left = n2;
n2.left = n1;

Input: [n1, n2]
Output: false
Example 4:

		1           4
       ↙ ↘        ↙  ↘
      2   3      5     6

TreeNode n1 = new TreeNode(1);
TreeNode n2 = new TreeNode(2);
TreeNode n3 = new TreeNode(3);
TreeNode n4 = new TreeNode(4);
TreeNode n5 = new TreeNode(5);
TreeNode n6 = new TreeNode(6);

n1.left = n2;
n1.right = n3;

n4.left = n5;
n4.right = n6;

Input: [n2, n6, n4, n1, n3, n5]
Output: false
Example 5:

		1
       ↙ ↘
      2   3
         ↙
        4

TreeNode n1 = new TreeNode(1);
TreeNode n2 = new TreeNode(2);
TreeNode n3 = new TreeNode(3);
TreeNode n4 = new TreeNode(4);

n1.left = n2;
n1.right = n3;
n3.left = n4;

Input: [n2, n3, n1]
Output: false
Explanation: l4 is a part of the tree but it's missing in the input list so return false.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidateSingleBinaryTree {

	/**
	 * We need to ensure 3 things to guarantee a valid binary tree:

		1. There can be one and only one root
		2. All nodes should have only one indegree, except the root node, which has zero indegree
		3. Check if there any node missed from the given list
	 */
	
	public boolean isBinaryTree(List<TreeNode> nodes) {
		Map<TreeNode, Integer> indegreeMap = new HashMap<>();
		for (TreeNode node : nodes) {
			if (node.left != null)
				indegreeMap.put(node.left, indegreeMap.getOrDefault(node.left, 0) + 1);
			if (node.right != null)
				indegreeMap.put(node.right, indegreeMap.getOrDefault(node.right, 0) + 1);
		}
		TreeNode root = null;
		for (TreeNode node : nodes) {
			if (!indegreeMap.containsKey(node)) { // for checking the root
				if (root == null) {
					root = node;
				} else {  // two nodes cannot be the root
					return false;
				}
			} else if (indegreeMap.get(node) != 1) {  // more than one parent
				return false;
			}
		}
		return root != null 
				&& nodes.size() == indegreeMap.keySet().size() + 1; // checking nodes count and indegree map count + 1 (for root)
	}
}
