package com.yuva.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		boolean isLeftToRight = true;
		Stack<TreeNode> currLevel = new Stack<>();
		currLevel.add(root);
		Stack<TreeNode> nextLevel = new Stack<>();
		while (true) {
			List<Integer> currLevelList = new ArrayList<>();
			while (!currLevel.isEmpty()) {
				TreeNode currNode = currLevel.pop();
				currLevelList.add(currNode.val);
				if (isLeftToRight) {
					if (currNode.left!=null){
						nextLevel.push(currNode.left);
					}
					if (currNode.right!=null){
						nextLevel.push(currNode.right);
					}
				} else {
					if (currNode.right!=null){
						nextLevel.push(currNode.right);
					}
					if (currNode.left!=null){
						nextLevel.push(currNode.left);
					}					
				}
			}
			result.add(currLevelList);
			if (nextLevel.isEmpty()) {
				break;
			}
			currLevel = nextLevel;
			nextLevel = new Stack<>();
			isLeftToRight = !isLeftToRight;
		}
		return result;
    }
	
	
	/**Using Queue and LinkedList 
	 * 
	 */
	public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = false;
        while(!q.isEmpty()){
            int size = q.size();            
            LinkedList<Integer> levelValues = new LinkedList<>();  
            leftToRight = !leftToRight;
            while(size > 0){
                size--;       
                TreeNode cur = q.poll();  
                if(leftToRight)
                    levelValues.add(cur.val); 
                else
                    levelValues.addFirst(cur.val);
                
                if(cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);      
                                     
            }
            list.add(levelValues);
        }
        return list;
    }
}
