package com.yuva.leetcode.array;

/**

Leetcode 34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in ascending order, 
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindFirstAndLastOccurenceSortedArray {

	public int[] searchRange(int[] nums, int target) {
		int start = findFirst(nums, target);
		if (start == -1) {
			return new int[] { -1, -1 };
		}
		int end = findLast(nums, target);
		return new int[] { start, end };
	}

	private int findFirst(int arr[], int target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target && (mid == 0 || arr[mid - 1] < target)) {
				return mid;
			} else if (arr[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private int findLast(int arr[], int target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target && (mid == arr.length - 1 || arr[mid + 1] > target)) {
				return mid;
			} else if (arr[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
