package com.yuva.leetcode.array;

/**
941. Valid Mountain Array

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * @author Yuvaraja Kanagarajan
 *
 */
public class ValidMountainArray {

	public boolean validMountainArray(int[] A) {
		int n = A.length, i = 0, j = n - 1;
		while (i + 1 < n && A[i] < A[i + 1])
			i++;
		while (j > 0 && A[j - 1] > A[j])
			j--;
		return i > 0 && i == j && j < n - 1;
	}
}
