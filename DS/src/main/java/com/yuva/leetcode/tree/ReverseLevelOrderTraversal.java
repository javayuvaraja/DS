package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
	    
	    if(root==null) {
	    	return result;
	    }
	    
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while(!queue.isEmpty()){
	        List<Integer> list = new LinkedList<>();
	        int size = queue.size();
	        for(int i=0; i<size; i++){
	            TreeNode node = queue.poll();
	            list.add(node.val);
	            if(node.left!=null) {
	            	queue.add(node.left);
	            }
	            if(node.right!=null) {
	            	queue.add(node.right);
	            }
	        }
	        result.addFirst(list);
	    }
	    return result;

	}
}
