package com.yuva.leetcode.stack;

import java.util.Stack;

/**
 * 907. Sum of Subarray Minimums

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. 
Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 
 * @author Yuvaraja Kanagarajan
 *
 */
public class SumofSubarrayMins {

	public static int sumSubarrayMins(int[] A) {
		int len = A.length;
		Stack<Integer> stack = new Stack<>();
		int[] left = new int[len];
		int[] right = new int[len];
		for (int i = 0; i < A.length; i++) {
			left[i] = i + 1;
			right[i] = len - i;
		}
		// previous less element
		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
				stack.pop();
			}
			left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
			stack.push(i);
		}
		//left = [1, 1, 2, 1, 4, 1, 1, 8]
		// next less element
		stack.clear();
		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
				right[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			stack.push(i);
		}
		//right = [7, 1, 2, 1, 3, 2, 1, 1]
		int ans = 0;
		//int mod = (int) 1e9 + 7;
		for (int i = 0; i < len; i++) {
			//ans = (ans + A[i] * left[i] * right[i]) % mod;
			ans = (ans + A[i] * left[i] * right[i]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int arr[]= {2, 9, 7, 8, 3, 4, 6, 1};
		System.out.println(sumSubarrayMins(arr));
	}
}
