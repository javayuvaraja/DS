package com.yuva.leetcode.array;

/**
 * 665. Non-decreasing Array

Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

Example 2:
Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 * @author Yuvaraja Kanagarajan
 *
 */
public class NonDecreasingArray {

	/**
	 * Think 
	 * a[i-2] black
	 * a[i-2] green 
	 * a[i]  blue
	 * 
	 * Decide whether i has to move up or i-1 has to move down based on the comparison with i and i-2
	 * @param nums
	 * @return
	 */
	public boolean checkPossibility(int[] nums) {
        int modified = 0;
        
        for (int i =1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                if (i==1 || nums[i-2] <= nums[i]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
                modified++;
                
                if (modified == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
