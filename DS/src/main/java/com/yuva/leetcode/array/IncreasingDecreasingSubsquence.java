package com.yuva.leetcode.array;

/**
 * Facebook Question 

941. Valid Mountain Array

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]


 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class IncreasingDecreasingSubsquence {

	/*
	 * This problem is variance of valid mountain array problem. 
	 * 
	 * Determine the kind of order using the first 2 elements of the array
	 * If it is decreasing in the starting then you can perform the same steps 
	 * from the back to determine increasing and then decreasing from back.
	 */
}
