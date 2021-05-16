package com.yuva.leetcode.array;

/**
 * Given two arrays, find two elements (one in each array) such that their difference is minimum
 * @author Yuvaraja Kanagarajan
 *
 */
public class MinDiffTwoSortedArray {

	public int getMinDiff (int arr1[], int arr2[]) {
		int minDiff = Integer.MAX_VALUE;
		int i=0;
		int j= 0;
		while (i < arr1.length && j < arr2.length ) {
			int diff = Math.abs(arr1[i]-arr2[j]);
			minDiff = Math.min(minDiff, diff);
			if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}
		
		return minDiff;
	}
}
