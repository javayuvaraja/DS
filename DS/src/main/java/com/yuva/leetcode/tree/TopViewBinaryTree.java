package com.yuva.leetcode.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TopViewBinaryTree {

	public void topView(TreeNodeWithDistance root) {
		if (root == null)
			return;

		int hd = 0;

		Map<Integer, Integer> map = new TreeMap<>();

		Queue<TreeNodeWithDistance> queue = new LinkedList<TreeNodeWithDistance>();

		root.hd = hd;
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNodeWithDistance temp = queue.remove();

			hd = temp.hd;
			if (!map.containsKey(hd)) {
				map.put(hd, temp.data);
			}
			// If the dequeued node has a left child add it to the
			// queue with a horizontal distance hd-1.
			if (temp.left != null) {
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}
			// If the dequeued node has a right child add it to the
			// queue with a horizontal distance hd+1.
			if (temp.right != null) {
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
		}

		// Extract the entries of map into a set to traverse
		// an iterator over that.
		Set<Entry<Integer, Integer>> set = map.entrySet();

		// Make an iterator
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();

		// Traverse the map elements using the iterator.
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
