package com.yuva.leetcode.linkedlist;

public class DLLNode<T> {
	public DLLNode<T> prev;
	public DLLNode<T> next;
	public T val;
	
	public DLLNode (T val) {
		this.val = val;
	}
}
