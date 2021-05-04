package com.yuva.leetcode.linkedlist;

/**
 * Given a singly linked list, delete all occurrences of a given key in it. 
 For example, consider the following list.

Example:

Input: 2 -> 2 -> 1 -> 8 -> 2 ->  3 -> 2 -> 7
       Key to delete = 2
Output:  1 -> 8 -> 3 -> 7 
 * @author Yuvaraja Kanagarajan
 *
 */
public class DeleteAllOccurence {

	public void deleteKey(ListNode head, int key) {
		ListNode temp = head; // dummynode
		ListNode prev = null;
		ListNode curr = head;
		// Iterate till the non key val, change the head
		while (temp!=null && curr.val==key) {
			temp= temp.next;
			head = temp;
		}
		
		while (temp!=null) {
			// iterate till key val
			while (temp != null && temp.val != key) {
                prev = temp;
                temp = temp.next;
            }
			// end of the list 
			if (temp == null) {
				return;
			}
			
			prev.next = temp.next;
			temp = prev.next;
		}
	}
	
}
