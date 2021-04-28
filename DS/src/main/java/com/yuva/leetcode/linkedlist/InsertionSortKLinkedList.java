package com.yuva.leetcode.linkedlist;

public class InsertionSortKLinkedList {

	
	public ListNode insertionSort (ListNode node) {
		if (node == null) {
			return node;
		}
		
		ListNode sortedHead =  new ListNode(0);
		ListNode sortedNode = sortedHead;
		ListNode curr = node;
		ListNode next = null;
		while (curr!=null) {
			next = curr.next;
			while (sortedNode.next!=null && sortedNode.next.val < curr.val) {
				sortedNode = sortedNode.next;
			}
			curr.next = sortedNode.next;  
			sortedNode.next = curr;  // insert between sorted node and sorted next
			sortedNode = sortedHead;
			curr = next;
		}
		return sortedHead.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode (4);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		InsertionSortKLinkedList obj = new InsertionSortKLinkedList();
		
		ListNode sortedHead = obj.insertionSort(head);
		ListUtil.printList(sortedHead);
	}
}
