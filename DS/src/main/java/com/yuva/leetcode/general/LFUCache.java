package com.yuva.leetcode.general;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

	HashMap<Integer, Integer> valueMap;
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
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
        freqMap.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return valueMap.get(key);
    }
    
    public void set(int key, int value) {
        if(capacity<=0)
            return;
        if(valueMap.containsKey(key)) {
            valueMap.put(key, value);
            get(key);
            return;
        } 
        if(valueMap.size() >= capacity) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            valueMap.remove(evit);
        }
        valueMap.put(key, value);
        freqMap.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
