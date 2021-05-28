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
public class IncreasingDecreasingSubsquenceValidMountainArray {

	/*
	 * This problem is variance of valid mountain array problem. 
	 * 
	 * Determine the kind of order using the first 2 elements of the array
	 * If it is decreasing in the starting then you can perform the same steps 
	 * from the back to determine increasing and then decreasing from back.
	 */
	
	
	public boolean validMountainArray(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) {
        	i++;
        }
        while (j > 0 && A[j - 1] > A[j]) {
        	j--;
        }
        return i > 0 && i == j && j < n - 1;
    }
	
	
	
	public boolean validMountainArray1(int[] arr) {
        boolean isIncreasing = false;
        int currIndex = 1;
        while (currIndex < arr.length && 
              arr[currIndex] > arr[currIndex-1]) {
            isIncreasing = true;
            currIndex++;
        }
        
        if (!isIncreasing) {
            return false;
        }
        
        boolean isDecreasing =  false;
        
        while (currIndex < arr.length && 
              arr[currIndex] < arr[currIndex-1]) {
            isDecreasing = true;
            currIndex++;
        }
        
        return currIndex == arr.length && isDecreasing;
    }
}
