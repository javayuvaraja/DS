package com.yuva.leetcode.recursion;

/**
698. Partition to K Equal Sum Subsets

Given an integer array nums and an integer k, return true if it is possible to divide 
this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * @author Yuvaraja Kanagarajan
 *
 */
public class PartitionToKEqualSumSubsets {

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0, maxNum = 0;
		for (int num : nums) {
			sum += num;
			maxNum = Math.max(maxNum, num);
		}
		if (sum % k != 0 || maxNum > sum / k) {
			return false;
		}
		return canPartitionKSubsetsFrom(nums, k, new boolean[nums.length], sum / k, 0, 0);
	}

	private boolean canPartitionKSubsetsFrom(int[] nums, int k, boolean[] visited, int targetSubsetSum,
			int curSubsetSum, int nextIndexToCheck) {
		// all subsets found
		if (k == 0) {
			return true;
		}

		// current subset sum is equal to target subset sum, so decrease the subset count and start from 
		if (curSubsetSum == targetSubsetSum) {
			return canPartitionKSubsetsFrom(nums, k - 1, visited, targetSubsetSum, 0, 0);
		}

		for (int i = nextIndexToCheck; i < nums.length; i++) {
			if (!visited[i] && curSubsetSum + nums[i] <= targetSubsetSum) {
				visited[i] = true;
				if (canPartitionKSubsetsFrom(nums, k, visited, targetSubsetSum, curSubsetSum + nums[i], i + 1)) {
					return true;
				}
				visited[i] = false;
			}
		}

		return false;
	}
}
