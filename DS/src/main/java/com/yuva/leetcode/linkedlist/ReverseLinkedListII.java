package com.yuva.leetcode.linkedlist;
/**
 * 
 92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, 
reverse the nodes of the list from position left to position right, and return the reversed list.

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

 * @author Yuvaraja Kanagarajan
 *
 */
public class ReverseLinkedListII {

	/*
	 *  1-2-3-4-5-6-7, start 3, end-5
	 */
	public ListNode reverseBetween(ListNode head, int start, int end) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        int i = 1;
        // Iterate till start
        while (i < start) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode prevStart = prev; // prev =2, prev.next3, curr =3, curr.next = 4
        while (i <= end) {
            ListNode tmp = curr.next;
            curr.next = prev;  // assiging 3->2, 4->3, 5->4
            prev = curr;
            curr = tmp;
            i++;
        }
        prevStart.next.next = curr;  //  3.next = curr =>6
        prevStart.next = prev; // 2.next = 5
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
		
		ReverseLinkedListII obj = new ReverseLinkedListII();
		ListNode newHead = obj.reverseBetween(node, 3,5);
		ListUtil.printList(newHead);
	}
}
