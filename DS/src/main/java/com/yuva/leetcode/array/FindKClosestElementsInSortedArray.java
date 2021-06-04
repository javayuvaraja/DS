package com.yuva.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindKClosestElementsInSortedArray {

	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
		int lo = 0;
		int hi = arr.length - 1;
		while (hi - lo >= k) {
			if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
				lo++;
			} else {
				hi--;
			}
		}
		List<Integer> result = new ArrayList<>(k);
		for (int i = lo; i <= hi; i++) {
			result.add(arr[i]);
		}
		return result;
	}

	public List<Integer> findClosestElements(int[] A, int k, int x) {
		int left = 0, right = A.length - k;
		while (left < right) {
			int mid = (left + right) / 2;
			if (x - A[mid] > A[mid + k] - x)
				left = mid + 1;
			else
				right = mid;
		}
		return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		FindKClosestElementsInSortedArray obj = new FindKClosestElementsInSortedArray();
		int arr[]= {10,15,18,21,25,31,43,70};
		List<Integer> result = obj.findClosestElements(arr, 4,24);
		System.out.println(result);
		
	}
}
