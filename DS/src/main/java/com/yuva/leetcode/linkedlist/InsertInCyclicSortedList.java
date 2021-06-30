package com.yuva.leetcode.linkedlist;
/**
708. Insert into a Sorted Circular Linked List

Given a Circular Linked List node, which is sorted in ascending order, 
write a function to insert a value insertVal into the list such that it remains a sorted circular list. 
The given node can be a reference to any single node in the list and may not necessarily be the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. 
After the insertion, the circular list should remain sorted.

If the list is empty (i.e., the given node is null), you should create a new single circular list 
and return the reference to that single node. Otherwise, you should return the originally given node.

Example 1:
Input: head = [3,4,1], insertVal = 2
Output: [3,4,1,2]
Explanation: In the figure above, there is a sorted circular list of three elements. 
You are given a reference to the node with value 3, and we need to insert 2 into the list. 
The new node should be inserted between node 1 and node 3. 
After the insertion, the list should look like this, and we should still return node 3


 * @author Yuvaraja Kanagarajan
 *
 */
public class InsertInCyclicSortedList {

	/*
	 * Logic : 
	 * 		Case 1 : Head is null
	 * 				1. Create new node and assign the next to itself
	 * 				2. return node.
	 *    
	 *      Case 2 : Find the maximum node (next to maximum is minimum)
	 *      		1. Check insert value is greater than the max or lesser than the minimum
	 *      			insertval > max || insertVal < min
	 *              2. If the above condition is true, then insert the value next to the max node.
	 *              
	 *      Case 3 : Insert value in between, then find the node which is greater than the current value and less than prev node. 
	 */
	public ListNode insert(ListNode head, int insertVal) {
		
			ListNode newNode = new ListNode(insertVal);
			// case 1 : Head is null
			if (head == null) {
				newNode.next = newNode;
				return newNode;
			}
			
			// case 2 : find the max node			
			ListNode max = head;
			
			while (max.next!=head && // for break the cycle
					max.val <= max.next.val) { // condition for next value is greater or equal 
				max = max.next;	
			}
			
			ListNode min = max.next; 
			ListNode curr = min;
			
			if (insertVal > max.val || insertVal < min.val) { // case 2 then insert next to max
				max.next=newNode;
				newNode.next = min;			
			} else {
				// case 3 : find the position  
				while (curr.next.val < insertVal) {
					curr = curr.next;
				}
				newNode.next = curr.next;
				curr.next = newNode;
						
			}
			return head;
	}
}
