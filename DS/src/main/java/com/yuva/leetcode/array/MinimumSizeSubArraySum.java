package com.yuva.leetcode.array;

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
