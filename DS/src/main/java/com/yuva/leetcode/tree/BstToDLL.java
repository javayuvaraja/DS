package com.yuva.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * Convert a BST to a sorted circular doubly-linked list in-place
 * @author Yuvaraja Kanagarajan
 *
 */
public class BstToDLL {

	/**
	 * Logic : Inorder iterative traversal. 
	 * @param root
	 * @return
	 */
	public TreeNode treeToDoublyLinkedList(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode prev= null;
		TreeNode head = null;
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode curr = root;
		while (!stack.isEmpty() || curr != null) {
			while (curr != null) {
				stack.push(curr);
				curr = root.left;
			}
			
			curr = stack.pop();
			if (prev == null) {
				head = curr;
			} else {
				prev.right = curr;
				curr.left = prev;
			}
			
			prev = curr;
			curr = curr.right;
		}
		prev.right = head;
		head.left = prev;
		
		return head;
	}
	
	
	TreeNode prev = new TreeNode(0);
	TreeNode head = null;
    public TreeNode treeToDoublyList1(TreeNode root) {
        if (root == null) {
            return head;
        }
        inorder(root);
        
        TreeNode temp = head;
        TreeNode lastNode = head;
        while (temp!= null) {
            lastNode = temp;
            temp = temp.right;
        }
        head.left = lastNode;
        lastNode.right = head;
        return head;
    }
    
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        
        if (head == null) {
            head = node;
        }
        
		if (node != null) {
			prev.right = node;
			node.left = prev;
			prev = node;
		}
        
        inorder(node.right);
    }
    
    
    
    TreeNode prev1 = null;
    public TreeNode treeToDoublyList(TreeNode root) {
    	if (root == null) return null;
    	TreeNode dummy = new TreeNode(0);
    	prev1 = dummy;
    	helper(root);
    	//connect head and tail
    	prev1.right = dummy.right;
    	dummy.right.left = prev1;
    	return dummy.right;
    }

    private void helper (TreeNode cur) {
    	if (cur == null) return;
    	helper(cur.left);
    	prev1.right = cur;
    	cur.left = prev1;
    	prev1 = cur;
    	helper(cur.right);
    }
}
