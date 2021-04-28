 package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**

560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number 
of continuous subarrays whose sum equals to k.

Input: nums = [1,1,1], k = 2
Output: 2

Input: nums = [1,2,3], k = 3
Output: 2
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class SubarraySumEqualsK {

	/**
	 * Store the preSum with no of occurence of that sum.
	 * Check curr-k exists in the map, if it is there then increment the result.  
	 */
	public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);  // for presum ==k case, 
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
	
	 public static void main(String[] args) {
		int arr[] = {3,4,7,2,-3,1,4,2};
		int k = 7;
		System.out.println(new SubarraySumEqualsK().subarraySum(arr, k));
	}
}
