package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 697. Degree of an Array
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2,3,1] Output: 2 Explanation: The input array has a degree
 * of 2 because both elements 1 and 2 appear twice. Of the subarrays that have
 * the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2,
 * 2, 3], [2, 2] The shortest length is 2. So return 2. Example 2:
 * 
 * Input: nums = [1,2,2,3,1,4,2] Output: 6 Explanation: The degree is 3 because
 * the element 2 is repeated 3 times. So [2,2,3,1,4,2] is the shortest subarray,
 * therefore returning 6.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class DegreeOfArray {

	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		Map<Integer, Integer> indexMap = new HashMap<>();
		int result = 0;
		int maxDegree = 0;
		for (int i = 0; i < nums.length; i++) {
			indexMap.putIfAbsent(nums[i], i);
			countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
			if (countMap.get(nums[i]) > maxDegree) {
				maxDegree = countMap.get(nums[i]);
				result = i - indexMap.get(nums[i]) + 1;
			} else if (maxDegree == countMap.get(nums[i])) {
				result = Math.min(result, i - indexMap.get(nums[i]) + 1);
			}

		}

		return result;
	}
}
