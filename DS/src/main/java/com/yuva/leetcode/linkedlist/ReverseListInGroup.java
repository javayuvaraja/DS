package com.yuva.leetcode.linkedlist;

public class ReverseListInGroup {

	
	public ListNode reverseGroup(ListNode head, int k) {
		
		ListNode dummy = new ListNode(0);
		ListNode last = dummy;
		ListNode curr = head;
		while (curr.next!=null) {
			int count = 0;
			ListNode prev = null;
			ListNode next =  null;
			ListNode temp = curr;
			while (curr.next!= null && count < k) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			last.next = prev;
			temp.next = curr;
			last = temp;
		}
		
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
		
		ReverseListInGroup obj = new ReverseListInGroup();
		ListNode newHead = obj.reverseGroup(node, 2);
		ListUtil.printList(newHead);
	
	}
}
