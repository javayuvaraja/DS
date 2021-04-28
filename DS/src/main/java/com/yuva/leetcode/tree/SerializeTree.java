package com.yuva.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {

	public String serialize(TreeNode root) {
		StringBuilder str = new StringBuilder();
		serialize(root, str);
		return str.toString();
	}
	
	private void serialize(TreeNode root, StringBuilder str) {
		if (root==null) {
			str.append("#").append(",");
			return;
		}
		str.append(root.val+",");
		serialize(root.left);
		serialize(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		 Queue<String> nodes = new LinkedList<>();
		 nodes.addAll(Arrays.asList(data.split(",")));
		 return buildTree(nodes);
	}
	
	
	private TreeNode buildTree (Queue<String> nodes) {
		String val = nodes.remove();
		if (val == "#") {
			return null;
		} else {
			TreeNode node = new TreeNode (Integer.parseInt(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}		
	}
}
