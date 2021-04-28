package com.yuva.leetcode.linkedlist;

public class ListUtil {

	
	public static void printList(ListNode node) {
		ListNode currNode = node;
		while (currNode!=null) {
			System.out.print(currNode.val + " ->");
			currNode= currNode.next;
		}
	}
}
