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
  	public static int triangleNumber(int[] A) {
	    Arrays.sort(A);
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
