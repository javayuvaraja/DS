package com.yuva.leetcode.linkedlist;

/**
 * 
 * Leetcode 160
 * program to find the node at which the intersection of two singly linked lists begins.

	Approach 1 :
		Reverse both the linked list, then traverse both when both the node 
		are same that is the intersecting point
	
	Approach 2 :
	    Find the length of two linked list, find the diff n between two list.
	    Move the bigger list pointer to diff, then traverse both the node.
	    When both the pointer points to the same node is intersecting point.
	    
	 Approach 3:
	 	Traverse both the linked list, when one of the linked list is null point the node pointer to another list's head.
	 	Run this till both the pointer is diff. when both the pointer is equal that is intersecting point.
	 	If not meets then it will be null
	 	
	 	
 * @author Yuvaraja Kanagarajan
 *
 */
public class LinkedListIntersection {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ptrA = headA;
		ListNode ptrB = headB;
		
		while (ptrA!=ptrB) {
			ptrA = ptrA==null ? headB : ptrA.next;
			ptrB = ptrB==null ? headA : ptrB.next;
		}
		
		return ptrA;
	}
}
