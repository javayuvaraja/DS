package com.yuva.leetcode.general;

import java.util.Arrays;

/**
611. Valid Triangle Number

Given an integer array nums, return the number of triplets chosen from 
the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
 * @author Yuvaraja Kanagarajan
 *
 */

public class ValidTriangle {
	/*
		Explanation:
		1. our target is a+b>c, so there are two ways to implement 3 pointers method - suppose the three pointers are i, j and k, where i < j < k:
		we fix the first pointer i and make j = i+1, k = n-1, if a[i]+a[j]>a[k], then there are k-j combinations that satisfy a+b>c.
		however, if a[i]+a[j]<=a[k], based on the condition, we have two options: 1) j++, OR 2) k--
		the problems will happen right here - if we are considering all the combinations - the solution is becoming O(N^3) again. 
		if we just simply move j, we are missing the cases where the third pointer between j and k
	*/
	public static int triangleNumber(int[] A) {
	    Arrays.sort(A);
	    // Three sum logic . Fix the last element as K, start=0 and end = K-1;
	    int count = 0, length = A.length;
	    for (int fixed=length-1;fixed>=2;fixed--) {
	        int start = 0, end = fixed-1;
	        while (start < end) {
	            if (A[start] + A[end] > A[fixed]) {
	                count += end-start;
	                end--;
	            } else {
	            	start++;
	            }
	        }
	    }
	    return count;
	}
}
