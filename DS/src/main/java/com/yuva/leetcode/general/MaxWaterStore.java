package com.yuva.leetcode.general;

/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class MaxWaterStore {

	// Return the maximum water that can be stored
	static int maxWater(int height[], int n) {

		// To store the maximum water so far
		int max = 0;

		// Both the pointers are pointing at the first
		// and the last buildings respectively
		int left = 0, right = n - 1;

		// While the water can be stored between
		// the currently chosen buildings
		while (left < right) {

			// Update maximum water so far and increment i
			if (height[left] < height[right]) {
				max = Math.max(max, (right - left - 1) * height[left]);
				left++;
			}

			// Update maximum water so far and decrement j
			else if (height[right] < height[left]) {
				max = Math.max(max, (right - left - 1) * height[right]);
				right--;
			}

			// Any of the pointers can be updated (or both)
			else {
				max = Math.max(max, (right - left - 1) * height[left]);
				left++;
				right--;
			}
		}

		return max;
	}

	// Driver code
	public static void main(String[] args) {
		int height[] = { 2, 1, 3, 4, 6, 5 };
		int n = height.length;

		System.out.print(maxWater(height, n));
	}
}
