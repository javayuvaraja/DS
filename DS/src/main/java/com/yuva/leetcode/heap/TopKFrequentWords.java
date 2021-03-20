package com.yuva.leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
		
		PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
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
}
