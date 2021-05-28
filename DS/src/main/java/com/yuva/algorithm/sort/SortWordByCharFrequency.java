package com.yuva.algorithm.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortWordByCharFrequency {
	public  String frequencySort(String word) {
		Map<Character, Integer> freqMap = new  HashMap<>();
		for (Character ch : word.toCharArray()) {
			freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
		}
		
		List<Character>[] bucket = new List[word.length() + 1];
		for (char key : freqMap.keySet()) {
			int frequency = freqMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >= 0; pos--) {
			if (bucket[pos] != null) {
				for (char c : bucket[pos]) {
					for (int i = 0; i < pos; i++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}
}
