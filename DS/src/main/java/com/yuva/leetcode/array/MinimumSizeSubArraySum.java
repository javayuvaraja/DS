package com.yuva.leetcode.array;


/**
 * Leetcode 209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, 
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] 
of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

 * @author Yuvaraja Kanagarajan
 *
 */
public class MinimumSizeSubArraySum {

	public int minSubArrayLen(int target, int[] nums) {
		int currSum = 0;
		int startIndex = 0;
		int minWinLength = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			while (currSum >= target) {
				minWinLength = Math.min(minWinLength, i - startIndex + 1);
				currSum -= nums[startIndex++];
			}
		}
		return (minWinLength == Integer.MAX_VALUE) ? 0 : minWinLength;
	}
}
