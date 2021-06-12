package com.yuva.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
Bloomberg Interview Question
 * Input a = [21,5,6,56,88,52], output = [5,5,5,4,-1,-1] . Output array values is made up of indices of the element with value greater 
 * than the current element but with largest index. So 21 < 56 (index 3), 21 < 88 (index 4) but also 21 < 52 (index 5) 
 * so we choose index 5 (value 52). Same applies for 5,6 and for 56 its 88 (index 4). If there is no greater element 
 * then use -1 and last element of the array will always have value of -1 in output array since there is no other elment after it
 * @author Yuvaraja Kanagarajan
 *
 */
public class FindMaxGreaterIndex {

	public static void main(String[] args) {
		int[] arr = new int[] { 21, 5, 6, 56, 88, 52 };
		int[] res = new int[arr.length];
		Arrays.fill(res, -1);

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
				(i1, i2) -> i1[0] == i2[0] ? Integer.compare(i2[1], i1[1]) : Integer.compare(i2[0], i1[0]));
		for (int i = 0; i < arr.length; i++)
			maxHeap.add(new int[] { arr[i], i });

		// 21, 5, 6, 56, 88, 52
		// [88, 4], [56, 3], [52, 5], [21, 0], [6, 2], [5, 1]
		// maxIdx = 5
		// res = {5, 5, 5, 4, -1, -1}
		int maxIdx = -1;
		while (!maxHeap.isEmpty()) {
			int[] curr = maxHeap.poll();
			int currIdx = curr[1];
			// Uninitialized - only once
			if (maxIdx == -1) {
				maxIdx = currIdx;
			} else {
				if (currIdx > maxIdx)
					maxIdx = currIdx;
				else
					res[currIdx] = maxIdx;
			}
		}

		for (int r : res)
			System.out.println(r);

	}
	
}
