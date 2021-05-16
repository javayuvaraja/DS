package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewIterative {

	/**
	 * Logic : Level order traversal, last node of the level
	 */
	public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while (size-- > 0){
                TreeNode cur = queue.poll();
                if (size == 0) {
                    res.add(cur.val);
                }
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        
        return res;
    }
}
