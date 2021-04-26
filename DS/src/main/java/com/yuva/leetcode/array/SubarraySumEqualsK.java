package com.yuva.leetcode.array;

import java.util.HashMap;
import java.util.Map;

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

	public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
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
		int arr[] = {1,1,1};
		int k = 2;
		System.out.println(new SubarraySumEqualsK().subarraySum(arr, k));
	}
}
