package com.yuva.leetcode.dp;

/**
 * 152. Maximum Product Subarray 

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, 
and return the product.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6

Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
 * @author Yuvaraja Kanagarajan
 *
 */
public class MaximumSubarrayProduct {

	public int maxProduct(int[] nums) {
		int max = nums[0];
		int currMax = max;
		int currMin = max;

		for (int i = 1; i < nums.length; i++) {
			// If current number is negative then swap the min and max
			if (nums[i] < 0) {
				int temp = currMax;
				currMax = currMin;
				currMin = temp;
			}
			currMax = Math.max(nums[i], currMax * nums[i]);
			currMin = Math.min(nums[i], currMin * nums[i]);

			max = Math.max(max, currMax);

		}
		return max;
	}
}
