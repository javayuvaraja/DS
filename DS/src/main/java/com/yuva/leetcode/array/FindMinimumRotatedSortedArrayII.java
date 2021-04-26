package com.yuva.leetcode.array;

public class FindMinimumRotatedSortedArrayII {

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		// there is no rotation
		if (nums[0] < nums[nums.length - 1]) {
			return nums[0];
		}

		int startIndex = 0;
		int endIndex = nums.length - 1;

		while (startIndex < endIndex) {
			int mid = (startIndex + endIndex) / 2;
			if (nums[mid] > nums[endIndex]) {
				startIndex = mid+1;
			}
			else if (nums[mid] < nums[endIndex]) {
				endIndex = mid;
			} else {
				endIndex--;
			}
		}
		return nums[startIndex];
	}
}
