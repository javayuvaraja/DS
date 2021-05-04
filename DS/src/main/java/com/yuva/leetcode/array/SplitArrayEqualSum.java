package com.yuva.leetcode.array;

/**
 * Given an array of integers greater than zero, find if it is possible to split it in two subarrays 
 * (without reordering the elements), such that the sum of the two subarrays is the same. 
 * Print the two subarrays.
 * @author Yuvaraja Kanagarajan
 *
 */
public class SplitArrayEqualSum {

	
	/**
	 * first compute the sum of the whole array from left to right. Now we traverse array from right 
	 * and keep track of right sum, 
	 * left sum can be computed by subtracting current element from whole sum. 
	 */
	static int findSplitPoint(int arr[], int n) {
		int leftSum = 0;

		for (int i = 0; i < n; i++)
			leftSum += arr[i];

		int rightSum = 0;

		for (int i = n - 1; i >= 0; i--) {
			rightSum += arr[i];
			leftSum -= arr[i];

			if (rightSum == leftSum) 
				return i;
		}

		// if it is not possible to split array
		// into two parts.
		return -1;
	}
	
	
	static void printTwoParts(int arr[], int n) {
		int splitPoint = findSplitPoint(arr, n);

		if (splitPoint == -1 || splitPoint == n) {
			System.out.println("Not Possible");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (splitPoint == i)
				System.out.println();

			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 5 };
		int n = arr.length;

		printTwoParts(arr, n);

	}
}
