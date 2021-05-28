package com.yuva.leetcode.linkedlist;

public class RotateLinkedList {

	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null ) {
            return head;
        }   
        int count =1;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null) {
            count++;
            fast = fast.next;
        }
        if (k%count==0) {
            return head;
        }
        
        // calculate second pointer how many pointers have to move
        // formula : length - (k%length)
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // Ex :  if k = 7 then length =  5 - (7%5) = 5-2 = 3
        
        count = count - (k%count);
        while (count>1) {
            slow = slow.next;
            count--;
        }
        fast.next = head;
	    head = slow.next;
	    slow.next = null;
        return head;
    }
}
