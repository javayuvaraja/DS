package com.yuva.leetcode.dp;


/**
 * 
Leetcode : 53. Maximum Subarray

Given an integer array nums, find the contiguous subarray 
(containing at least one number) which has the largest sum and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class MaximumSubArraySum {

	public int maxSubArray(int[] nums) {
		int currMax = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			currMax = Math.max(nums[i], currMax + nums[i]);
			result = Math.max(result, currMax);
		}
		return result;

	}

	public int maxSubArrayDP(int[] A) {
		int n = A.length;
		int[] dp = new int[n];// dp[i] means the maximum subarray ending with A[i];
		dp[0] = A[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
