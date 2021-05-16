package com.yuva.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j 
in the array such that nums[i] == nums[j] and abs(i - j) <= k.


	Example 1:
	Input: nums = [1,2,3,1], k = 3
	Output: true

	Example 2:
	Input: nums = [1,0,1,1], k = 1
	Output: true

	Example 3:
	Input: nums = [1,2,3,1,2,3], k = 2
	Output: false
 * @author Yuvaraja Kanagarajan
 *
 */
public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> numSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (numSet.contains(nums[i])) {
				return true;
			}
			numSet.add(nums[i]);
			if (i >= k) {
				numSet.remove(nums[i - k]);
			}
		}
		return false;
	}
	
}
