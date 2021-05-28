package com.yuva.leetcode.array;

import java.util.PriorityQueue;

/**

Minimize Sum of an Array by at most K reductions
Given an array of integers arr[] consisting of N integers, the task is to minimize the 
sum of the given array by performing at most K operations, where each operation involves 
reducing an array element arr[i] to floor(arr[i]/2).

Examples :
Input: N = 4, a[] = {20, 7, 5, 4}, K = 3 
Output: 17 
Explanation: 
Operation 1: {20, 7, 5, 4} -> {10, 7, 5, 4} 
Operation 2: {10, 7, 5, 4} -> {5, 7, 5, 4} 
Operation 3: {5, 7, 5, 4} -> {5, 3, 5, 4} 
No further operation can be performed. Therefore, sum of the array = 17.

Input: N = 4, a[] = {10, 4, 6, 16}, K = 2 
Output: 23
 * @author Yuvaraja Kanagarajan
 *
 */
public class MinimizeSumMostKReductions {

	public static int minimizeSum(int arr[], int k) {
		int sum = 0;
		// Max heap implementation
		PriorityQueue<Integer> numHeap = new PriorityQueue<Integer>((num1, num2) -> num2 - num1);

		for (int temp : arr) {
			numHeap.add(temp);
		}

		int opCount = 0;

		while (opCount < k) {
			int currNum = numHeap.poll();
			double temp = (double) currNum;
			temp = Math.floor(temp / 2);
			currNum = (int) temp;
			numHeap.add(currNum);
			opCount++;
		}

		while (!numHeap.isEmpty()) {
			sum = sum + numHeap.poll();
		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[] = {10, 4, 6, 16};
		int K = 2;
		System.out.println(minimizeSum(arr, K));
	}

}
