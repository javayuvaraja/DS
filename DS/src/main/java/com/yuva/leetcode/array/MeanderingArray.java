package com.yuva.leetcode.array;

import java.util.Arrays;

/**
Rearrange an array in maximum minimum form

Given a sorted array of positive integers, rearrange the array alternately 
i.e first element should be maximum value, second minimum value, 
third second max, fourth second min and so on. 

Examples: 

Input: arr[] = {1, 2, 3, 4, 5, 6, 7} 
Output: arr[] = {7, 1, 6, 2, 5, 3, 4}

Input: arr[] = {1, 2, 3, 4, 5, 6} 
Output: arr[] = {6, 1, 5, 2, 4, 3} 
 * @author Yuvaraja Kanagarajan
 *
 */
public class MeanderingArray {

	static void rearrange(int[] arr) {
		int temp[] = arr.clone();
		int start = 0, end = arr.length - 1;
		boolean flag = true;

		// Store result in temp[]
		for (int i = 0; i < arr.length - 1; i++) {
			if (flag)
				arr[i] = temp[end--];
			else
				arr[i] = temp[start++];

			flag = !flag;
		}
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6 };

		System.out.println("Original Array ");
		System.out.println(Arrays.toString(arr));
		rearrange(arr);
		System.out.println("Modified Array ");
		System.out.println(Arrays.toString(arr));
	}
}
