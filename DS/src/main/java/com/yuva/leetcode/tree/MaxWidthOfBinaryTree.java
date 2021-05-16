package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**

662. Maximum Width of Binary Tree

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
where the null nodes between the end-nodes are also counted into the length calculation.

 * @author Yuvaraja Kanagarajan
 *
 */
public class MaxWidthOfBinaryTree {

	class Pair {
        int dist;
        TreeNode node;
        Pair(TreeNode node, int dist) {
            this.dist = dist;
            this.node = node;
        }
    }	
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxWidth = 0;
        Queue<Pair> queue =  new LinkedList<>();
        queue.add (new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int firstNodeDist = queue.peek().dist;
            int currDist = firstNodeDist;
            for (int i =0 ; i < size; i++) {
                Pair pair = queue.poll();
                currDist = pair.dist;
                if (pair.node.left!= null) {
                    queue.add(new Pair(pair.node.left, currDist*2));    
                }
                if (pair.node.right!= null) {
                    queue.add(new Pair(pair.node.right, currDist*2+1));    
                }
            }
            maxWidth = Math.max(maxWidth, currDist-firstNodeDist+1);
        }
        
        return maxWidth;
    }
}
