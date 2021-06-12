package com.yuva.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, 
which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
where each new node has its value set to the value of its corresponding original node. 
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that 
the pointers in the original list and copied list represent the same list state. 
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 * @author Yuvaraja Kanagarajan
 *
 */
public class CopyRandomLinkedList {
	class Node {
		public int val;
	    public Node next;
	    public Node random;

	    public Node() {}
	    public Node(int val) {
	    	this.val= val;
	    }
	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	}
	public Node copyRandomList(Node head) {
        Map<Node, Node> copyMap = new HashMap<>();
        Node temp = head;
        while (temp!=null) {
            Node cloneNode = new Node(temp.val, null, null);
            copyMap.put(temp, cloneNode);
            temp = temp.next;
        }
        
        for (Node orgNode : copyMap.keySet()) {
            Node cloneNode = copyMap.get(orgNode);
            cloneNode.next = copyMap.get(orgNode.next);
            cloneNode.random = copyMap.get(orgNode.random);
        }
        
        return copyMap.get(head);
    }
	
	/*
	 * O(1) space complexity
	 */
	public Node copyRandomList1(Node head) {
		if (head == null) {
			return head;
		}
		Node curr = head, next;

		// First : make copy of each node, and link it to next
		while (curr != null) {
			next = curr.next;
			Node copy = new Node(curr.val);
			curr.next = copy;
			copy.next = next;
			curr = next;
		}

		// Second : assign random pointers for the copy nodes.
		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}
			curr = curr.next.next;
		}

		Node original = head, copy = head.next;

		Node copyHead = copy;
		// now separate the original list and copied list
		while (original != null) {
			original.next = copy.next;
			copy.next = (copy.next != null) ? copy.next.next : null;
			original = original.next;
			copy = copy.next;
		}

		return copyHead;
	}
}
