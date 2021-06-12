package com.yuva.leetcode.linkedlist;

import java.util.Stack;

/**
445. Add Two Numbers II

You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
 
 * @author Yuvaraja Kanagarajan
 *
 */
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
        ListNode dummy = new ListNode(0);
        while (!s1.empty() || !s2.empty() || carry > 0) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            node.next = dummy.next;
            dummy.next = node;
            sum /= 10;
        }
        
        return dummy.next;
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
