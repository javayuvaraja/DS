package com.yuva.leetcode.array;

public class MedianOfSortedArray {

	public double findMedianSortedArrays(int[] arr1, int[] arr2) {
		int result[] = sortArray(arr1, arr2);
		// Arrays.stream(result).forEach(e-> System.out.print( e + " "));

		int mid = result.length / 2;

		if (result.length % 2 == 0) {
			return (double) (result[mid - 1] + result[mid]) / 2;
		} else {
			return (double) result[mid];
		}
	}

	private static int[] sortArray(int arr[], int arr2[]) {
		int result[] = new int[arr.length + arr2.length];
		int resultIndex = 0;
		int index1 = 0;
		int index2 = 0;
		while (index1 < arr.length && index2 < arr2.length) {
			if (arr[index1] > arr2[index2]) {
				result[resultIndex++] = arr2[index2++];
			} else {
				result[resultIndex++] = arr[index1++];
			}
		}
		while (index1 < arr.length) {
			result[resultIndex++] = arr[index1++];
		}
		while (index2 < arr2.length) {
			result[resultIndex++] = arr2[index2++];
		}
		return result;
	}
}
