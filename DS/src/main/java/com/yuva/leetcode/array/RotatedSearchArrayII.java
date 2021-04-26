package com.yuva.leetcode.array;

/**
 * 
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
