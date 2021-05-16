package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
            
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i=0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                tempList.add(curr.val);
                if (curr.left!=null) {
                   queue.add (curr.left);
                }
                if (curr.right!=null) {
                    queue.add (curr.right);
                }
            }
            //result.add(tempList.stream().collect(Collectors.toList()));
            result.add(tempList);
        }
        return result;
    }
}
