package com.yuva.leetcode.linkedlist;

import java.util.Stack;

public class AddTwoNumberII {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        int carry = 0;
        ListNode head = new ListNode(0);
        while (!s1.empty() || !s2.empty() || carry > 0) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            node.next = head.next;
            head.next = node;
            sum /= 10;
        }
        
        return head.next;
    }
	
	public static void main(String[] args) {
		ListNode node1= new ListNode(9);
		node1.next = new ListNode(9);
		node1.next.next = new ListNode(9);
		node1.next.next.next = new ListNode(6);
		
		
		ListNode node2= new ListNode(7);
		node2.next = new ListNode(8);
		
		AddTwoNumberII obj = new AddTwoNumberII();
		ListNode result = obj.addTwoNumbers(node1, node2);
	
		while (result!=null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
