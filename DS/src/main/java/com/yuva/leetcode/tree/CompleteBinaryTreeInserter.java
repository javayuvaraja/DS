package com.yuva.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {

	TreeNode root;
	Queue<TreeNode> queue;
	
	/*
	 * Logic : Store non complete nodes in the queue. attach the new node to non complete nodes from the queue
	 */
	public CompleteBinaryTreeInserter(TreeNode root) {
		this.root = root;

		queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.peek();
			if (node.left == null || node.right == null) {
				if (node.left != null) {
					queue.offer(node.left);
				}
				break;
			}
			queue.poll();  // polling the complete node having two childs
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
	}

	public int insert(int v) {
		TreeNode node = queue.peek();  // getting the non complete node
		TreeNode newNode = new TreeNode(v);
		queue.add(newNode);
		if (node.left == null)
			node.left = newNode;
		else {
			node.right = newNode;
			queue.poll(); // If already left child there then assign to right and poll because it is become complete
		}
		return node.val;
	}

	public TreeNode get_root() {
		return root;
	}
	
	/*
	
	Another implementation using list.
	The concept is based on the index. size-1/2 is parent
	
	
	List<TreeNode> tree;
    
    public CBTInserter(TreeNode root) {
        tree = new ArrayList<>();
        tree.add(root);
        for (int i = 0; i < tree.size(); ++i) {
            if (tree.get(i).left != null) tree.add(tree.get(i).left);
            if (tree.get(i).right != null) tree.add(tree.get(i).right);
        }
    }

    public int insert(int v) {
        int N = tree.size();
        TreeNode node = new TreeNode(v);
        tree.add(node);
        if (N % 2 == 1)
            tree.get((N - 1) / 2).left = node;
        else
            tree.get((N - 1) / 2).right = node;
        return tree.get((N - 1) / 2).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }
	 */
}
