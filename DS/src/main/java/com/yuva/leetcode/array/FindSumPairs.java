package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
	Map<Integer, Integer> freqMap1 = new HashMap<>();
	Map<Integer, Integer> freqMap2 = new HashMap<>();
	int[] nums1;
	int[] nums2;

	public FindSumPairs(int[] nums1, int[] nums2) {
		this.nums1 = nums1;
		this.nums2 = nums2;
		for (int num : nums2) {
			freqMap2.put(num, freqMap2.getOrDefault(num, 0) + 1);
		}

		for (int num : nums1) {
			freqMap1.put(num, freqMap1.getOrDefault(num, 0) + 1);
		}
	}

	public void add(int index, int val) {
        if (freqMap2.get(nums2[index]) == 1) {
            freqMap2.remove(val);
        } else {
            freqMap2.put(nums2[index], freqMap2.get(nums2[index])- 1);   
        }
		nums2[index] += val;
		freqMap2.put(nums2[index], freqMap2.getOrDefault(nums2[index], 0) + 1);

	}

	public int count(int tot) {
		int result = 0;
		for (int a : freqMap1.keySet()) {
			if (freqMap2.containsKey(tot - a)) {
				result += freqMap1.get(a) + freqMap2.get(tot - a);
			}
		}
		return result;
	}
}
