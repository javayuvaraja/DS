package com.yuva.leetcode.array;

/**
 * 154. Find Minimum in Rotated Sorted Array II

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. 
For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * @author Yuvaraja Kanagarajan
 *
 */
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
			} else {// When num[mid] == num[endIndex], we couldn't sure the position of minimum in
				    // mid's left or right, so just let upper bound reduce one.
				endIndex--;  // for handling the duplicate entries
				
			}
		}
		return nums[startIndex];
	}
}
