package com.yuva.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;
/**
38. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, 
which could point to any node in the list, or null.


Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
where each new node has its value set to the value of its corresponding original node. 
Both the next and random pointer of the new nodes should point to new nodes in the copied list 
such that the pointers in the original list and copied list represent the same list state. 
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. 
Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 * @author Yuvaraja Kanagarajan
 *
 */
public class CloneListWithRandomPointer {

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
	
	// 1. Insert the cloned node as next to the actual node, 
	// 2. Assign the random pointer
	// 3. Restore the original list
	public Node copyRandom(Node head) {
		Node currNode = head;
		
		// Clone and assign as next to the currNode
		while (currNode!=null) {
			Node clonedNode = new Node();
			clonedNode.val = currNode.val;
			clonedNode.next = currNode.next;
			currNode.next = clonedNode;
		}
		
		currNode = head;
		// assign the random pointer for the cloned node
		while (currNode!=null) {
			if (currNode.random !=null) {
				currNode.next.random = currNode.random.next;
			}
			currNode = currNode.next.next;					
		}
		
		currNode = head;
		// restoring the original array
		Node original = head;
		Node clone = head.next;
		Node temp = clone;
		
		while (original!=null && clone!=null) {
			original.next = original.next !=null ? original.next.next : original.next;
			clone.next = clone.next !=null ? clone.next.next : clone.next;
			original = original.next;
			clone = clone.next;
		}
		
		return temp;
		
	}
	
	
	class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	}
}
