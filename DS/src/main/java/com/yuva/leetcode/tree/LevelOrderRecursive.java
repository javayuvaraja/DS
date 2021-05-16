package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderRecursive {

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelOrder(res, root, 0);
        return res;
    }
    
	/** 
	 Logic : Using pre order approach
	 		1. Add the root value
	 		2. Traverse the left after that right
	 */
    public void levelOrder(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(level).add(root.val);
        levelOrder(res, root.left, level+1);
        levelOrder(res, root.right, level+1);
    }
}
