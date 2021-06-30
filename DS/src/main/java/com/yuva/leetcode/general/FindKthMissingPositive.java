package com.yuva.leetcode.general;

/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindKthMissingPositive {

	public int findKthPositive(int[] nums, int k) {
		int left = 0, right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] - mid <= k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left + k;
	}
	
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,7,11}, k = 1;
		
		FindKthMissingPositive obj = new FindKthMissingPositive();
		System.out.println(obj.findKthPositive(arr, k));
	}
}
