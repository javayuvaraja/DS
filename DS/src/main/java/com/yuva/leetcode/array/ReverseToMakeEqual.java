package com.yuva.leetcode.array;

/**
 * Facebook interview Question
 * 
 * Reverse to Make Equal Given two arrays A and B of length N, determine if
 * there is a way to make A equal to B by reversing any subarrays from array B
 * any number of times. Signature
 * 
 * bool areTheyEqual(int[] arr_a, int[] arr_b) Input All integers in array are
 * in the range [0, 1,000,000,000]. Output Return true if B can be made equal to
 * A, return false otherwise. Example A = [1, 2, 3, 4] B = [1, 4, 3, 2] output =
 * true After reversing the subarray of B from indices 1 to 3, array B will
 * equal array A.
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class ReverseToMakeEqual {

	boolean checkReverse(int start, int end, int[] array_a, int[] array_b) {
		while (start < end) {
			if (array_a[start] == array_b[end] && 
				array_b[start] == array_a[end]) {
				start++;
				end--;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	boolean areTheyEqual(int[] array_a, int[] array_b) {
		// Write your code here
		if (array_a.length != array_b.length) {
			return false;
		}

		int start = 0;
		int end = array_a.length - 1;
		boolean isSame = true;

		while (start < end && isSame) {
			isSame = false;
			if (array_a[start] == array_b[start]) {
				start++;
				isSame = true;
			}

			if (array_a[end] == array_b[end]) {
				end--;
				isSame = true;
			}
		}

		return checkReverse(start, end, array_a, array_b);
	}
}
