package com.yuva.leetcode.array;

/**

Leetcode 88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. 
You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

 * @author Yuvaraja Kanagarajan
 *
 */
public class MergeTwoArrays {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int arr1Index = m - 1;
		int arr2Index = n - 1;
		int mergeIndex = nums1.length - 1;

		while (arr1Index >= 0 && arr2Index >= 0) {
			if (nums1[arr1Index] > nums2[arr2Index]) {
				nums1[mergeIndex--] = nums1[arr1Index--];
			} else {
				nums1[mergeIndex--] = nums2[arr2Index--];
			}
		}

		while (arr2Index >= 0) {
			nums1[mergeIndex--] = nums2[arr2Index--];
		}
	}
}
 