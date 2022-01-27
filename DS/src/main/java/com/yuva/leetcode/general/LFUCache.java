package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**

460. LFU Cache

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present.
 When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. 
 For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. 
The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). 
The use counter for a key in the cache is incremented either a get or put operation is called on it.

 

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[3,4], cnt(4)=2, cnt(3)=3

 * @author Yuvaraja Kanagarajan
 *
 */
public class LFUCache {

	HashMap<Integer, Integer> valueMap; // key,  value pair
    HashMap<Integer, Integer> freqMap;  // each key how many times are used
    HashMap<Integer, LinkedHashSet<Integer>> lists; // frequency, key
    int capacity;
    int min = -1;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>();
        freqMap = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    /*
     * 1. If key is not available then return -1
     * 2. If key is available get the freq
     *    Increment the freq, remove the old freq in the list
     */
    public int get(int key) {
        if(!valueMap.containsKey(key)) {
            return -1;
        }
        int count = freqMap.get(key);
        freqMap.put(key, count+1);  // increment the usage
        lists.get(count).remove(key); // remove from earlier frequency
        if(count==min && lists.get(count).size()==0) // earlier count is min and after removal for the key value is zero, then increment min
            min++;
        lists.putIfAbsent(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return valueMap.get(key);
    }
    
	public void put(int key, int value) {
		if (capacity <= 0)
			return;
		if (valueMap.containsKey(key)) {
			valueMap.put(key, value);
			get(key); // increment the freq
			return;
		}
		if (valueMap.size() >= capacity) {
			int evit = lists.get(min).iterator().next();  // remove the first entry from min freq
			lists.get(min).remove(evit);
			valueMap.remove(evit);
			freqMap.remove(evit);
		}
		valueMap.put(key, value);
		freqMap.put(key, 1);
		min = 1;
		lists.get(1).add(key);
	}
}
