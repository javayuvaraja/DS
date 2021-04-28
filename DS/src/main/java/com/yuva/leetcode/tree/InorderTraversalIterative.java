package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalIterative {

	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    if (root == null) {
	    	return result;
	    }
	    Stack<TreeNode> stack  =  new Stack<>();
	    TreeNode currNode = root;
	    while (currNode == null || !stack.isEmpty()) {
	    	while (currNode!=null) {
	    		stack.push(currNode);
	    		currNode = currNode.left;
	    	}
	    	TreeNode temp = stack.pop();
	    	result.add(temp.val);
	    	currNode = temp.right;
	    }
	    return result;
	}
}
