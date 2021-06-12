package com.yuva.leetcode.string;

import java.util.Arrays;

public class NextGreaterNumberPermutation {

	/*
	 * Logic : 1. Find the swap index
	 *         2. Find the next greater element than the swap index element from the end
	 *         3. Swap the element
	 *         4. Sort after swapingindex+1 
	 *
	 */
	public  void nextPermutation(int[] nums) {
        int swapIndex = -1;
        for (int i= nums.length-1; i >0; i--) {
        	if (nums [i] > nums[i-1]) {
        		swapIndex = i-1;
        		break;
        	}
        }
        // Completely ascending then reverse number
        if (swapIndex==-1) {
        	reverse(nums);
        } else {
        	int nextGreatIndex = getNextGreaterElement(nums, swapIndex);
        	int temp = nums[nextGreatIndex];
        	nums[nextGreatIndex] = nums[swapIndex];
        	nums[swapIndex] = temp;
        	
        	// sort the remaining digits
        	Arrays.sort(nums, swapIndex+1, nums.length);
        }
    }
	private int getNextGreaterElement(int nums[], int index) {
		for (int i= nums.length-1; i > index ; i--) {
			if (nums[i] > nums[index]) {
				return i;
			}
		}
		return -1;
	}
	private void reverse (int nums[]) {
		int start = 0; 
		int end = nums.length-1;
		while (start < end) {
			int temp = nums [start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}
}
