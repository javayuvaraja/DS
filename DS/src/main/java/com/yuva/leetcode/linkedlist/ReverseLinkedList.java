package com.yuva.leetcode.linkedlist;

/**
 * 
Leetcode 206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReverseLinkedList {
	public ListNode reverseListIterative(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public ListNode reverseList(ListNode head) {
		return reverseList(head, null);
	}

	public ListNode reverseList(ListNode curr, ListNode prev) {
		if (curr == null) {
			return prev;
		}
		ListNode next = curr.next;
		curr.next = prev;
		return reverseList(next, curr);
	}
}
