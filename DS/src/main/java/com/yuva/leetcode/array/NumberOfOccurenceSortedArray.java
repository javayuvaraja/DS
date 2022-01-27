package com.yuva.leetcode.array;

/**
 * Given a sorted array arr[] and a number x, 
 * write a function that counts the occurrences of x in arr[]. 
 * Expected time complexity is O(Logn) 
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class NumberOfOccurenceSortedArray {


	static int count(int arr[], int target) { 

		int start = first(arr, 0, arr.length-1, target);

		if (start == -1)
			return start;

		int last = last(arr, start, arr.length-1, target);

		return last - start + 1;
	}

	/*
	 * if x is present in arr[] then returns the index of FIRST occurrence of x in
	 * arr[0..n-1], otherwise returns -1
	 */
	static int first(int arr[], int start, int end, int target) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target)
				return mid;
			else if (arr[mid] < target )
				return first(arr, mid + 1, end, target);
			else
				return first(arr, start, mid - 1, target);
		}
		return -1;
	}

	/*
	 * if x is present in arr[] then returns the index of LAST occurrence of x in
	 * arr[0..n-1], otherwise returns -1
	 */
	static int last(int arr[], int start, int end, int target) {
		if ( start <= end) {
			int mid = (start + end) / 2;
			if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target)
				return mid;
			else if (arr[mid] > target)
				return last(arr, start, mid - 1, target);
			else
				return last(arr, mid + 1, end, target);
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 2, 3, 3, 3, 3 };

		// Element to be counted in arr[]
		int x = 2;
		int c = count(arr, x);
		System.out.println(x + " occurs " + c + " times");
		
		System.out.println(x + " occurs " + occurCount(arr, x) + " times");
		
	}
	
	static int occurCount (int arr[], int target) {
		int left = binarySearch(arr, target, true);
	    if (left < 0) return 0;
	    int right = binarySearch(arr, target, false);
	    return right-left+1;
	}
	
	static int binarySearch(int[] arr, int target, boolean leftmost) {
	    int lo = 0;
	    int hi = arr.length - 1;
	    int idx = -1;
	    while (lo <= hi) {
	        int mid = (lo+hi)/2; // avoid overflow. same as (lo + hi) / 2
	        if (target > arr[mid]) {
	            lo = mid + 1;
	        } else if (target < arr[mid]) {
	            hi = mid - 1;
	        } else {
	            idx = mid;
	            if (leftmost) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        }
	    }
	    return idx;
	}
}
