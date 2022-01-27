package com.yuva.leetcode.dp;

import java.util.Arrays;

/**
 * 45. Jump Game II
Medium

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

 * @author Yuvaraja Kanagarajan
 *
 */
public class JumpGameII {

	public int jump(int[] nums) {
        int result[]= new int[nums.length];
        Arrays.fill (result, Integer.MAX_VALUE);
        result[0] = 0;
        
        for (int j=1; j < nums.length; j++) {
            for (int i=0 ; i < j ; i++) {
                if ( i+nums[i] >= j) {
                    result[j] = Math.min (result[j], result[i]+1);
                    break;
                }
            }
        }
        return result[nums.length-1];
        
    }
}
