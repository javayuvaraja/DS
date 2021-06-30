package com.yuva.leetcode.array;

public class SortArrayByPairity {

	public int[] sortArrayByParity(int[] A) {
		int resultIndex = 0;
		int j = A.length - 1;
		while (resultIndex < j) {
			if (A[resultIndex] % 2 == 0) {
				// Even first
				resultIndex++;
			} else {
				if (A[j] % 2 != 0) {
					// Both odd
					j--;
				}
				if (A[j] % 2 == 0) {
					// Odd, Even
					swap(A, resultIndex, j);
					resultIndex++;
					j--;
				}
			}
		}

		return A;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
