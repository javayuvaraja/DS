package com.yuva.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k
 which is moving from the very left of the array to the very right. 
 You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]

Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
  
 * @author Yuvaraja Kanagarajan
 *
 */
public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int resultIndex = 0;
		for (int currIndex = 0; currIndex < nums.length; currIndex++) {
			// remove out of window elements
			while (!deque.isEmpty() && currIndex - k + 1 > deque.peek()) {
				deque.pollFirst();
			}

			// remove smaller number than the current one
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[currIndex]) {
				deque.pollLast();
			}

			deque.offerLast(currIndex);
			if (currIndex >= k - 1) {
				result[resultIndex++] = nums[deque.peek()];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		int result[] = obj.maxSlidingWindow(arr, 3);
		for (int temp : result ) {
			System.out.print(temp + " ");
		}
	}
}
