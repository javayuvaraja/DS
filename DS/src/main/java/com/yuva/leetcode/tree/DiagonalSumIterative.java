package com.yuva.leetcode.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Diagonal Sum iterative
 * @author Yuvaraja Kanagarajan
 *
 */
public class DiagonalSumIterative {
	
	public void diagonalSum(TreeNodeWithDistance node,  Map<Integer, Integer> map) {
		// Queue which stores tree nodes
        Queue<TreeNodeWithDistance> queue = 
        		new LinkedList<TreeNodeWithDistance>();
 
        // Assign the root's vertical distance as 0.
        node.hd = 0;
        queue.add(node);
 
        // Loop while the queue is not empty
        while (!queue.isEmpty()) {
            // Remove the front tree node from queue.
        	TreeNodeWithDistance curr = queue.remove();
 
            // Get the vertical distance of the dequeued node.
            int vd = curr.hd;
 
            // Sum over this node's right-child, right-of-right-child
            // and so on
            while (curr != null) {
                int prevSum = (map.get(vd) == null)? 0: map.get(vd);
                map.put(vd, prevSum + curr.data);
 
                // If for any node the left child is not null add
                // it to the queue for future processing.
                if (curr.left != null) {
                    curr.left.hd = vd+1;
                    queue.add(curr.left);
                }
                // Move to the current node's right child.
                curr = curr.right;
            }
        }
    }
	
	public void printDiagonalSum(TreeNodeWithDistance node) {
		Map<Integer, Integer> map = new TreeMap<>();
		Set<Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Entry<Integer, Integer>> iterator = set.iterator();
        System.out.print("Diagonal sum in a binary tree is - ");
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
	}
}
