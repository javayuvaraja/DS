package com.yuva.leetcode.array;

public class FirstGreaterElementBinarySearch {

	public static void main(String[] args) {
		  int[] arr = { 1, 2, 3, 5, 8, 12 };
	      System.out.println(getGreaterIndex(arr, 4));
	}
	
	
	public static int getGreaterIndex(int arr[], int target) {
		int start = 0;
		int end =  arr.length-1;
		int ans =-1;
		
		while (start<=end) {
			int mid = (start+end)/2;
			if (arr[mid] <= target) {
				start = mid+1;
			} else {
				end = mid-1;
				ans = mid;
			}
		}
		return ans;
	}
}
