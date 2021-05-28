package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
523. Continuous Subarray Sum

Given an integer array nums and an integer k, return true if nums has a 
continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false

 */
public class ContinousSubArraySumMultipleOfK {
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> prefixSum = new HashMap<>();
		prefixSum.put(0, -1);
		int currSum = 0;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if (k != 0) {
				currSum %= k;
			}
			Integer prev = prefixSum.get(currSum);
			if (prev != null) { // checking whether already exists
				if (i - prev > 1)  // check whether window length is greater than 1
					return true;
			} else
				prefixSum.put(currSum, i);  // storing the modulo value and index
		}
		return false;
	}

}
