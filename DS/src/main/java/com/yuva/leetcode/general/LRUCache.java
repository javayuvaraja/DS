package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.Map;
/**
146. LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. 

Otherwise, add the key-value pair to the cache. If the number of keys 
exceeds the capacity from this operation, evict the least recently used key.

 * @author Yuvaraja Kanagarajan
 *
 */
class LRUCache {

    private Map <Integer, DLLNode> cacheMap;
	private int capacity;
	private DLLNode head;
	private DLLNode tail;
	
    public LRUCache(int capacity) {
    	this.capacity = capacity;
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
        cacheMap = new HashMap<Integer, DLLNode>();
    }
    
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
        	DLLNode currNode = cacheMap.get(key);
        	removeNode(currNode);
        	insertNode(currNode);
        	return currNode.value;
        } else {
        	return -1;
        }	
    }
    
    public void put(int key, int value) {
    	DLLNode node = null;
    	if (cacheMap.containsKey(key)) {
    		node = cacheMap.get(key);
        	removeNode(cacheMap.get(key));
        	cacheMap.remove(key);
        } else {
        	node = new DLLNode(key, value);
        }
        if (cacheMap.size()== capacity) {
        	DLLNode lastNode = tail.prev;
        	removeNode(tail.prev);
        	cacheMap.remove(lastNode.key);
        }
        insertNode(node);
    }
    
    private void insertNode(DLLNode node) {
    	node.prev = head;
    	node.next = head.next;
    	head.next.prev = node;
    	head.next = node;
    	cacheMap.put(node.key, node);
    }
    
    private void removeNode(DLLNode node) {
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    	node.next = null;
    	node.prev = null;
    }
    
    class DLLNode {
	DLLNode prev;
	DLLNode next;
	int key;
	int value;
	
	DLLNode (int key, int value) {
		this.key = key;
		this.value= value;
	}
}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
