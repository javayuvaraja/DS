package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNoOfUniqueIntegersAfterKRemoval {

	public int findLeastNumOfUniqueInts(int[] arr, int k) {
    
		  Map<Integer, Integer> countMap = new HashMap<>();
	        for (int num : arr) {
	        	countMap.put(num, 1 + countMap.getOrDefault(num, 0));
	        }
	        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(countMap::get));
	        pq.addAll(countMap.keySet());
	        while (k > 0) {
	        	k -= countMap.get(pq.poll());
	        }
	            
	        return k < 0 ? pq.size() + 1 : pq.size();
    }
	
	
	 public int findLeastNumOfUniqueInts1(int[] arr, int k) {
	        Map<Integer, Integer> countMap = new HashMap<>();
	        for (int a : arr)
	            countMap.put(a, 1 + countMap.getOrDefault(a, 0));
	        int remaining = countMap.size();
	        int occur = 1;
	        int[] occurrenceCount = new int[arr.length + 1];
	        for (int v : countMap.values()) {
	            ++occurrenceCount[v];
	        }

	        while (k > 0) {
	            if (k - occur * occurrenceCount[occur] >= 0) {
	                k -= occur * occurrenceCount[occur];
	                remaining -= occurrenceCount[occur];
	                occur++;
	            }else {
	                return remaining - k / occur;
	            }
	        }
	        return remaining;        
	    }
	 
	 public int findLeastNumOfUniqueIntsII(int[] arr, int k) {
	        Map<Integer, Integer> numMap = new HashMap<>();
	        
	        for (int num : arr) {
	            numMap.put(num, numMap.getOrDefault(num, 0) +1);
	        }
	        
	        List<Integer> valueList = new ArrayList<Integer>(numMap.values());
	        Collections.sort(valueList);
	        int result = valueList.size();
	        for (int value : valueList) {
	            if (k >= value) {
	                result --;
	                k = k-value;
	            } else {
	                break;
	            }                
	        }
	        return result;       
	        
	    }
}
