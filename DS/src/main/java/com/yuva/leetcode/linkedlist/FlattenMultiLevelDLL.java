package com.yuva.leetcode.linkedlist;

import java.util.Stack;

public class FlattenMultiLevelDLL {
	
	public MultiLevelDLLNode flatten(MultiLevelDLLNode head) {
		MultiLevelDLLNode curr = head;
		Stack<MultiLevelDLLNode> stack= new Stack<>();
		
		while (curr!=null) {
			if (curr.child!=null) {
				MultiLevelDLLNode next = curr.next;
				if (next!=null) {
					stack.push(next);
				}
				curr.next = curr.child;
				curr.child =null;
				if (curr.next!=null) {
					curr.next.prev = curr;
				}
			} else if (curr.next==null && !stack.isEmpty()) {
				curr.next = stack.pop();
				curr.next.prev = curr;
			}
			curr = curr.next;
		}
		
		return  head;
	}
	
}

class MultiLevelDLLNode{
	public int val;
    public MultiLevelDLLNode prev;
    public MultiLevelDLLNode next;
    public MultiLevelDLLNode child;
}
