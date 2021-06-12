package com.yuva.leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 692. Top K Frequent Words

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. 
If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
with the number of occurrence being 4, 3, 2 and 1 respectively.

 * @author Yuvaraja Kanagarajan
 *
 */
public class TopKFrequentWords {

	public static List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<String>();
		if (words==null || words.length==0) {
			return result;
		}
		Map<String, Integer> countMap = new HashMap<>();
		for (String word: words) {
			countMap.put(word, countMap.getOrDefault(word, 0)+1);
		}
		
		PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				
				if (o2.getValue().compareTo(o1.getValue())==0) {
					return o1.getKey().compareTo(o2.getKey());
				}
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		countMap.entrySet().forEach(entry -> heap.add(entry));
		
		for (int i=0; i < k; i++) {
			result.add(heap.poll().getKey());
		}
		return result;
    }
	
	// Another implementation is bucket sort
	
	 public List<String> topKFrequent1(String[] words, int k) {
	        HashMap<String, Integer> map = new HashMap<>();
	        int max = 0;
	        for (String w: words) {
	            map.put(w, map.getOrDefault(w, 0) + 1);
	            max = Math.max(max, map.get(w));
	        }
	        List<String>[] bucket = new ArrayList[max + 1];
	        for (Map.Entry<String, Integer> entry: map.entrySet()) {
	            int fre = entry.getValue();
	            if (bucket[fre] == null) {
	                bucket[fre] = new ArrayList<>();
	            }
	            bucket[fre].add(entry.getKey());
	        }
	        List<String> res = new ArrayList<>();
	        for (int i = max; i >= 0 && res.size() < k; i--) {
	            if (bucket[i] != null) {
	                Collections.sort(bucket[i]);
	                res.addAll(bucket[i]);
	            }
	        }
	        return res.subList(0, k);
	    }
}
