package com.yuva.leetcode.array;

/**
 * 413. Arithmetic Slices

An integer array is called arithmetic if it consists of at least three elements 
and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.


 * @author Yuvaraja Kanagarajan
 *
 */
public class ArithmeticSlices {

	public int numberOfArithmeticSlices(int[] A) {
	    int curr = 0, sum = 0;
	    for (int i=2; i < A.length; i++)
	        if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
	            curr += 1;
	            sum += curr;
	        } else {
	            curr = 0;
	        }
	    return sum;
	}
}
