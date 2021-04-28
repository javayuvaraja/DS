package com.yuva.leetcode.tree;

public class TreeLinkNode {
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode next;
	
	public TreeLinkNode(int val) {
		this.val = val;
	}
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeLinkNode getLeft() {
		return left;
	}

	public void setLeft(TreeLinkNode left) {
		this.left = left;
	}

	public TreeLinkNode getRight() {
		return right;
	}

	public void setRight(TreeLinkNode right) {
		this.right = right;
	}

	public TreeLinkNode getNext() {
		return next;
	}

	public void setNext(TreeLinkNode next) {
		this.next = next;
	}
}
