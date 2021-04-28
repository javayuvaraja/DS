package com.yuva.leetcode.array;

import java.util.Arrays;

/**

Leetcode : 238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i]
is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
 * @author Yuvaraja Kanagarajan
 *
 */
public class ProductOfArrayExceptSelf {
	 public int[] productExceptSelf(int[] nums) {
	        int length = nums.length;
	        int left[] = new int[length];
	        int right[] = new int[length];
	        Arrays.fill(left, 1);
	        Arrays.fill(right, 1);
	        
	        for (int i = 1; i < length; i++) {
	            left[i] = left[i-1]* nums[i-1];
	        }
	        
	        for (int i= length-2; i>=0;  i--) {
	            right[i]= right[i+1] * nums[i+1];
	        }
	        
	        int result[] = new int[length];
	        for (int i = 0; i < length; i++) {
	            result[i] = left[i]* right[i];
	        }
	        return result;
	    }
}
