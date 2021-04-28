package com.yuva.leetcode.general;

import java.util.LinkedList;

public class MaximumSubsequenceOf1 {

	
	public static void findLongestSequence1(int[] A, int k) {
		LinkedList<Integer> zeroIndexList = new LinkedList<>();
		int start = 0;
		int maxLen = 0;
		int zeroCount = 0;
		for (int i=0; i < A.length; i++) {
			if (A[i]==0) {
				zeroIndexList.add(i);
				zeroCount++;
			}
			
			if (zeroCount>k) {
				start=zeroIndexList.getFirst()+1;
				zeroIndexList.removeFirst();
				zeroCount--;
			}
			if (i-start+1>maxLen) {
				maxLen = i-start+1;
			}
		}
		System.out.println(maxLen);
	}
	
	// Function to find the maximum sequence of continuous 1's by replacing
	// at most `k` zeroes by 1 using sliding window technique
	public static void findLongestSequence(int[] A, int k) {
		int left = 0; // represents the current window's starting index
		int count = 0; // stores the total number of zeros in the current window
		int window = 0; // stores the maximum number of continuous 1's found
						// so far (including `k` zeroes)

		// store left index of max window found so far
		int leftIndex = 0;

		// maintain a window `[left…right]` containing at most `k` zeroes
		for (int right = 0; right < A.length; right++) {
			// if the current element is 0, increase the count of zeros in the
			// current window by 1
			if (A[right] == 0) {
				count++;
			}

			// the window becomes unstable if the total number of zeros in it becomes
			// more than `k`
			while (count > k) {
				// if we have found zero, decrement the number of zeros in the
				// current window by 1
				if (A[left] == 0) {
					count--;
				}

				// remove elements from the window's left side till the window
				// becomes stable again
				left++;
			}

			// when we reach here, window `[left…right]` contains at most
			// `k` zeroes, and we update max window size and leftmost index
			// of the window
			if (right - left + 1 > window) {
				window = right - left + 1;
				leftIndex = left;
			}
		}

		// print the maximum sequence of continuous 1's
		System.out.println("The longest sequence has length " + window + " from index " + leftIndex + " to "
				+ (leftIndex + window - 1));
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0 };
		int k = 0;

		findLongestSequence(A, k);
		findLongestSequence1(A, k);
	}
}
