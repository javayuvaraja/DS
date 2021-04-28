package com.yuva.leetcode.array;

/**
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. 
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
		if (end >= start) {
			int mid = (start + end) / 2;
			if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target)
				return mid;
			else if (target > arr[mid])
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
		if (end >= start) {
			int mid = (start + end) / 2;
			if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target)
				return mid;
			else if (target < arr[mid])
				return last(arr, start, mid - 1, target);
			else
				return last(arr, mid + 1, end, target);
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 2, 3, 3, 3, 3 };

		// Element to be counted in arr[]
		int x = 0;
		int c = count(arr, x);
		System.out.println(x + " occurs " + c + " times");
	}
}
