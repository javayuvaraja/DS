package com.yuva.leetcode.array;

/**
 * Leetcode 33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k 
(0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], 
nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * @author Yuvaraja Kanagarajan
 *
 */
public class RotatedSortedArraySearch {

	public int search(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if (arr[start] <= arr[mid]) { // left side sorted
				if (arr[start] <= target && arr[mid] > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (arr[mid] < target && arr[end] >= target) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}
