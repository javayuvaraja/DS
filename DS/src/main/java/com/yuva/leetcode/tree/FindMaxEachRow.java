package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
	Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindMaxEachRow {

	/**
	 * Logic : Level order traversal.
	 * Compare the max value with the each node
	 * @param root
	 * @return
	 */
	public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> values = new ArrayList<Integer>();
        
        if(root != null) q.offer(root);
        
        while(!q.isEmpty()) {
            int max = Integer.MIN_VALUE, n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            values.add(max);
        }
        
        return values;
    }
	
	/**
	 * Logic :  Initially the list size is 0, 
	 * whenever moving to the next level add the entry to the 
	 * @param root
	 * @param res
	 * @param d
	 */
	private void dfs(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        dfs(root.left, res, d+1);
        dfs(root.right, res, d+1);
    }
	
}
