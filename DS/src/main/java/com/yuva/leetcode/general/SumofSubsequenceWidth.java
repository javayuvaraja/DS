package com.yuva.leetcode.general;

import java.util.Arrays;

/**
 891. Sum of Subsequence Widths

The width of a sequence is the difference between the maximum and minimum elements in the sequence.

Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums. 
Since the answer may be very large, return it modulo 109 + 7.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order
 of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [2,1,3]
Output: 6
Explanation: The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.
Example 2:

Input: nums = [2]
Output: 0
 * @author Yuvaraja Kanagarajan
 *
 */
public class SumofSubsequenceWidth {

	public long sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        long ans = 0;
        long d= 1;
        for (int i=0; i < A.length; i++) {
        	ans =  (ans + (A[i]- A[n-i-1]) * d);
        	d = d * 2;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		//int arr[]= {0,3,1,6,2,2,7};
		int arr[]= {2, 1, 3};
		SumofSubsequenceWidth obj = new SumofSubsequenceWidth();
		System.out.println(obj.sumSubseqWidths(arr));
	}
}
