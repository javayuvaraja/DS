package com.yuva.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

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
