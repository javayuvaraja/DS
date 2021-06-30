package com.yuva.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> freqMap = new HashMap<>(); // reference map for p
		for (int i = 0; i < p.length(); i++)
			freqMap.put(p.charAt(i), freqMap.getOrDefault(p.charAt(i), 0) + 1);

		Map<Character, Integer> currMap = new HashMap<>(); // map to cache the chars in sliding window
		int start = 0, end = 0, match = 0;
		while (end < s.length()) {
			char c1 = s.charAt(end);
			if (freqMap.containsKey(c1)) {
				currMap.put(c1, currMap.getOrDefault(c1, 0) + 1);
				if (currMap.get(c1).equals(freqMap.get(c1))) { // both counts are matched
					match++;
				}
			}
			while (match == freqMap.size()) { // if both the maps are matched
				if (end - start + 1 == p.length()) { // checking both the lengths are same. if same add to result
					result.add(start);
				}

				char c2 = s.charAt(start);
				if (freqMap.containsKey(c2)) { // removing out of window
					currMap.put(c2, currMap.get(c2) - 1);
					if (currMap.get(c2) < freqMap.get(c2))
						match--;
				}
				start++;
			}
			end++;
		}
		return result;
	}
}
