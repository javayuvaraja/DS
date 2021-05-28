package com.yuva.leetcode.linkedlist;

public class AddTwoNumberI {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode prev = result;
		int carry =0;
		while (l1!=null || l2!=null || carry > 0) {
			int sum = carry;
			sum += l1!=null ? l1.val : 0;
			sum += l2!=null ? l2.val : 0;
			ListNode temp = new ListNode(sum%10);
			carry = sum/10;
			prev.next = temp;
			prev = temp;
			l1 = l1!=null ? l1.next : null;
			l2 = l2!=null ? l2.next : null;
		}
		return result.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(3);

		ListNode node2 = new ListNode(5);
		node2.next = new ListNode(6);
		node2.next.next = new ListNode(4);
		
		AddTwoNumberI obj = new AddTwoNumberI();
		ListNode result = obj.addTwoNumbers(node1, node2);
		
		while (result!=null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
