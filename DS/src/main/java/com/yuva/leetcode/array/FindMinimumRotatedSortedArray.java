package com.yuva.leetcode.array;

/**
 * 153. Find Minimum in Rotated Sorted Array

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

 * @author Yuvaraja Kanagarajan
 *
 */
public class FindMinimumRotatedSortedArray {

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
			if (nums[mid] < nums[endIndex]) {
				endIndex = mid;
			} else {
				startIndex = mid + 1;
			}
		}
		return nums[startIndex];
	}
	
	public static void main(String[] args) {
		int nums[] = {4,5,6,7,0,1,2};
		FindMinimumRotatedSortedArray obj = new FindMinimumRotatedSortedArray();
		System.out.println(obj.findMin(nums));
	}
}
