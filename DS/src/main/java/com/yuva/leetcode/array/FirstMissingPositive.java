package com.yuva.leetcode.array;

/**
 * 
41. First Missing Positive

Given an unsorted integer array nums, find the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

Example 1:
Input: nums = [1,2,0]
Output: 3

Example 2:
Input: nums = [3,4,-1,1]
Output: 2

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1

 * @author Yuvaraja Kanagarajan
 *
 */
public class FirstMissingPositive {

	/*
	 * This solution requires o(n) space complexity. 
	 */
	public int firstMissingPositive1(int[] nums) {
        boolean result[] = new boolean[nums.length+1];
        for(int temp : nums) {
            if (temp >= 0 && temp <= nums.length) {
                result[temp] = true;
            }
        }
        for(int i=1; i < result.length; i++) {
            if (!result[i]) {
                return i;
            }
        }
        return nums.length+1;
    }
	
	/*
	 * 
	 */
	
	public int firstMissingPositive(int[] nums) {
	    int n = nums.length;
	    for(int i = 0; i < n; i++) {
	        while(nums[i] > 0 && nums[i] <= n 
	        		&& nums[i] != nums[nums[i] - 1]) { // Ex : nums[i]=3, then checking nums[2]!=3, then swap
	            swap(nums, i, nums[i] - 1);
	        }
	    }
	    for(int i = 0; i < n; i++)
	        if(nums[i] != i + 1)
	            return i + 1;
	    return n + 1;
	}

	
	private void swap(int[] nums, int i, int j) {
	    nums[i] ^= nums[j];
	    nums[j] ^= nums[i];
	    nums[i] ^= nums[j];
	}
	
	public static void main(String[] args) {
		int arr[]= {3,4,-1,1};
		
		FirstMissingPositive obj = new FirstMissingPositive();
		System.out.println(obj.firstMissingPositive(arr));
		
	}
}
