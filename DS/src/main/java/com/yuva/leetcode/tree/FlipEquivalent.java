package com.yuva.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 951. Flip Equivalent Binary Trees

For a binary tree T, we can define a flip operation as follows:
 choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only 
if we can make X equal to Y after some number of flip operations.

Given the roots of two binary trees root1 and root2, return true 
if the two trees are flip equivelent or false otherwise.

 * @author Yuvaraja Kanagarajan
 *
 */
public class FlipEquivalent {

	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
				|| (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
	}
	
	
	public boolean flipEquivIterative(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll(), n2 = q2.poll();
            if (n1 == null || n2 == null) {
                if (n1 != n2) return false;
                else continue;
            }
            if (n1.val != n2.val) {
                return false;
            }
            if (n1.left == n2.left || n1.left != null && n2.left != null && n1.left.val == n2.left.val) {
                q1.addAll(Arrays.asList(n1.left, n1.right));
            }else {
                q1.addAll(Arrays.asList(n1.right, n1.left));
            }
            q2.addAll(Arrays.asList(n2.left, n2.right));
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
