package com.yuva.leetcode.linkedlist;

/**
 * 203. Remove Linked List Elements
 *  Remove all elements from a linked list of integers that have value val.

	Example:
	
	Input:  1->2->6->3->4->5->6, val = 6
	Output: 1->2->3->4->5
 * @author Yuvaraja Kanagarajan
 *
 */
public class RemoveListNode {

	public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = null;
        while (curr!=null) {
        	next = curr.next;
        	if (curr.val == val) {
        		prev.next = next;
        		curr.next = null;
        	} else {
        		prev.next = curr;
        		prev = prev.next;
        	}
        	curr = next;
        }
        return dummy.next;
    }
}
