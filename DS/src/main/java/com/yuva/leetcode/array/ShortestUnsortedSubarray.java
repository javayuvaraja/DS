package com.yuva.leetcode.array;

/**
581. Shortest Unsorted Continuous Subarray

Given an integer array nums, you need to find one continuous subarray that if you only sort 
this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * @author Yuvaraja Kanagarajan
 *
 */
public class ShortestUnsortedSubarray {

	/*
	 * Logic : Two pointer concept
	 * 			1. Find the index which are lesser than max found from left
	 * 			2. Find the index which are greater than the min from right
	 */
	public int findUnsortedSubarray(int[] A) {
	    int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
	    for (int i=1;i<n;i++) {
	      max = Math.max(max, A[i]);
	      min = Math.min(min, A[n-1-i]);
	      if (A[i] < max) {
	    	  end = i;
	      }
	      if (A[n-1-i] > min) {
	    	  beg = n-1-i; 
	      }
	    }
	    return end - beg + 1;
	}
	
	public static void main(String[] args) {
		int nums[] = {2,6,4,8,10,9,15};
		ShortestUnsortedSubarray obj = new ShortestUnsortedSubarray();
		System.out.println(obj.findUnsortedSubarray(nums));
	}
}
