package com.yuva.leetcode.dp;

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
