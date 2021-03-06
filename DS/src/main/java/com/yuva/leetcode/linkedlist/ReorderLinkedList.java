package com.yuva.leetcode.linkedlist;

public class ReorderLinkedList {
	public void reorderList(ListNode head) {
		if (head ==null || head.next==null) {
			return;
		} 
		// Find the mid
		ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the list after the mid
        ListNode newHead = reverseList(slow.next);
        slow.next = null;
        // Reorder 
        
       ListNode ptr1 = head;
       ListNode ptr2 = newHead;
       ListNode next = null;
        while (ptr1!=null && ptr2!=null) {
            next = ptr1.next;
            // First half list node to reverse half list node
            ptr1.next = ptr2;
            // Reverse half node's next to first had
            ptr2 = ptr2.next;
            ptr1.next.next = next;           
            ptr1 = next;            
        }
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev ;
    }
    
    
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		
		ReorderLinkedList obj = new ReorderLinkedList();
		obj.reorderList(node);
		System.out.println();
		ListUtil.printList(node);
	}
}
