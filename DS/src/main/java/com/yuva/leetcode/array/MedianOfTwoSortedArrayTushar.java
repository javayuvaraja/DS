package com.yuva.leetcode.array;

public class MedianOfTwoSortedArrayTushar {

	public double findMedianSortedArrays(int arr1[], int arr2[]) {
		// if input1 length is greater than switch them so that input1 is smaller than
		// input2.
		if (arr1.length > arr2.length) {
			return findMedianSortedArrays(arr2, arr1);
		}
		int arrLen1 = arr1.length;
		int arrLen2 = arr2.length;

		int start = 0;
		int end = arrLen1;
		while (start <= end) {
			int partitionX = (start + end) / 2;
			int partitionY = (arrLen1 + arrLen2 + 1) / 2 - partitionX;

			// if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
			// if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
			int minRightX = (partitionX == arrLen1) ? Integer.MAX_VALUE : arr1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
			int minRightY = (partitionY == arrLen2) ? Integer.MAX_VALUE : arr2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median
				// in case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((arrLen1 + arrLen2) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { // we are too far on right side for partitionX. Go on left side.
				end = partitionX - 1;
			} else { // we are too far on left side for partitionX. Go on right side.
				start = partitionX + 1;
			}
		}

		// Only we we can come here is if input arrays were not sorted. Throw in that
		// scenario.
		throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		int[] x = { 1, 3, 8, 9, 15 };
		int[] y = { 7, 11, 19, 21, 18, 25 };

		MedianOfTwoSortedArrayTushar mm = new MedianOfTwoSortedArrayTushar();
		mm.findMedianSortedArrays(x, y);
	}
}
