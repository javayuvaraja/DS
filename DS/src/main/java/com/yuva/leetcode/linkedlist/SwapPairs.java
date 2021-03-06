package com.yuva.leetcode.linkedlist;

public class SwapPairs {
	 
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		ListNode curr = head;
		while (curr!=null && curr.next!=null) {
			ListNode firstNode = curr;
			ListNode secondNode = curr.next;
			firstNode.next = secondNode.next;
			secondNode.next = firstNode;
			prev.next = secondNode;
			prev = firstNode;
			curr = firstNode.next;
		}
		prev.next = curr;		
		return dummy.next;
	}
	
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next= new ListNode(7);
		
		SwapPairs obj = new SwapPairs();
		ListNode newHead = obj.swapPairs(node);
		ListUtil.printList(newHead);
		
	}
}
