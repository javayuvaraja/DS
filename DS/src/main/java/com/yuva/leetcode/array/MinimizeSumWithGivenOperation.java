package com.yuva.leetcode.array;

import com.yuva.leetcode.tree.CountUniValueTree;

/**

Minimum possible sum of array elements after performing the given operation
Difficulty Level : Basic
Given an array arr[] of positive integers and an integer x, the task is to minimize the sum 
of elements of the array after performing the given operation at most once. 
In a single operation, any element from the array can be divided by x (if it is divisible by x) 
and at the same time, any other element from the array must be multiplied by x.
Examples: 
 

Input: arr[] = {1, 2, 3, 4, 5}, x = 2 
Output: 14 
Multiply 1 by x i.e. 1 * 2 = 2 
Divide 4 by x i.e. 4 / 2 = 2 
And the updated sum will be 2 + 2 + 3 + 2 + 5 = 14
Input: arr[] = {5, 5, 5, 5, 6}, x = 3 
Output: 26 
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class MinimizeSumWithGivenOperation {

	/* 
	 * Logic  : find the maxDivisible number and find min number for product
	 */
	static int minSum(int arr[], int x ){
		int maxDivisible = -1;
		int minNum = arr[0];
		int currSum = 0;
		for (int i=0; i < arr.length;i++) {
			currSum = currSum + arr[i];
			
			if (arr[i]%x==0 && arr[i] > maxDivisible) {
				maxDivisible = arr[i];
			}
			
			if (minNum > arr[i]) {
				minNum = arr[i];
			}
		}
		
		// none of the elements are divisible 
		if (maxDivisible==-1) {
			return -1;
		}
		
		currSum = currSum + (minNum*x-minNum);
		
		minNum = minNum * x;
		maxDivisible = Math.max(minNum, maxDivisible);
		
		// Logic 
		// 100+20 = 120 , when divide 100/10 = 10, 100-10 => 90, 120-90=30
		currSum = currSum - (maxDivisible- (maxDivisible/x));
		return currSum;
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 5, 5, 5, 6};
		int x = 3;
		System.out.println(minSum(arr, x));
	}
}