package com.yuva.leetcode.array;

/**
 1060. Missing Element in Sorted Array

Given an integer array nums which is sorted in ascending order and all of its elements 
are unique and given also an integer k, return the kth missing number starting from the leftmost number of the array.

 

Example 1:
Input: nums = [4,7,9,10], k = 1
Output: 5
Explanation: The first missing number is 5.

Example 2:
Input: nums = [4,7,9,10], k = 3
Output: 8
Explanation: The missing numbers are [5,6,8,...], hence the third missing number is 8.

Example 3:
Input: nums = [1,2,4], k = 3
Output: 6
Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.

 * @author Yuvaraja Kanagarajan
 *
 */
public class MissingElementInSortedArray {

	/*
	 * 1. First Number of missing elements in the array
	 * 		5,8,9,12  => 12-5-4(length) = 3, so three elements are missing
	 */
	public int missingElement(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
		int missingCount = nums[end] - nums[start] - (end - start);

		// If missing count is less than k, then missing number will be after the last element
		if (k > missingCount) {
			return nums[end] + k - missingCount;
		}

		while (start < end - 1) { // first try to write the code with start < end, after first execution add end-1
			int mid = (start + end) / 2;
			missingCount = nums[mid] - nums[start] - (mid - start);
			
			if (k > missingCount) { // k is more than missing count till mid, so subtract current missing count and move the start to mid
				k -= missingCount;
				start = mid;
			} else {
				end = mid;
			}
		}

		return nums[start] + k;
	}

}
