package com.yuva.leetcode.array;

/**
 * 
81. Search in Rotated Sorted Array II

 There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) \
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., 
nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] 
might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, 
or false if it is not in nums.

 * @author Yuvaraja Kanagarajan
 *
 */
public class RotatedSearchArrayII {

	public boolean search(int[] arr, int target) {
	    int start= 0;
	    int end= arr.length - 1;
	    while (start<= end) {
	        int mid = (start+ end) / 2;
	        if (target == arr[mid]) {
	            return true;
	        } 
	        if (arr[start] < arr[mid]) {
	        	if (arr[start] <= target && arr[mid] > target) {
	                end= mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        } else if(arr[start] == arr[mid]){  // for duplicates
	            start++;
	        }else{
	            if (arr[mid]  < target && arr[end] >=target ) {
	                start= mid + 1;
	            } else {
	                end= mid - 1;
	            }
	        }
	    }
	    return false;
	}
}
